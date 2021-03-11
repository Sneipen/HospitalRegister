package no.ntnu.prog2.hospital;

public class RemoveException extends Exception {

    static final long serialVersionUID = 1L;

    /***
     *
     * @param message
     *
     * class and method to handle exceptions related to remove-method in class=Department.
     */

    public RemoveException(String message) {
        super(message);
    }
}
