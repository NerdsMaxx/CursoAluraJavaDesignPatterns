package alura.designpatterns.loja.orcamento;

import alura.designpatterns.loja.DomainException;
import alura.designpatterns.loja.http.HttpAdapter;
import alura.designpatterns.loja.orcamento.situacao.Finalizado;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegistroDeOrcamento {
    
    private HttpAdapter http;
    
    public RegistroDeOrcamento(HttpAdapter http) {
        this.http = http;
    }
    
    public void registrar(Orcamento orcamento) {
        if(!orcamento.isFinalizado()){
            throw new DomainException("Orçamento não finalizado.");
        }


        String url = "http://api.externa/orcamento";
        Map<String,Object> dados = Map.of("valor", orcamento.getValor(),
                                          "quantidadeItens", orcamento.getQuantidadeItens());

        http.post(url, dados);
    }
}