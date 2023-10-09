package alura.designpatterns.loja.pedido.acao;

import alura.designpatterns.loja.pedido.Pedido;

public class SalvarPedidoNoBancoDeDados implements Acao {
    
    public void executar(Pedido pedido) {
        System.out.println("Salvando dados do pedido no banco de dados.");
    }
}