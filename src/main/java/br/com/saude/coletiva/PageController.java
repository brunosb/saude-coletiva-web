package br.com.saude.coletiva;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.saude.coletiva.utils.Paths;

@Controller
public class PageController {
	
	@RequestMapping(Paths.HOME_PAGE)
	public String index(){
		return "index";
	}
	
	@RequestMapping(Paths.ADMIN_PAGE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> restrito(){
		return ResponseEntity.ok(null);
	}
}
