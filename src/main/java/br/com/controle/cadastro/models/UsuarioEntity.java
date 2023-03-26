package br.com.controle.cadastro.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.controle.acesso.models.RoleEntity;

@EnableJpaRepositories
@Entity
@Table(name = "usuario", schema = "cadastro")
public class UsuarioEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String cpf;
	private String cnpj;
	private String ie;
	private Date nascimento;
	private String nome;
	private String email;
	private String cep;
	private String endereco;
	private String numero;
	private String bairro;
	private String cidade;
	private String uf;
	private Date dataRegistro;
	private String fone;
	private SituacaoEntity situacao;
	private Boolean fornecedor;
	private Boolean funcionario;
	private Boolean cliente;
	private Boolean delete;
	private RoleEntity role;
				
	public UsuarioEntity() {
		setDataRegistro(new Date());
		situacao = new SituacaoEntity();
		role = new RoleEntity();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	public Integer getId() {
		return id;
	}
	
	@Column(name = "nome", length = 50)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "endereco", length = 50)
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Column(name = "bairro", length = 30)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(name = "cidade", length = 30)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	@Column(name = "registro")
	public Date getDataRegistro() {
		return dataRegistro;
	}
	
	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	@Column(name = "fone")
	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	@Column(name = "cep")
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name = "uf")
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@OneToOne
	@JoinColumn(name ="id_situacao")
	public SituacaoEntity getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEntity situacao) {
		this.situacao = situacao;
	}


	public void setId(Integer id) {
		this.id = id;
	}
		
	@Column(name= "cpf", length = 11)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Column(name = "nascimento", length = 20)
	public Date getNascimento() {			
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	@Column(name = "fornecedor")
	public Boolean getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Boolean fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Column(name = "funcionario")
	public Boolean getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Boolean funcionario) {
		this.funcionario = funcionario;
	}

	@Column(name = "cliente")
	public Boolean getCliente() {
		return cliente;
	}

	public void setCliente(Boolean cliente) {
		this.cliente = cliente;
	}

	@Column(name = "cnpj")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "ie")
	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	@Column(name = "numero")
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(name = "deletado")
	public Boolean getDelete() {
		return delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	@OneToOne
	@JoinColumn(name ="id_role")
	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, cliente, cnpj, cpf, dataRegistro, delete, email, endereco, fone,
				fornecedor, funcionario, id, ie, nascimento, nome, numero, role, situacao, uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEntity other = (UsuarioEntity) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(cnpj, other.cnpj) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(dataRegistro, other.dataRegistro) && Objects.equals(delete, other.delete)
				&& Objects.equals(email, other.email) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(fone, other.fone) && Objects.equals(fornecedor, other.fornecedor)
				&& Objects.equals(funcionario, other.funcionario) && Objects.equals(id, other.id)
				&& Objects.equals(ie, other.ie) && Objects.equals(nascimento, other.nascimento)
				&& Objects.equals(nome, other.nome) && Objects.equals(numero, other.numero)
				&& Objects.equals(role, other.role) && Objects.equals(situacao, other.situacao)
				&& Objects.equals(uf, other.uf);
	}

	
	
}
