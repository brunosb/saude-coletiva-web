package br.com.saude.coletiva.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.saude.coletiva.enums.PermissaoNome;
import br.com.saude.coletiva.utils.BaseEntity;

@Entity
@Table(name = "tb_permissao")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class Permissao extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Column(name = "role", length = 50)
	@Enumerated(EnumType.STRING)
	private PermissaoNome role;
	
	@ManyToMany(mappedBy = "permissoes", fetch = FetchType.LAZY)
	private List<Usuario> usuarios;

	public PermissaoNome getRole() {
		return role;
	}

	public void setRole(PermissaoNome role) {
		this.role = role;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}
