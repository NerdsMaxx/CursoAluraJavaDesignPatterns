package alura.designpatterns.loja;

public class DomainException extends RuntimeException{
    
    public DomainException(String message){
        super(message);
    }
}