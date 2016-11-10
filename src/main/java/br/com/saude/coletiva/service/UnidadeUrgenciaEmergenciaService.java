package br.com.saude.coletiva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.saude.coletiva.model.UnidadeUrgenciaEmergencia;
import br.com.saude.coletiva.repository.UnidadeUrgenciaEmergenciaRepository;
import br.com.saude.coletiva.utils.Paths;
import br.com.saude.coletiva.utils.ServiceGeneric;

@RestController
@RequestMapping(value = Paths.URGENCIA_EMERGENCIA_PATH)
public class UnidadeUrgenciaEmergenciaService extends ServiceGeneric<UnidadeUrgenciaEmergencia, Long>{

	@Autowired
	public UnidadeUrgenciaEmergenciaRepository unidadeUrgenciaEmergenciaRepositorio;
	
	@RequestMapping(value="{/tipo}",method = RequestMethod.GET)
	public List<UnidadeUrgenciaEmergencia> findTipos(@PathVariable String tipo){
		return this.unidadeUrgenciaEmergenciaRepositorio.findByTipo(tipo);
	}
}
