package alura.designpatterns.loja.orcamento;

import java.math.BigDecimal;

public class ItemOrcamento implements Orcavel {
    
    private BigDecimal valor;
    
    public ItemOrcamento(BigDecimal valor) {
        this.valor = valor;
    }
    
    @Override
    public BigDecimal getValor() {
        return valor;
    }
}