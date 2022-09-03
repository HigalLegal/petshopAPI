package com.gft.petshop.mapper;

import java.util.stream.Collectors;

import com.gft.petshop.dto.AtendimentoDTO;
import com.gft.petshop.dto.CachorroDTO;
import com.gft.petshop.dto.ClienteDTO;
import com.gft.petshop.dto.EnderecoDTO;
import com.gft.petshop.dto.MedicoVeterinarioDTO;
import com.gft.petshop.model.entities.Atendimento;
import com.gft.petshop.model.entities.Cachorro;
import com.gft.petshop.model.entities.Cliente;
import com.gft.petshop.model.entities.Endereco;
import com.gft.petshop.model.entities.MedicoVeterinario;

public class MapperDeEntidadeDTO {

	public MedicoVeterinarioDTO medicoParaDTO(MedicoVeterinario medicoVeterinario) {
		var medicoVeterinarioDTO = new MedicoVeterinarioDTO();

		medicoVeterinarioDTO.setId(medicoVeterinario.getId());
		medicoVeterinarioDTO.setNome(medicoVeterinario.getNome());

		return medicoVeterinarioDTO;
	}

	public MedicoVeterinario medicoParaEntidade(MedicoVeterinarioDTO medicoVeterinarioDTO) {
		var medicoVeterinario = new MedicoVeterinario();

		medicoVeterinario.setId(medicoVeterinarioDTO.getId());
		medicoVeterinario.setNome(medicoVeterinarioDTO.getNome());

		return medicoVeterinario;
	}
	
	// -------------------------------------------------------------------------------------------------------

	public ClienteDTO clienteParaDTO(Cliente cliente) {
		var clienteDTO = new ClienteDTO();

		clienteDTO.setId(cliente.getId());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setIdade(cliente.getIdade());
		clienteDTO.setApelido(cliente.getApelido());

		clienteDTO.setCachorros(cliente.getCachorros().stream()
				.map(this::cachorroParaDTO2).collect(Collectors.toList()));
		
		clienteDTO.setEnderecos(cliente.getEnderecos().stream()
				.map(this::enderecoParaDTO2).collect(Collectors.toList()));

		return clienteDTO;
	}

	public Cliente clienteParaEntidade(ClienteDTO clienteDTO) {
		var cliente = new Cliente();

		cliente.setId(clienteDTO.getId());
		cliente.setNome(clienteDTO.getNome());
		cliente.setIdade(clienteDTO.getIdade());
		cliente.setApelido(clienteDTO.getApelido());
		
		cliente.setCachorros(clienteDTO.getCachorros().stream()
				.map(this::cachorroParaEntidade2).collect(Collectors.toList()));
		
		cliente.setEnderecos(clienteDTO.getEnderecos().stream()
				.map(this::enderecoParaEntidade2).collect(Collectors.toList()));

		return cliente;
	}
	
	// -------------------------------------------------------------------------------------------------------

	public CachorroDTO cachorroParaDTO(Cachorro cachorro) {
		var cachorroDTO = new CachorroDTO();

		cachorroDTO.setId(cachorro.getId());
		cachorroDTO.setDataNascimento(cachorro.getDataNascimento());
		cachorroDTO.setNome(cachorro.getNome());
		cachorroDTO.setPorte(cachorro.getPorte());
		cachorroDTO.setDono(clienteParaDTO(cachorro.getDono()));

		return cachorroDTO;
	}
	
	public CachorroDTO cachorroParaDTO2(Cachorro cachorro) {
		var cachorroDTO = new CachorroDTO();

		cachorroDTO.setId(cachorro.getId());
		cachorroDTO.setDataNascimento(cachorro.getDataNascimento());
		cachorroDTO.setNome(cachorro.getNome());
		cachorroDTO.setPorte(cachorro.getPorte());
		//cachorroDTO.setDono(clienteParaDTO(cachorro.getDono()));

		return cachorroDTO;
	}

	public Cachorro cachorroParaEntidade(CachorroDTO cachorroDTO) {
		var cachorro = new Cachorro();

		cachorro.setId(cachorroDTO.getId());
		cachorro.setDataNascimento(cachorroDTO.getDataNascimento());
		cachorro.setNome(cachorroDTO.getNome());
		cachorro.setPorte(cachorroDTO.getPorte());
		cachorro.setDono(clienteParaEntidade(cachorroDTO.getDono()));

		return cachorro;
	}
	
