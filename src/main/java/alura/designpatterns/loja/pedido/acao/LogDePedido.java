package alura.designpatterns.loja.pedido.acao;

import alura.designpatterns.loja.pedido.Pedido;

public class LogDePedido implements Acao{
    
    
    @Override
    public void executar(Pedido pedido) {
        System.out.println("Pedido foi gerado: " + pedido);
    }
}