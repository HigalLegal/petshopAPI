package com.gft.petshop.mapper;

import java.util.stream.Collectors;

import com.gft.petshop.dto.AtendimentoDTO;
import com.gft.petshop.dto.CachorroDTO;
import com.gft.petshop.dto.ClienteDTO;
import com.gft.petshop.dto.EnderecoDTO;
import com.gft.petshop.dto.MedicoVeterinarioDTO;
import com.gft.petshop.dto.requests.AtendimentoRequest;
import com.gft.petshop.dto.requests.CachorroPorClienteRequest;
import com.gft.petshop.dto.requests.CachorroRequest;
import com.gft.petshop.dto.requests.ClienteRequest;
import com.gft.petshop.dto.requests.EnderecoPorClienteRequest;
import com.gft.petshop.dto.requests.EnderecoRequest;
import com.gft.petshop.dto.requests.MedicoVeterinarioRequest;
import com.gft.petshop.dto.responses.AtendimentoResponse;
import com.gft.petshop.dto.responses.CachorroPorClienteResponse;
import com.gft.petshop.dto.responses.CachorroResponse;
import com.gft.petshop.dto.responses.ClienteResponse;
import com.gft.petshop.dto.responses.ClienteResponseAll;
import com.gft.petshop.dto.responses.EnderecoPorClienteResponse;
import com.gft.petshop.dto.responses.EnderecoResponse;
import com.gft.petshop.dto.responses.MedicoVeterinarioResponse;
import com.gft.petshop.model.entities.Usuario;
import com.gft.petshop.requests.UsuarioRequest;

public class MapperResponseRequestDTO {

	public MedicoVeterinarioResponse medicoDtoParaResponse(MedicoVeterinarioDTO medicoVeterinarioDTO) {
		var medicoVeterinarioResponse = new MedicoVeterinarioResponse();

		medicoVeterinarioResponse.setId(medicoVeterinarioDTO.getId());
		medicoVeterinarioResponse.setNome(medicoVeterinarioDTO.getNome());

		return medicoVeterinarioResponse;
	}

	public MedicoVeterinarioDTO medicoRequestParaDTO(MedicoVeterinarioRequest medicoVeterinarioRequest) {
		var medicoVeterinarioDTO = new MedicoVeterinarioDTO(medicoVeterinarioRequest.getNome());

		return medicoVeterinarioDTO;
	}
	
	private MedicoVeterinarioDTO medicoResponseParaDTO(MedicoVeterinarioResponse medicoVeterinarioResponse) {
		var medicoVeterinarioDTO = new MedicoVeterinarioDTO();
		
		medicoVeterinarioDTO.setId(medicoVeterinarioResponse.getId());
		medicoVeterinarioDTO.setNome(medicoVeterinarioResponse.getNome());
		
		return medicoVeterinarioDTO;
	}

	// -------------------------------------------------------------------------------------------------------------

	public ClienteResponseAll clienteDtoParaResponseAll(ClienteDTO clienteDTO) {
		var clienteResponseAll = new ClienteResponseAll();

		clienteResponseAll.setId(clienteDTO.getId());
		clienteResponseAll.setNome(clienteDTO.getNome());
		clienteResponseAll.setIdade(clienteDTO.getIdade());
		clienteResponseAll.setApelido(clienteDTO.getApelido());

		return clienteResponseAll;
	}

	public ClienteResponse clienteDtoParaResponse(ClienteDTO clienteDTO) {
		var clienteResponse = new ClienteResponse();

		clienteResponse.setId(clienteDTO.getId());
		clienteResponse.setNome(clienteDTO.getNome());
		clienteResponse.setIdade(clienteDTO.getIdade());
		clienteResponse.setApelido(clienteDTO.getApelido());
		clienteResponse.setCachorros(clienteDTO.getCachorros().stream()
				.map(this::cachorroDtoParaResponse2).collect(Collectors.toList()));
		clienteResponse.setEnderecos(clienteDTO.getEnderecos().stream()
				.map(this::enderecoDtoParaResponse2).collect(Collectors.toList()));

		return clienteResponse;
	}
	
