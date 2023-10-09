package alura.designpatterns.loja.pedido.acao;

import alura.designpatterns.loja.pedido.Pedido;

public interface Acao {
    void executar(Pedido pedido);
}