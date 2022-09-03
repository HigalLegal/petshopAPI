package com.gft.petshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gft.petshop.mapper.MapperDeEntidadeDTO;
import com.gft.petshop.mapper.MapperResponseRequestDTO;

@Configuration
public class MapperConfig {
	
	@Bean
	public MapperDeEntidadeDTO mapeadorDeEntidadeParaDTO() {
		return new MapperDeEntidadeDTO();
	}
	
	@Bean
	public MapperResponseRequestDTO mapeadorEntreResponseRequestDTO() {
		return new MapperResponseRequestDTO();
	}

}
