package br.com.zago.exemplos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.zago.exemplos.domain.Cliente;
import br.com.zago.exemplos.service.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		Cliente obj = service.buscarPorId(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
