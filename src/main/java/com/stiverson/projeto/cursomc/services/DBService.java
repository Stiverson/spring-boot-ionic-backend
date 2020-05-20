package com.stiverson.projeto.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stiverson.projeto.cursomc.domain.Categoria;
import com.stiverson.projeto.cursomc.domain.Cidade;
import com.stiverson.projeto.cursomc.domain.Cliente;
import com.stiverson.projeto.cursomc.domain.Endereco;
import com.stiverson.projeto.cursomc.domain.Estado;
import com.stiverson.projeto.cursomc.domain.ItemPedido;
import com.stiverson.projeto.cursomc.domain.Pagamento;
import com.stiverson.projeto.cursomc.domain.PagamentoComBoleto;
import com.stiverson.projeto.cursomc.domain.PagamentoComCartao;
import com.stiverson.projeto.cursomc.domain.Pedido;
import com.stiverson.projeto.cursomc.domain.Produto;
import com.stiverson.projeto.cursomc.domain.enums.EstadoPagamento;
import com.stiverson.projeto.cursomc.domain.enums.TipoCliente;
import com.stiverson.projeto.cursomc.repositories.CategoriaRepository;
import com.stiverson.projeto.cursomc.repositories.CidadeRepository;
import com.stiverson.projeto.cursomc.repositories.ClienteRepository;
import com.stiverson.projeto.cursomc.repositories.EnderecoRepository;
import com.stiverson.projeto.cursomc.repositories.EstadoRepository;
import com.stiverson.projeto.cursomc.repositories.ItemPedidoRepository;
import com.stiverson.projeto.cursomc.repositories.PagamentoRepository;
import com.stiverson.projeto.cursomc.repositories.PedidoRepository;
import com.stiverson.projeto.cursomc.repositories.ProdutoRepository;


@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public void instantiateTestDatabase() throws ParseException {
		
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Games");
		Categoria cat3 = new Categoria(null,"SmartPhones");
		Categoria cat4 = new Categoria(null,"Smartwatches");
		Categoria cat5 = new Categoria(null,"Periféricos");
		Categoria cat6 = new Categoria(null,"Consoles");
		Categoria cat7 = new Categoria(null,"Cadeiras Gamers");
		
		Produto p1 = new Produto (null,"Notebook", 2500.00);
		Produto p2 = new Produto (null,"Impressora", 800.00);
		Produto p3 = new Produto (null,"God of war", 150.00);
		Produto p4 = new Produto (null,"Cadeira", 400.00);
		Produto p5 = new Produto (null,"cabo hdmi", 30.00);
		Produto p6 = new Produto (null,"XBoxOne s", 1500.00);
		Produto p7 = new Produto (null,"Amazing fit 8", 300.00);
		Produto p8 = new Produto (null,"Asus zenfone 6", 1487.00);
		Produto p9 = new Produto (null,"Playstation 4", 1555.00);
		Produto p10 = new Produto (null,"Mouse óptico", 50.00);
		Produto p11= new Produto (null,"The Last of us", 165.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p10));
		cat2.getProdutos().addAll(Arrays.asList(p3,p11));
		cat3.getProdutos().addAll(Arrays.asList(p8));
		cat4.getProdutos().addAll(Arrays.asList(p7));
		cat5.getProdutos().addAll(Arrays.asList(p5));
		cat6.getProdutos().addAll(Arrays.asList(p6,p9));
		cat7.getProdutos().addAll(Arrays.asList(p4));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		p4.getCategorias().addAll(Arrays.asList(cat7));
		p5.getCategorias().addAll(Arrays.asList(cat5));
		p6.getCategorias().addAll(Arrays.asList(cat6));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat3));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat1));
		p11.getCategorias().addAll(Arrays.asList(cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2,cat3,cat4,cat5,cat6,cat7));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Piracicaba",est2);
		Cidade c2 = new Cidade(null,"Uberlândia",est1);
		Cidade c3 = new Cidade(null,"São Paulo",est2);
		
		est1.getCidades().addAll(Arrays.asList(c2));
		est2.getCidades().addAll(Arrays.asList(c1,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		Cliente cli1 = new Cliente(null,"Stiverson Machado","Stiverson.machado@gmail.com","36645955804",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("19982273244","991970865"));
		Endereco e1 = new Endereco(null, "Avenida Pompéia", "2940", "Apto101 bl 05", "NovaPompéia", "13425620", cli1, c1);
		cli1.getEnderecos().addAll(Arrays.asList(e1));
		
		
		Cliente cli2 = new Cliente(null,"Alberto Dumbledore","RufricBryan@gmail.com","4846646849848484",TipoCliente.PESSOAJURIDICA);
		cli2.getTelefones().addAll(Arrays.asList("8454114198456231","5184815154448"));
		Endereco e2 = new Endereco(null, "Howgrats sala 12", "8945", "Ala 28", "hogmead", "14852479", cli2, c2);
		cli2.getEnderecos().addAll(Arrays.asList(e2));
		
		Cliente cli3 = new Cliente(null,"Snow the boss","bletsnowcat@gmail.com","154484845548458",TipoCliente.PESSOAFISICA);
		cli3.getTelefones().addAll(Arrays.asList("895541441156","56589484156"));
		Endereco e3 = new Endereco(null, "Avenida Pompéia", "2940", "Apto101 bl 05", "NovaPompéia", "13425620", cli3, c1);
		cli3.getEnderecos().addAll(Arrays.asList(e1));
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3));
		enderecoRepository.saveAll(Arrays.asList(e1,e2,e3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("21/04/2020 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("17/03/2020 19:35"), cli1, e3);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/03/2020 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2500.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 1, 150.00);
		
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p1.getItens().addAll(Arrays.asList(ip3));
		p2.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2,ip3));
		
		
	}

}
