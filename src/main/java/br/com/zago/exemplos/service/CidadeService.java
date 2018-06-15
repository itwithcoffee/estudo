package br.com.zago.exemplos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zago.exemplos.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repositorio;
	
	
}
