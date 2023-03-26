package br.com.controle.cadastro.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "produto", schema = "cadastro")
public class ProdutoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String ean;
	private NcmEntity ncm;
	private Integer altura;
	private Integer comprimento;
	private Integer largura;
	private Integer qtdUnidade;
	private Integer qtdEmbalagem;
	private UnidadeMedidaEntity unidadeMedida;
	private String modelo;
	private String partNumber;
	private Integer garantia;
	private MarcaEntity marca;
	private SituacaoEntity situacao;
	private Boolean delete;
	
	public ProdutoEntity() {
		setMarca(new MarcaEntity());
		setSituacao(new SituacaoEntity());
		setNcm(new NcmEntity());
		setUnidadeMedida(new UnidadeMedidaEntity());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@NotBlank
	@Column(name = "nome", length = 50)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@OneToOne
	@JoinColumn(name = "id_marca")
	public MarcaEntity getMarca() {
		return marca;
	}
	public void setMarca(MarcaEntity marca) {
		this.marca = marca;
	}

	@OneToOne
	@JoinColumn(name = "id_situacao")
	public SituacaoEntity getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEntity situacao) {
		this.situacao = situacao;
	}

	@Column(name = "ean")
	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	@OneToOne
	@JoinColumn(name = "id_ncm")
	public NcmEntity getNcm() {
		return ncm;
	}

	public void setNcm(NcmEntity ncm) {
		this.ncm = ncm;
	}
	
	@Column(name = "altura")
	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	@Column(name = "comprimento")
	public Integer getComprimento() {
		return comprimento;
	}

	public void setComprimento(Integer comprimento) {
		this.comprimento = comprimento;
	}

	@Column(name = "largura")
	public Integer getLargura() {
		return largura;
	}

	public void setLargura(Integer largura) {
		this.largura = largura;
	}

	@Column(name = "qtd_un")
	public Integer getQtdUnidade() {
		return qtdUnidade;
	}

	public void setQtdUnidade(Integer qtdUnidade) {
		this.qtdUnidade = qtdUnidade;
	}

	@Column(name = "qtd_emb")
	public Integer getQtdEmbalagem() {
		return qtdEmbalagem;
	}

	public void setQtdEmbalagem(Integer qtdEmbalagem) {
		this.qtdEmbalagem = qtdEmbalagem;
	}

	@OneToOne
	@JoinColumn(name = "id_medida")
	public UnidadeMedidaEntity getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedidaEntity unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	@Column(name = "garantia")
	public Integer getGarantia() {
		return garantia;
	}

	public void setGarantia(Integer garantia) {
		this.garantia = garantia;
	}
	
	@Column(name = "modelo")
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Column(name = "part_number")
	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(altura, comprimento, delete, ean, garantia, id, largura, marca, modelo, ncm, nome,
				partNumber, qtdEmbalagem, qtdUnidade, situacao, unidadeMedida);
	}

	@Column(name = "deletado")
	public Boolean getDelete() {
		return delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoEntity other = (ProdutoEntity) obj;
		return Objects.equals(altura, other.altura) && Objects.equals(comprimento, other.comprimento)
				&& Objects.equals(delete, other.delete) && Objects.equals(ean, other.ean)
				&& Objects.equals(garantia, other.garantia) && Objects.equals(id, other.id)
				&& Objects.equals(largura, other.largura) && Objects.equals(marca, other.marca)
				&& Objects.equals(modelo, other.modelo) && Objects.equals(ncm, other.ncm)
				&& Objects.equals(nome, other.nome) && Objects.equals(partNumber, other.partNumber)
				&& Objects.equals(qtdEmbalagem, other.qtdEmbalagem) && Objects.equals(qtdUnidade, other.qtdUnidade)
				&& Objects.equals(situacao, other.situacao) && Objects.equals(unidadeMedida, other.unidadeMedida);
	}
	
	

	

}
