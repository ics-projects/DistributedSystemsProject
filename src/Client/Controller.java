package Client;

import Client.GUI.ClientView;
import Models.Message;
import Models.Toy;
import Models.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Controller {
    private final String hostName;
    private final int portNumber;
    private final ClientView view;
    private SocketClient socketClient;

    public Controller(String hostName, int portNumber, ClientView view) {
        this.hostName = hostName;
        this.portNumber = portNumber;
        this.view = view;
    }

    public void init() {
        socketClient = new SocketClient(this);
        socketClient.startClient(hostName, portNumber);
        view.getIdSendBtn().addActionListener(this::sendToyIdentification);
    }

    private void sendToyIdentification(ActionEvent event) {
        JTextField nameField = view.getIdNameField();
        JTextField codeField = view.getIdCodeField();

        Toy toy = new Toy();
        toy.setName(nameField.getText());
        toy.setCode(codeField.getText());

        socketClient.sendToyId(toy);
        nameField.setText(null);
        codeField.setText(null);
        JOptionPane.showMessageDialog(null, "Data Sent");
    }

    public void postMessage(Message message) {
        view.getMessageTextArea().append(message.getMessageText() + "\n");
    }

    public void postToy(Toy clientToy) {
        view.getMessageTextArea().append("Client : " + Util.printToyObject(clientToy) + "\n");
    }
}