	public ClienteDTO clienteRequestParaDTO(ClienteRequest clienteRequest) {
		var clienteDTO = new ClienteDTO();
		
		clienteDTO.setNome(clienteRequest.getNome());
		clienteDTO.setIdade(clienteRequest.getIdade());
		clienteDTO.setApelido(clienteRequest.getApelido());
		
		clienteDTO.setCachorros(clienteRequest.getCachorros().stream()
				.map(this::cachorroRequestParaDTO2).collect(Collectors.toList()));
		
		clienteDTO.setEnderecos(clienteRequest.getEnderecos().stream()
				.map(this::enderecoClienteRequestParaDTO).collect(Collectors.toList()));
		
		return clienteDTO;
	}
	
	public ClienteDTO clienteResponseAllParaDTO(ClienteResponseAll clienteResponseAll) {
		var clienteDTO = new ClienteDTO();
		
		clienteDTO.setId(clienteResponseAll.getId());
		clienteDTO.setNome(clienteResponseAll.getNome());
		clienteDTO.setIdade(clienteResponseAll.getIdade());
		clienteDTO.setApelido(clienteResponseAll.getApelido());
		
		return clienteDTO;
	}
	
	// -------------------------------------------------------------------------------------------------------------
	
	public CachorroResponse cachorroDtoParaResponse(CachorroDTO cachorroDTO) {
		var cachorroResponse = new CachorroResponse();
		
		cachorroResponse.setId(cachorroDTO.getId());
		cachorroResponse.setDataNascimento(cachorroDTO.getDataNascimento());
		cachorroResponse.setNome(cachorroDTO.getNome());
		cachorroResponse.setPorte(cachorroDTO.getPorte());
		cachorroResponse.setDono(cachorroDTO.getDono().getNome());
		
		return cachorroResponse;
	}
	
	public CachorroDTO cachorroRequestParaDTO(CachorroRequest cachorroRequest) {
		var cachorroDTO = new CachorroDTO();
		
		cachorroDTO.setDataNascimento(cachorroRequest.getDataNascimento());
		cachorroDTO.setNome(cachorroRequest.getNome());
		cachorroDTO.setPorte(cachorroRequest.getPorte());
		cachorroDTO.setDono(clienteResponseAllParaDTO(cachorroRequest.getDono()));
		
		return cachorroDTO;
	}
	
	private CachorroDTO cachorroRequestParaDTO2(CachorroPorClienteRequest cachorroPorClienteRequest) {
		var cachorroDTO = new CachorroDTO();
		
		cachorroDTO.setDataNascimento(cachorroPorClienteRequest.getDataNascimento());
		cachorroDTO.setNome(cachorroPorClienteRequest.getNome());
		cachorroDTO.setPorte(cachorroPorClienteRequest.getPorte());
		
		return cachorroDTO;
	}
	
//	private CachorroDTO cachorroResponseParaDTO(CachorroResponse cachorroResponse) {
//		var cachorroDTO = new CachorroDTO();
//		
//		cachorroDTO.setId(cachorroResponse.getId());
//		cachorroDTO.setDataNascimento(cachorroResponse.getDataNascimento());
//		cachorroDTO.setNome(cachorroResponse.getNome());
//		cachorroDTO.setPorte(cachorroResponse.getPorte());
//		
//		return cachorroDTO;
//	}
	
	private CachorroPorClienteResponse cachorroDtoParaResponse2(CachorroDTO cachorroDTO) {
		var cachorroResponse = new CachorroPorClienteResponse();
		
		cachorroResponse.setId(cachorroDTO.getId());
		cachorroResponse.setDataNascimento(cachorroDTO.getDataNascimento());
		cachorroResponse.setNome(cachorroDTO.getNome());
		cachorroResponse.setPorte(cachorroDTO.getPorte());
		
		return cachorroResponse;
	}
	
	private CachorroDTO cachorroRequestParaDto2(CachorroPorClienteResponse cachorroResponse) {
		var cachorroDTO = new CachorroDTO();
		
		cachorroDTO.setId(cachorroResponse.getId());
		cachorroDTO.setDataNascimento(cachorroResponse.getDataNascimento());
		cachorroDTO.setNome(cachorroResponse.getNome());
		cachorroDTO.setPorte(cachorroResponse.getPorte());
		
		return cachorroDTO;
	}
	
	// -------------------------------------------------------------------------------------------------------------
	
