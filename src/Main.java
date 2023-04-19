import jdk.jshell.execution.FailOverExecutionControlProvider;
import org.w3c.dom.events.EventException;

import java.rmi.server.ExportException;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {


        try {
            int a = 3;
            int b = 0;
            int x= a/b;
        } catch (ArithmeticException err) {
            System.out.println("1) " + err.getMessage());
        }

        try {
            throw  new NullPointerException("NullPointerException");
        } catch (NullPointerException err) {
            System.out.println("2) " + err.getMessage());
        }

        try {
            throw  new ExportException("ExportException");
        } catch (ExportException err) {
            System.out.println("3) " + err.getMessage());
        }

        try {
            throw  new EventException((short) 1, "EventException");
        } catch (EventException err) {
            System.out.println("4) " + err.getMessage());
        }

        try {
            throw  new RuntimeException("RuntimeException");
        } catch (RuntimeException err) {
            System.out.println("5) " + err.getMessage());
        }

        try {
            throw  new ArrayStoreException("ArrayStoreException");
        } catch (ArrayStoreException err) {
            System.out.println("6) " + err.getMessage());
        }

        try {
            throw  new ClassNotFoundException("EventException");
        } catch (ClassNotFoundException err) {
            System.out.println("7) " + err.getMessage());
        }

        try {
            throw  new ArrayException("ArrayException");
        } catch (ArrayException err) {
            System.out.println("7) " + err.getMessage());
        }

        try {
            throw  new StringException("StringException");
        } catch (StringException err) {
            System.out.println("7) " + err.getMessage());
        }
    }
}

class ArrayException extends Exception {

    private String message = "";

    public ArrayException() {
        super();
    }

    public ArrayException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return "Custom ArrayException: " + message;
    }
}
class StringException extends Exception {

    private String message = "";

    public StringException() {
        super();
    }

    public StringException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return "Custom StringException: " + message;
    }
}

