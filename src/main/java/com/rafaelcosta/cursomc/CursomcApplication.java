package com.rafaelcosta.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafaelcosta.cursomc.domain.Categoria;
import com.rafaelcosta.cursomc.domain.Cidade;
import com.rafaelcosta.cursomc.domain.Cliente;
import com.rafaelcosta.cursomc.domain.Endereco;
import com.rafaelcosta.cursomc.domain.Estado;
import com.rafaelcosta.cursomc.domain.ItemPedido;
import com.rafaelcosta.cursomc.domain.Pagamento;
import com.rafaelcosta.cursomc.domain.PagamentoBoleto;
import com.rafaelcosta.cursomc.domain.PagamentoCartao;
import com.rafaelcosta.cursomc.domain.Pedido;
import com.rafaelcosta.cursomc.domain.Produto;
import com.rafaelcosta.cursomc.domain.enums.EstadoPagamento;
import com.rafaelcosta.cursomc.domain.enums.TipoCliente;
import com.rafaelcosta.cursomc.repositories.CategoriaRepository;
import com.rafaelcosta.cursomc.repositories.CidadeRepository;
import com.rafaelcosta.cursomc.repositories.ClienteRepository;
import com.rafaelcosta.cursomc.repositories.EnderecoRepository;
import com.rafaelcosta.cursomc.repositories.EstadoRepository;
import com.rafaelcosta.cursomc.repositories.ItemPedidoRepository;
import com.rafaelcosta.cursomc.repositories.PagamentoRepository;
import com.rafaelcosta.cursomc.repositories.PedidoRepository;
import com.rafaelcosta.cursomc.repositories.ProdutoRepository;
import com.rafaelcosta.cursomc.services.CepService;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	//Injeção de dependência dos repositories é utilizando @Aurowired antes de cada crição
	@Autowired private CategoriaRepository _categoriaRepository;
	@Autowired private ProdutoRepository _produtoRepository;
	@Autowired private CidadeRepository _cidadeRepository;
	@Autowired private EstadoRepository _estadoRepository;
	@Autowired private ClienteRepository _clienteRepository;
	@Autowired private EnderecoRepository _enderecoRepository;
	@Autowired private PagamentoRepository _PagamentoRepository;
	@Autowired private PedidoRepository _PedidoRepository;
	@Autowired private ItemPedidoRepository _ItemPedidoRepository;
	@Autowired private CepService _cep;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	//método auxiliar para executar instruções ao iniciar
	public void run(String... args) throws Exception {
		
		//criação das categorias
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		//criando os produtos
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		//vinculando os produtos às categorias
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		//vinculando as categorias aos produtos
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		//criando os estados
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		//criando as cidades
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		//vinculando as cidades aos estados
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		//cria do o cliente
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		//vinculando telefones ao cliente
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		//criando enderecos do cliente
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		//vinculando os enderecos ao cliente
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		//formatando data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		//criando pedidos
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		//criando pagamentos de pedidos
		Pagamento pagto1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		Pagamento pagto2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		
		//vinculando pagamento aos pedidos
		ped1.setPagamento(pagto1);
		ped2.setPagamento(pagto2);
		
		//vinculando pedidos ao cliente
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		//criando itens de pedido
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.0, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.0, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.0, 1, 800.00);
		
		//vinculando itens a pedido
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));		
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		//xx
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		_categoriaRepository	.saveAll(Arrays.asList(cat1, cat2));
		_produtoRepository		.saveAll(Arrays.asList(p1, p2, p3));
		_estadoRepository		.saveAll(Arrays.asList(est1, est2));
		_cidadeRepository		.saveAll(Arrays.asList(c1, c2, c3));
		_clienteRepository		.saveAll(Arrays.asList(cli1));
		_enderecoRepository		.saveAll(Arrays.asList(e1, e2));
		_PedidoRepository		.saveAll(Arrays.asList(ped1, ped2));
		_PagamentoRepository	.saveAll(Arrays.asList(pagto1, pagto2));
		_ItemPedidoRepository	.saveAll(Arrays.asList(ip1, ip2, ip3));
		
		System.out.println(_cep.obterCep("88115563"));
		
	}

}
