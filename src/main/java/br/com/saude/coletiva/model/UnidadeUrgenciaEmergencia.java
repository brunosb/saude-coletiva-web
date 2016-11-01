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

	private static final long serialVersionUID = 1L;

	@NotNull
	private String nome;
	
	@Column(unique = true, name = "coordenada")
	private String enderecoCoordenada;
	
	@Column(name = "postal")
	private String enderecoPostal;
	
	@NotNull
	private String especialidade;

	public UnidadeUrgenciaEmergencia(String nome, String enderecoCoordenada, String enderecoPostal,
			String especialidade) {
		super();
		this.nome = nome;
		this.enderecoCoordenada = enderecoCoordenada;
		this.enderecoPostal = enderecoPostal;
		this.especialidade = especialidade;
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

	public String getEnderecoCoordenada() {
		return enderecoCoordenada;
	}

	public void setEnderecoCoordenada(String enderecoCoordenada) {
		this.enderecoCoordenada = enderecoCoordenada;
	}

	public String getEnderecoPostal() {
		return enderecoPostal;
	}

	public void setEnderecoPostal(String enderecoPostal) {
		this.enderecoPostal = enderecoPostal;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	
}
