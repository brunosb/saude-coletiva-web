package br.com.saude.coletiva.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.saude.coletiva.model.UnidadeUrgenciaEmergencia;
import br.com.saude.coletiva.utils.Paths;
import br.com.saude.coletiva.utils.ServiceGeneric;

@RestController
@RequestMapping(value = Paths.URGENCIA_EMERGENCIA_PATH)
public class UnidadeUrgenciaEmergenciaService extends ServiceGeneric<UnidadeUrgenciaEmergencia, Long>{

	
}
