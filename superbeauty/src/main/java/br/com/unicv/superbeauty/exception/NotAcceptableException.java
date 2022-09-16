package br.com.unicv.superbeauty.exception;

public class NotAcceptableException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotAcceptableException(String mensagem) {
        super(mensagem);
    }
    
}