package com.gft.petshop.security.jwt;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gft.petshop.model.entities.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {
	
	@Value("${security.jwt.expiracao}")
	private String expiracao;
	
	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	// ----------------------------------------------------------------------------------------------
	
	public String gerarToken(Usuario usuario) {
		
		long expirar = Long.valueOf(expiracao);
		
		LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expirar);
		Date dataDeExpirar = Date.from(dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant());
		
		return Jwts.builder()
				.setSubject(usuario.getLogin())
				.setExpiration(dataDeExpirar)
				.signWith(SignatureAlgorithm.HS512, chaveAssinatura)
				.compact();
		
	}
	
	private Claims obterClaims(String token) throws ExpiredJwtException {
		return Jwts.parser()
				.setSigningKey(chaveAssinatura)
				.parseClaimsJws(token)
				.getBody();
	}
	
	public boolean tokenValido(String token) {
		try {
			Claims claims = obterClaims(token);
			
			Date dataExpiracao = claims.getExpiration();
			LocalDateTime expiracao = dataExpiracao.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			
			return !LocalDateTime.now().isAfter(expiracao);
		} catch(Exception e) {
			return false;
		}
	}
	
	public String obterLogin(String token) throws ExpiredJwtException {
		return (String) obterClaims(token).getSubject();
	}

}























