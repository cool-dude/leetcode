package vending;
public class NotFullPaidException extends RuntimeException {
    String message;
    long remaining;
    public NotFullPaidException(String message, long remaining) {
        this.message = message;
        this.remaining = remaining;
    }
    public long getRemaining(){
        return remaining;
    }
    @Override public String getMessage(){
        return message + remaining;
    }
}