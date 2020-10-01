package se.atg.service.harrykart.exceptions;


public class HarryKartException extends Exception {

    /**
     * The exception displays the message passed to it.
     * @param message   The exception message
     */
    public HarryKartException(String message) {
        super(message);
    }

}