package br.com.controle.acesso.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.controle.acesso.DAO.IEnviarEmailDAO;
import br.com.controle.acesso.models.EnviarEmailEntity;
import br.com.controle.acesso.services.IEnviarEmailService;

@Service
public class EnviarEmailServiceImpl implements IEnviarEmailService {
	
	@Autowired
	private IEnviarEmailDAO dao;

	@Override
	public EnviarEmailEntity salvar(EnviarEmailEntity enviarEmail) {
		return dao.save(enviarEmail);
	}

	@Override
	public void excluir(EnviarEmailEntity enviarEmail) {
		dao.delete(enviarEmail);
	}

	@Override
	public List<EnviarEmailEntity> getAll() {
		return dao.findAll();
	}

	@Override
	public EnviarEmailEntity getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public void enviarEmail(EnviarEmailEntity enviarEmail) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.office365.com"); 
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("danilo-adm@hotmail.com", "Danjs1985");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("danilo-adm@hotmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(enviarEmail.getDestinatario()));
            message.setSubject(enviarEmail.getAssunto());
            message.setText(enviarEmail.getConteudo());

            Transport.send(message);

            enviarEmail.setEnviado(Boolean.TRUE);
            enviarEmail.setStatus("E-mail enviado com sucesso");
            salvar(enviarEmail);
        } catch (MessagingException e) {
        	enviarEmail.setStatus("Erro ao enviar e-mail: " + e.getMessage());
            salvar(enviarEmail);
        }
		
	}

	@Override
	public List<EnviarEmailEntity> getAllEmailNaoEnviado() {
		return dao.getAllEmailNaoEnviado();
	}

	@Override
	@Scheduled(fixedRate = 60000)
	public void enviaEmailAutomatico() {
		List<EnviarEmailEntity> listaEnviarEmail = new ArrayList<>();
		listaEnviarEmail.addAll(getAllEmailNaoEnviado());
		if(!listaEnviarEmail.isEmpty()) {
			for (EnviarEmailEntity enviarEmail : listaEnviarEmail) {
				enviarEmail(enviarEmail);
			}
		}
	}

	@Override
	public void esqueceuSenha(String email) {

		EnviarEmailEntity emails = new EnviarEmailEntity();
		
		emails.setAssunto("Recuperar senha");
		emails.setDestinatario(email);
		emails.setEnviado(false);
		
		String corpo = "";
		
		
	}
		

}
