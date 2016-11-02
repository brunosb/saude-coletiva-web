package br.com.saude.coletiva.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("protected")
public class MethodProtected {
	/**
	* Este é um exemplo de alguns tipos diferentes de restrição granular para pontos finais. Você pode usar as expressões SPEL embutidos
    * Em @PreAuthorize como "hasRole () 'para determinar se um usuário tem acesso. Lembre-se que a expressão hasRole assume uma
    * Prefixo 'ROLE_' em todos os nomes de função. So 'admin' aqui é realmente armazenado como 'ROLE_ADMIN' no banco de dados!
    **/
	
    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getProtectedGreeting() {
        return ResponseEntity.ok("Greetings from admin protected method!");
    }
	
}
