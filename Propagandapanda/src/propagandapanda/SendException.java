/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propagandapanda;

/**
 *
 * @author Michi
 */
public class SendException extends Exception {

    /**
     * Creates a new instance of <code>SendException</code> without detail
     * message.
     */
    public SendException() {
    }

    /**
     * Constructs an instance of <code>SendException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public SendException(String msg) {
        super(msg);
    }
}
