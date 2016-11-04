package br.com.saude.coletiva.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.saude.coletiva.model.Usuario;
import br.com.saude.coletiva.repository.UsuarioRepository;
import br.com.saude.coletiva.security.JwtUsuarioFactory;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByEmail(email);
		
		if(usuario == null){
			throw new UsernameNotFoundException(String.format("Usuário não encontrado: '$s'.", usuario));
		}else{
			return JwtUsuarioFactory.create(usuario);
		}
	}

}
