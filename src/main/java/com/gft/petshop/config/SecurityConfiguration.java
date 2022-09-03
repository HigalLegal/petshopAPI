package com.gft.petshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import com.gft.petshop.security.jwt.JwtAuthFilter;
import com.gft.petshop.security.jwt.JwtService;
import com.gft.petshop.services.impl.UsuarioServiceImpl;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioServiceImpl usuarioService;

	@Autowired
	private JwtService jwtService;

	// ------------------------------------------------------------------------------------------------------

//	private String[] apenasAdms() {
//		List<String> soAdm = new ArrayList<>();
//
//		soAdm.add("/clientes/novo");
//		soAdm.add("/clientes/atualizar");
//		soAdm.add("/clientes/deletar");
//		soAdm.add("/cliente/novo/popular-banco");
//
//		soAdm.add("/atendimentos/novo");
//		soAdm.add("/atendimentos/novo/popular-banco");
//		soAdm.add("/atendimentos/atualizar");
//		soAdm.add("/atendimentos/deletar");
//
//		soAdm.add("/cachorros/novo");
//		soAdm.add("/cachorros/novo/popular-banco");
//		soAdm.add("/cachorros/atualizar");
//		soAdm.add("/cachorros/deletar");
//
//		soAdm.add("/endereco/novo");
//		soAdm.add("/endereco/novo/popular-banco");
//		soAdm.add("/endereco/atualizar");
//		soAdm.add("/endereco/deletar");
//
//		soAdm.add("/medicos/novo");
//		soAdm.add("/medicos/novo/popular-banco");
//		soAdm.add("/medicos/atualizar");
//		soAdm.add("/medicos/deletar");
//
//		String[] retorno = new String[soAdm.size()];
//
//		for (int i = 0; i < 0; i++) {
//			retorno[i] = soAdm.get(i);
//		}
//
//		return retorno;
//
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public OncePerRequestFilter jwtFilter() {
		return new JwtAuthFilter(jwtService, usuarioService);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//tentei usar um método para setar todos esses endpoints e passar aqui, mas dava erro :/
		
		http.authorizeRequests().antMatchers("/usuarios/novo", "/usuarios/auth")
				.permitAll().antMatchers("/clientes/novo", "/clientes/atualizar",
						"/clientes/deletar", "/cliente/novo/popular-banco",
						"/atendimentos/novo", "/atendimentos/novo/popular-banco",
						"/atendimentos/atualizar", "/atendimentos/deletar",
						"/cachorros/novo", "/cachorros/novo/popular-banco",
						"/cachorros/atualizar", "/cachorros/deletar",
						"/endereco/novo", "/endereco/novo/popular-banco",
						"/endereco/atualizar", "/endereco/deletar",
						"/medicos/novo", "/medicos/novo/popular-banco",
						"/medicos/atualizar", "/medicos/deletar")				
				.hasRole("ADMIN").antMatchers(HttpMethod.PUT).hasRole("ADMIN")
				.antMatchers(HttpMethod.GET).hasRole("USER")
				.and().csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers(
	            "/v2/api-docs",
	            "/configuration/ui",
	            "/swagger-resources/**",
	            "/configuration/security",
	            "/swagger-ui/**",
	            "/webjars/**");
	}
}
