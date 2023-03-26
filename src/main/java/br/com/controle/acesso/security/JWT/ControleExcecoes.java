package br.com.controle.acesso.security.JWT;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.controle.acesso.DTO.ObjetoErroDTO;

@RestControllerAdvice
@ControllerAdvice
public class ControleExcecoes extends ResponseEntityExceptionHandler {
	
	//Captura exeções do projeto
	@ExceptionHandler({Exception.class, RuntimeException.class, Throwable.class})
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ObjetoErroDTO erro = new ObjetoErroDTO();
		
		String msg = "";
		if(ex instanceof MethodArgumentNotValidException) {
			List<ObjectError> lista = ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors();
			for (ObjectError objectError : lista) {
				msg += objectError.getDefaultMessage() + "\n";
			}
		}else {
			msg += ex.getMessage();
		}
		erro.setError(msg);
		erro.setCode(status.value() + " --> " + status.getReasonPhrase());
		
		return new ResponseEntity<Object>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//Capruta erro na parte do banco
	@ExceptionHandler({DataIntegrityViolationException.class, ConstraintViolationException.class, SQLException.class})
	protected ResponseEntity<Object> handleExceptionDateIntegra(Exception ex){
ObjetoErroDTO erro = new ObjetoErroDTO();
		
		String msg = "";
		
		if(ex instanceof SQLException) {
			msg += "Erro de SQL " + ((SQLException) ex).getCause().getCause().getMessage();
		}else if(ex instanceof ConstraintViolationException) {
			msg += "Erro de chave estrangeira " + ((ConstraintViolationException) ex).getCause().getCause().getMessage();
		}else if(ex instanceof DataIntegrityViolationException) {
			msg += "Erro de integridade no banco " + ((DataIntegrityViolationException) ex).getCause().getCause().getMessage();
		}else {
			msg += ex.getMessage();
		}
		
		erro.setError(msg);
		erro.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		
		return new ResponseEntity<Object>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
