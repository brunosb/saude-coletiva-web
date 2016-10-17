package br.com.saude.coletiva.utils;

import java.io.Serializable;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BaseEntity<ID extends Serializable> extends AbstractPersistable<ID> {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void setId(ID id) {
		super.setId(id);
	}
	
	@JsonIgnore
	@Override
	public boolean isNew() {
		return super.isNew();
	}
}