	private Cachorro cachorroParaEntidade2(CachorroDTO cachorroDTO) {
		var cachorro = new Cachorro();

		cachorro.setId(cachorroDTO.getId());
		cachorro.setDataNascimento(cachorroDTO.getDataNascimento());
		cachorro.setNome(cachorroDTO.getNome());
		cachorro.setPorte(cachorroDTO.getPorte());

		return cachorro;
	}
	
	// -------------------------------------------------------------------------------------------------------
	
	public EnderecoDTO enderecoParaDTO(Endereco endereco) {
		var enderecoDTO = new EnderecoDTO();
		
		enderecoDTO.setId(endereco.getId());
		enderecoDTO.setEstado(endereco.getEstado());
		enderecoDTO.setCidade(endereco.getCidade());
		enderecoDTO.setBairro(endereco.getBairro());
		enderecoDTO.setRua(endereco.getRua());
		enderecoDTO.setNumero(endereco.getNumero());
		enderecoDTO.setClienteDTO(clienteParaDTO(endereco.getCliente()));
		
		return enderecoDTO;
	}
	
	public EnderecoDTO enderecoParaDTO2(Endereco endereco) {
		var enderecoDTO = new EnderecoDTO();
		
		enderecoDTO.setId(endereco.getId());
		enderecoDTO.setEstado(endereco.getEstado());
		enderecoDTO.setCidade(endereco.getCidade());
		enderecoDTO.setBairro(endereco.getBairro());
		enderecoDTO.setRua(endereco.getRua());
		enderecoDTO.setNumero(endereco.getNumero());
		//enderecoDTO.setClienteDTO(clienteParaDTO(endereco.getCliente()));
		
		return enderecoDTO;
	}
	
	public Endereco enderecoParaEntidade(EnderecoDTO enderecoDTO) {
		var endereco = new Endereco();
		
		endereco.setId(enderecoDTO.getId());
		endereco.setEstado(enderecoDTO.getEstado());
		endereco.setCidade(enderecoDTO.getCidade());
		endereco.setBairro(enderecoDTO.getBairro());
		endereco.setRua(enderecoDTO.getRua());
		endereco.setNumero(enderecoDTO.getNumero());
		endereco.setCliente(clienteParaEntidade(enderecoDTO.getClienteDTO()));
		
		return endereco;
	}
	
	private Endereco enderecoParaEntidade2(EnderecoDTO enderecoDTO) {
		var endereco = new Endereco();
		
		endereco.setId(enderecoDTO.getId());
		endereco.setEstado(enderecoDTO.getEstado());
		endereco.setCidade(enderecoDTO.getCidade());
		endereco.setBairro(enderecoDTO.getBairro());
		endereco.setRua(enderecoDTO.getRua());
		endereco.setNumero(enderecoDTO.getNumero());
		
		return endereco;
	}
	
	// -------------------------------------------------------------------------------------------------------
	
	public AtendimentoDTO atendimentoParaDTO(Atendimento atendimento) {
		var atendimentoDTO = new AtendimentoDTO();
		
		atendimentoDTO.setId(atendimento.getId());
		atendimentoDTO.setData(atendimento.getData());
		atendimentoDTO.setHorario(atendimento.getHorario());
		atendimentoDTO.setCachorro(cachorroParaDTO(atendimento.getCachorro()));
		
		atendimentoDTO.setMedicos(atendimento.getMedicos().stream()
				.map(this::medicoParaDTO).collect(Collectors.toList()));
		
		return atendimentoDTO;
	}
	
	public Atendimento atendimentoParaEntidade(AtendimentoDTO atendimentoDTO) {
		var atendimento = new Atendimento();
		
		atendimento.setId(atendimentoDTO.getId());
		atendimento.setData(atendimentoDTO.getData());
		atendimento.setHorario(atendimentoDTO.getHorario());
		atendimento.setCachorro(cachorroParaEntidade2(atendimentoDTO.getCachorro()));
		
		atendimento.setMedicos(atendimentoDTO.getMedicos().stream()
				.map(this::medicoParaEntidade).collect(Collectors.toList()));
		
		return atendimento;
	}

}
