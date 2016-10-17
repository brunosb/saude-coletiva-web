package br.com.saude.coletiva.utils;

import java.io.Serializable;
import java.rmi.ServerException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public abstract class ServiceGeneric<T extends BaseEntity<ID>, ID extends Serializable> implements ServiceMap {

	private final Logger LOGGER = Logger.getLogger(this.getClass());
	
	@Autowired protected JpaRepository<T, ID> genericRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<T> findAll(){
		
		if (this.LOGGER.isDebugEnabled()) {
			this.LOGGER.debug("Requesting all records.");
		}
		
		return this.genericRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public T insert(@RequestBody T entity){
		
		if (this.LOGGER.isDebugEnabled()) {
			this.LOGGER.debug(String.format("Saving the entity [%s].", entity));
		}
		
		entity.setId(null);
		return this.genericRepository.save(entity);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public T update(@RequestBody T entity) throws ServerException{
		this.LOGGER.debug(String.format("Request to update the record [%s].", entity));

		if (entity.getId() == null) {
			String errorMessage = String.format("ID of entity [%s] cannot be null.", entity.getClass());
			this.LOGGER.error(errorMessage);
			throw new ServerException(errorMessage);
		}
		
		return this.genericRepository.save(entity);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestBody T entity){
		
		this.LOGGER.debug(String.format("Request to delete the record [%s].", entity));
		
		this.genericRepository.delete(entity);
	}
	
}