	public EnderecoResponse enderecoDtoParaResponse(EnderecoDTO enderecoDTO) {
		var enderecoResponse = new EnderecoResponse();
		
		enderecoResponse.setId(enderecoDTO.getId());
		enderecoResponse.setEstado(enderecoDTO.getEstado());
		enderecoResponse.setCidade(enderecoDTO.getCidade());
		enderecoResponse.setBairro(enderecoDTO.getBairro());
		enderecoResponse.setRua(enderecoDTO.getRua());
		enderecoResponse.setNumero(enderecoDTO.getNumero());
		enderecoResponse.setComplemento(enderecoDTO.getComplemento());
		enderecoResponse.setCliente(enderecoDTO.getClienteDTO().getNome());
		
		return enderecoResponse;
	}
	
	public EnderecoDTO enderecoRequestParaDTO(EnderecoRequest enderecoRequest) {
		var enderecoDTO = new EnderecoDTO();
		
		enderecoDTO.setEstado(enderecoRequest.getEstado());
		enderecoDTO.setCidade(enderecoRequest.getCidade());
		enderecoDTO.setBairro(enderecoRequest.getBairro());
		enderecoDTO.setRua(enderecoRequest.getRua());
		enderecoDTO.setNumero(enderecoRequest.getNumero());
		enderecoDTO.setComplemento(enderecoRequest.getComplemento());
		enderecoDTO.setClienteDTO(clienteResponseAllParaDTO(enderecoRequest.getCliente()));
		
		return enderecoDTO;
	}
	
	private EnderecoDTO enderecoClienteRequestParaDTO(EnderecoPorClienteRequest enderecoPorClienteRequest) {
		var enderecoDTO = new EnderecoDTO();
		
		enderecoDTO.setEstado(enderecoPorClienteRequest.getEstado());
		enderecoDTO.setCidade(enderecoPorClienteRequest.getCidade());
		enderecoDTO.setBairro(enderecoPorClienteRequest.getBairro());
		enderecoDTO.setRua(enderecoPorClienteRequest.getRua());
		enderecoDTO.setNumero(enderecoPorClienteRequest.getNumero());
		enderecoDTO.setComplemento(enderecoPorClienteRequest.getComplemento());
		
		return enderecoDTO;
	}
	
	public EnderecoPorClienteResponse enderecoDtoParaResponse2(EnderecoDTO enderecoDTO) {
		var enderecoResponse = new EnderecoPorClienteResponse();
		
		enderecoResponse.setId(enderecoDTO.getId());
		enderecoResponse.setEstado(enderecoDTO.getEstado());
		enderecoResponse.setCidade(enderecoDTO.getCidade());
		enderecoResponse.setBairro(enderecoDTO.getBairro());
		enderecoResponse.setRua(enderecoDTO.getRua());
		enderecoResponse.setNumero(enderecoDTO.getNumero());
		enderecoResponse.setComplemento(enderecoDTO.getComplemento());
		
		return enderecoResponse;
	}
	
	// -------------------------------------------------------------------------------------------------------------
	
	public AtendimentoResponse atendimentoDtoParaResponse(AtendimentoDTO atendimentoDTO) {
		var atendimentoResponse = new AtendimentoResponse();
		
		atendimentoResponse.setId(atendimentoDTO.getId());
		atendimentoResponse.setData(atendimentoDTO.getData());
		atendimentoResponse.setHorario(atendimentoDTO.getHorario());
		atendimentoResponse.setCachorro(cachorroDtoParaResponse(atendimentoDTO.getCachorro()));
		
		atendimentoResponse.setMedicos(atendimentoDTO.getMedicos().stream()
				.map(this::medicoDtoParaResponse).collect(Collectors.toList()));
		
		return atendimentoResponse;
	}
	
	public AtendimentoDTO atendimentoRequestParaDTO(AtendimentoRequest atendimentoRequest) {
		var atendimentoDTO = new AtendimentoDTO();
		
		atendimentoDTO.setData(atendimentoRequest.getData());
		atendimentoDTO.setHorario(atendimentoRequest.getHorario());
		atendimentoDTO.setCachorro(cachorroRequestParaDto2(atendimentoRequest.getCachorro()));
		atendimentoDTO.setMedicos(atendimentoRequest.getMedicos().stream()
				.map(this::medicoResponseParaDTO).collect(Collectors.toList()));
		
		return atendimentoDTO;
	}
	
	// -------------------------------------------------------------------------------------------------------------
	
	public Usuario usuarioRequestParaEntidade(UsuarioRequest usuarioRequest) {
		return new Usuario(usuarioRequest.getLogin(), usuarioRequest.getSenha(), usuarioRequest.getAdmin());
	}
	
}
