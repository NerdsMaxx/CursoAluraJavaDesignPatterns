package alura.designpatterns.loja.orcamento;

import alura.designpatterns.loja.orcamento.situacao.EmAnalise;
import alura.designpatterns.loja.orcamento.situacao.Finalizado;
import alura.designpatterns.loja.orcamento.situacao.SituacaoOrcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Orcamento implements Orcavel {
    private BigDecimal valor = BigDecimal.ZERO;
    private SituacaoOrcamento situacao = new EmAnalise();
    private List<Orcavel> itens = new ArrayList<>();
    
    public void aplicarDescontoExtra() {
        BigDecimal valorDescontoExtra = this.situacao.calcularValorDescontoExtra(this);
        this.valor = this.valor.subtract(valorDescontoExtra);
    }
    
    public void aprovar() {this.situacao.aprovar(this);}
    
    public void reprovar() {this.situacao.reprovar(this);}
    
    public void finalizar() {this.situacao.finalizar(this);}
    
    @Override
    public BigDecimal getValor() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this.valor;
    }
    
    public void setSituacaoOrcamento(SituacaoOrcamento situacao) {this.situacao = situacao;}
    
    public SituacaoOrcamento getSituacao() {return this.situacao;}
    
    public boolean isFinalizado() {return situacao instanceof Finalizado;}
    
    public int getQuantidadeItens() {return itens.size();}
    
    public Orcamento adicionarItem(Orcavel item) {
        this.valor = valor.add(item.getValor());
        this.itens.add(item);
        return this;
    }
}