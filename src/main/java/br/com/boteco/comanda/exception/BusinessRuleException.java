package br.com.boteco.comanda.exception;

public class BusinessRuleException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public BusinessRuleException(String msg) {
        super(msg);
    }
    public BusinessRuleException(String msg, Throwable cause) {
        super(msg, cause);
    }
}