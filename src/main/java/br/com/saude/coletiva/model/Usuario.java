package br.com.saude.coletiva.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.saude.coletiva.utils.BaseEntity;

@Entity
@Table(name = "tb_usuario")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class Usuario extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;

	@NotNull
	private String nome;
	
	@NotNull
	@Column(unique = true)
	private String email;
	
	@NotNull
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_usuario_permissao", joinColumns = @JoinColumn(name="usuario_id"), inverseJoinColumns = @JoinColumn(name="permissao_id"))
	private List<Permissao> permissoes;

	public Usuario() {
		super();
	}

	public Usuario(String nome, String email, String password, List<Permissao> permissoes) {
		super();
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.permissoes = permissoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	
}
