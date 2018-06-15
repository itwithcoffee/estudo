package br.com.zago.exemplos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zago.exemplos.domain.Cliente;
import br.com.zago.exemplos.repository.ClienteRepository;
import br.com.zago.exemplos.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repositorio;
	
	public Cliente buscarPorId(Integer id) {
		Optional<Cliente> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
