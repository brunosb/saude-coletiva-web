package br.com.saude.coletiva.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.saude.coletiva.model.Usuario;
import br.com.saude.coletiva.security.JwtUsuario;
import br.com.saude.coletiva.utils.JwtTokenUtil;
import br.com.saude.coletiva.utils.Paths;
import br.com.saude.coletiva.utils.ServiceGeneric;

@RestController
@RequestMapping(path = Paths.USER_PATH)
public class UsuarioService extends ServiceGeneric<Usuario, Long>{

	@Value("${jwt.header}")
	private String tokenHeader;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtUsuario getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUsuario user = (JwtUsuario) userDetailsService.loadUserByUsername(username);
        return user;
    }
}
