package br.com.saude.coletiva.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.saude.coletiva.utils.BaseEntity;

@Entity
@Table(name = "tb_UUE")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class UnidadeUrgenciaEmergencia extends BaseEntity<Long>{

	private static final long serialVersionUID = 1731410271993907487L;

	@Column(name = "nome")
	private String nome;
	
	@Column(unique = true, name = "latitude")
	private String latitude;
	
	@Column(unique = true, name = "longitude")
	private String longitude;
	
	@NotNull
	@Column(unique = true, name = "postal")
	private String enderecoPostal;
	
	@NotNull
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "descricao")
	private String descricao;

	public UnidadeUrgenciaEmergencia(String nome, String latitude, String longitude, String enderecoPostal, String tipo,
			String descricao) {
		super();
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
		this.enderecoPostal = enderecoPostal;
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public UnidadeUrgenciaEmergencia() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getEnderecoPostal() {
		return enderecoPostal;
	}

	public void setEnderecoPostal(String enderecoPostal) {
		this.enderecoPostal = enderecoPostal;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
