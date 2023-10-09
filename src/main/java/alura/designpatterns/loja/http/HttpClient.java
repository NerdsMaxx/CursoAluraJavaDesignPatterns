package alura.designpatterns.loja.http;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class HttpClient implements HttpAdapter {
    
    @Override
    public void post(String url, Map<String,Object> dados) {
        try {
            URL urlDaApi = new URL(url);
            //URLConnection connection = urlDaApi.openConnection();
            //connection.connect();
            System.out.println("Foi mandado resquest e body para api.");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Erro ao enviar requisição HTTP", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}