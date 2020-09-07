package Models;

import java.io.Serializable;

public class Message implements Serializable {
    private int code;
    private String messageText;

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessageText() {
        return messageText;
    }

}
