package alura.designpatterns.loja.pedido;

import alura.designpatterns.loja.orcamento.Orcamento;
import alura.designpatterns.loja.pedido.acao.Acao;
import alura.designpatterns.loja.pedido.acao.EnviarEmailPedido;
import alura.designpatterns.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

import java.time.LocalDateTime;
import java.util.List;

public class GerarPedidoHandler {
    
    private List<Acao> acoes;
    
    public GerarPedidoHandler(List<Acao> acoes) {
        this.acoes = acoes;
    }
    
    public void executa(GeraPedido dados) {
        Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), dados.getOrcamento());

        acoes.forEach(acao -> acao.executar(pedido));
    }
}