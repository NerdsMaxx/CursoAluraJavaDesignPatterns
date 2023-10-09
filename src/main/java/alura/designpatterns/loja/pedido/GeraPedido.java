package alura.designpatterns.loja.pedido;

import alura.designpatterns.loja.orcamento.Orcamento;
import alura.designpatterns.loja.orcamento.Orcavel;

public class GeraPedido {
    
    private  String cliente;
    private Orcamento orcamento;
    
    public GeraPedido(String cliente, Orcamento orcamento) {
        this.cliente = cliente;
        this.orcamento = orcamento;
    }
    
    public String getCliente() {
        return cliente;
    }
    
    public Orcamento getOrcamento() {
        return orcamento;
    }
    
}