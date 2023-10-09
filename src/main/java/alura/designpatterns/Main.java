package alura.designpatterns;

import alura.designpatterns.loja.desconto.CalculadoraDeDescontos;
import alura.designpatterns.loja.http.HttpClient;
import alura.designpatterns.loja.imposto.CalculadoraDeImpostos;
import alura.designpatterns.loja.imposto.ICMS;
import alura.designpatterns.loja.imposto.ISS;
import alura.designpatterns.loja.orcamento.ItemOrcamento;
import alura.designpatterns.loja.orcamento.Orcamento;
import alura.designpatterns.loja.orcamento.OrcamentoProxy;
import alura.designpatterns.loja.orcamento.RegistroDeOrcamento;
import alura.designpatterns.loja.pedido.GeraPedido;
import alura.designpatterns.loja.pedido.GerarPedidoHandler;
import alura.designpatterns.loja.pedido.acao.EnviarEmailPedido;
import alura.designpatterns.loja.pedido.acao.LogDePedido;
import alura.designpatterns.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Padrão Decorator
        ItemOrcamento item1 = new ItemOrcamento(new BigDecimal("100"));
        ItemOrcamento item2 = new ItemOrcamento(new BigDecimal("200"));
        
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(item1)
                 .adicionarItem(item2);
        
        CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
        System.out.println(calculadora.calcular(orcamento, new ICMS(new ISS())));
        
        //Padrão Chain Of Responsibility
        ItemOrcamento item3 = new ItemOrcamento(new BigDecimal("500"));
        ItemOrcamento item4 = new ItemOrcamento(new BigDecimal("200"));
        ItemOrcamento item5 = new ItemOrcamento(new BigDecimal("350"));
        
        Orcamento orcamento1 = new Orcamento();
        orcamento1.adicionarItem(item3)
                  .adicionarItem(item4)
                  .adicionarItem(item5);
        
        ItemOrcamento item6 = new ItemOrcamento(new BigDecimal("200"));
        ItemOrcamento item7 = new ItemOrcamento(new BigDecimal("300"));
        
        Orcamento orcamento2 = new Orcamento();
        orcamento2.adicionarItem(item6)
                  .adicionarItem(item7);
        
        CalculadoraDeDescontos calculadora1 = new CalculadoraDeDescontos();
        
        System.out.println(calculadora1.calcular(orcamento1));
        System.out.println(calculadora1.calcular(orcamento2));
        
        //Padrão Command e CommandHandler
        String cliente = "Guilherme";
        
        GeraPedido dados = new GeraPedido(cliente, orcamento2);
        GerarPedidoHandler handler = new GerarPedidoHandler(Arrays.asList(new SalvarPedidoNoBancoDeDados(),
                                                                          new EnviarEmailPedido(),
                                                                          new LogDePedido()));
        handler.executa(dados);
        
        //Padrão State e Adapter
        ItemOrcamento item8 = new ItemOrcamento(new BigDecimal("200"));
        ItemOrcamento item9 = new ItemOrcamento(new BigDecimal("300"));
        
        Orcamento orcamento3 = new Orcamento();
        orcamento3.adicionarItem(item8)
                  .adicionarItem(item9);
        
        orcamento3.aprovar();
        orcamento3.finalizar();
        
        RegistroDeOrcamento registro = new RegistroDeOrcamento(new HttpClient());
        registro.registrar(orcamento3);
        
        //Padrão Decorator
        ItemOrcamento item10 = new ItemOrcamento(new BigDecimal("280"));
        ItemOrcamento item11 = new ItemOrcamento(new BigDecimal("320"));
        
        Orcamento orcamento4 = new Orcamento();
        orcamento4.adicionarItem(item10)
                  .adicionarItem(item11);
        
        CalculadoraDeImpostos calculadora2 = new CalculadoraDeImpostos();
        
        System.out.println(calculadora2.calcular(orcamento4, new ICMS(new ISS())));
        
        //Padrão Composite
        Orcamento antigo = new Orcamento();
        antigo.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
        antigo.reprovar();
        
        Orcamento novo = new Orcamento();
        novo.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
        novo.adicionarItem(antigo);

        System.out.println(novo.getValor());

        //Padrão Facade
        String cliente1 = "Guilherme";

        GeraPedido dados1 = new GeraPedido(cliente1, novo);
        GerarPedidoHandler handler1 = new GerarPedidoHandler(Arrays.asList(new SalvarPedidoNoBancoDeDados(),
                                                                          new EnviarEmailPedido(),
                                                                          new LogDePedido()));
        handler.executa(dados1);
        
        //Padrão Proxy Cache
        OrcamentoProxy proxy = new OrcamentoProxy(novo);
        
        for (int i = 0; i < 20; ++ i) {
            System.out.println(proxy.getValor());
        }
    }
}