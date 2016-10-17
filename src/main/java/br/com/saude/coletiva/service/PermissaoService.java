package br.com.saude.coletiva.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.saude.coletiva.model.Permissao;
import br.com.saude.coletiva.utils.Paths;
import br.com.saude.coletiva.utils.ServiceGeneric;

@RestController
@RequestMapping(path = Paths.PERMISSION_PATH)
public class PermissaoService extends ServiceGeneric<Permissao, Long>{

}
