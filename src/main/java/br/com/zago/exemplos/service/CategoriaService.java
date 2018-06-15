package br.com.zago.exemplos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zago.exemplos.domain.Categoria;
import br.com.zago.exemplos.repository.CategoriaRepository;
import br.com.zago.exemplos.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repositorio;
	
	public Categoria buscarPorId(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
