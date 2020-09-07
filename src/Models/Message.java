package Models;

import java.io.Serializable;

public class Message implements Serializable {
    private int MessageCode;
    private String Message;

    public void setMessage(String message) {
        Message = message;
    }

    public void setMessageCode(int messageCode) {
        MessageCode = messageCode;
    }

    public int getMessageCode() {
        return MessageCode;
    }

    public String getMessage() {
        return Message;
    }

}
