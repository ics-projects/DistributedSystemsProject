package Server;

import Models.Constants;
import Models.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class ServerProtocol {
    private Message message;
    private final ObjectOutputStream objectOutputStream;

    public ServerProtocol(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }

    public void requestToyName() throws IOException {
        message = new Message();
        message.setMessageText(Constants.MESSAGE_A);
        message.setCode(Constants.A);
        objectOutputStream.writeObject(message);
    }

    public void requestThanks() throws IOException {
        message = new Message();
        message.setMessageText(Constants.MESSAGE_D);
        message.setCode(Constants.D);
        objectOutputStream.writeObject(message);
    }

    public void requestManufacturerDetails() throws IOException {
        message = new Message();
        message.setMessageText(Constants.MESSAGE_C);
        message.setCode(Constants.C);
        objectOutputStream.writeObject(message);
    }

    public void sendWelcomeMessage() throws IOException {
        message = new Message();
        message.setCode(Constants.WELCOME);
        message.setMessageText(Constants.WELCOME_MESSAGE);
        objectOutputStream.writeObject(message);
    }

    public void requestToyInformation() throws IOException {
        message = new Message();
        message.setCode(Constants.B);
        message.setMessageText(Constants.MESSAGE_B);
        objectOutputStream.writeObject(message);
    }

    public void requestToyIdentification() throws IOException {
        message = new Message();
        message.setCode(Constants.B);
        message.setMessageText(Constants.MESSAGE_A);
        objectOutputStream.writeObject(message);
    }

    public void requestAllToyInformation() throws IOException {
        message = new Message();
        message.setCode(Constants.E);
        message.setMessageText(Constants.MESSAGE_E);
        objectOutputStream.writeObject(message);
    }
}
