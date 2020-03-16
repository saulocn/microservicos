package br.com.saulocn.microservicos.loja.service.exceptions;

public class NoStockAvaibleException extends Throwable {
    public NoStockAvaibleException(String message) {
        super(message);
    }
}
