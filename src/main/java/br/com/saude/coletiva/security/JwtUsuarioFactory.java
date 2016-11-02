package br.com.saude.coletiva.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.saude.coletiva.model.Permissao;
import br.com.saude.coletiva.model.Usuario;

public class JwtUsuarioFactory {

	private JwtUsuarioFactory(){
		
	}
	
	public static JwtUsuario create(Usuario user){
		return new JwtUsuario(
				user.getNome(), 
				user.getPassword(), 
				user.getEmail(), 
				mapToGrantedAuthorities(user.getPermissoes()), 
				user.getEnabled(), 
				user.getLastPasswordResetDate()
		);
	}
	
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(List<Permissao> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRole().name()))
                .collect(Collectors.toList());
    }
}
