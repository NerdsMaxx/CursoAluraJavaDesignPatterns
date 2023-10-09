package alura.designpatterns.loja.pedido.acao;

import alura.designpatterns.loja.pedido.Pedido;

public class EnviarEmailPedido implements Acao {
    
    public void executar(Pedido pedido) {
        System.out.println("Enviando email com dados do pedido.");
    }
}