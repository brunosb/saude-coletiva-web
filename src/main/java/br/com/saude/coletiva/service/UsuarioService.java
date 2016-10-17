package br.com.saude.coletiva.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.saude.coletiva.model.Usuario;
import br.com.saude.coletiva.utils.Paths;
import br.com.saude.coletiva.utils.ServiceGeneric;

@RestController
@RequestMapping(path = Paths.USER_PATH)
public class UsuarioService extends ServiceGeneric<Usuario, Long>{

}
