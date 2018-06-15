package br.com.zago.exemplos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.zago.exemplos.domain.Categoria;
import br.com.zago.exemplos.domain.Cidade;
import br.com.zago.exemplos.domain.Cliente;
import br.com.zago.exemplos.domain.Endereco;
import br.com.zago.exemplos.domain.Estado;
import br.com.zago.exemplos.domain.Produto;
import br.com.zago.exemplos.domain.enums.TipoCliente;
import br.com.zago.exemplos.repository.CategoriaRepository;
import br.com.zago.exemplos.repository.CidadeRepository;
import br.com.zago.exemplos.repository.ClienteRepository;
import br.com.zago.exemplos.repository.EnderecoRepository;
import br.com.zago.exemplos.repository.EstadoRepository;
import br.com.zago.exemplos.repository.ProdutoRepository;

@SpringBootApplication
public class ExemplosApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository repositorioCat;
	@Autowired
	private ProdutoRepository repositorioProd;
	@Autowired
	private EstadoRepository repositorioEstado;
	@Autowired
	private CidadeRepository repositorioCidade;
	@Autowired
	private ClienteRepository repositorioCliente;
	@Autowired
	private EnderecoRepository repositorioEndereco;
	
	public static void main(String[] args) {
		SpringApplication.run(ExemplosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Limpeza");
		
		Produto prod1 = new Produto(null, "Computador", 2000.00);
		Produto prod2 = new Produto(null, "Impressora", 670.00);
		Produto prod3 = new Produto(null, "Detergente", 134.50);
		Produto prod4 = new Produto(null, "Grampeador", 30.00);
		
		cat1.getProdutos().add(prod1);
		cat2.getProdutos().addAll(Arrays.asList(prod2, prod4));
		cat3.getProdutos().add(prod3);
		
		prod1.getCategorias().add(cat1);
		prod2.getCategorias().add(cat2);
		prod3.getCategorias().add(cat3);
		prod4.getCategorias().add(cat2);
		
		repositorioCat.saveAll(Arrays.asList(cat1, cat2, cat3));
		repositorioProd.saveAll(Arrays.asList(prod1, prod2, prod3, prod4));
		
		Estado e1 = new Estado(null, "Minas Gerais");
		Estado e2 = new Estado(null, "Paraná");
		
		Cidade c1 = new Cidade(null, "Uberlândia", e1);
		Cidade c2 = new Cidade(null, "Araguari", e1);
		Cidade c3 = new Cidade(null, "Curitiba", e2);
		
		repositorioEstado.saveAll(Arrays.asList(e1, e2));
		repositorioCidade.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Pedro Paulo Rangel", "ppr@teste.com.br", "12345678967", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("(34)99786-5678", "(34)4567-0897"));
		Cliente cli2 = new Cliente(null, "Augusta Carvalho", "augusta_carv@teste.com.br", "15027673000102", TipoCliente.PESSOA_JURIDICA);
		cli2.getTelefones().add("(41)99786-4567");
		
		Endereco end1 = new Endereco(null, "Rua da Carioca", "321", null, "Patrimônio", "38.408-202", cli1, c1);
		Endereco end2 = new Endereco(null, "Rua Carneiro", "39", "Frente", "Patrimônio", "38.408-202", cli1, c2);
		Endereco end3 = new Endereco(null, "Avenida João Naves de Avila", "1331", null, "Patrimônio", "38.408-202", cli2, c3);
		Endereco end4 = new Endereco(null, "Rua Iguaçu", "12", "Apto 202", "Patrimônio", "38.408-202", cli2, c3);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		cli2.getEnderecos().addAll(Arrays.asList(end3, end4));
		
		repositorioCliente.saveAll(Arrays.asList(cli1, cli2));
		repositorioEndereco.saveAll(Arrays.asList(end1, end2, end3, end4));
		
		
	}
}
