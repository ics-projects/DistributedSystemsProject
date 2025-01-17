package Client;

import Client.GUI.ClientView;
import Models.Message;
import Models.Toy;
import Models.ToyManufacturer;
import Models.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.UUID;

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
        view.getInfoSendBtn().addActionListener(this::sendToyInformation);
        view.getManSendBtn().addActionListener(this::sendManufacturing);
        view.getSendThanksBtn().addActionListener(this::sendThanks);
    }

    private void sendThanks(ActionEvent event) {
        UUID uuid = UUID.randomUUID();

        Toy toy = new Toy();
        toy.setName("Thanks - " + uuid.toString());
        socketClient.sendToy(toy);
    }

    private void sendManufacturing(ActionEvent event) {
        JTextField nameField = view.getInfoNameField();
        JTextField streetField = view.getManStreetField();
        JTextField zipField = view.getManZipField();
        JTextField countryField = view.getManCountryField();

        if (nameField.getText().isEmpty() || streetField.getText().isEmpty() ||
                zipField.getText().isEmpty() || countryField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Missing Data");
            return;
        }

        ToyManufacturer toyManufacturer = new ToyManufacturer();
        toyManufacturer.setCompanyName(nameField.getText());
        toyManufacturer.setStreetAddress(streetField.getText());
        toyManufacturer.setZipCode(zipField.getText());
        toyManufacturer.setCountry(countryField.getText());

        Toy toy = new Toy();
        toy.setToyManufacturer(toyManufacturer);
        socketClient.sendToy(toy);

        nameField.setText(null);
        streetField.setText(null);
        zipField.setText(null);
        countryField.setText(null);
        JOptionPane.showMessageDialog(null, "Data Sent");
    }

    private void sendToyInformation(ActionEvent event) {
        JTextField nameField = view.getInfoNameField();
        JTextField description = view.getInfoDescField();
        JTextField price = view.getInfoPriceField();
        JTextField dom = view.getInfoDomField();
        JTextField batchNumber = view.getInfoBatchField();

        if (nameField.getText().isEmpty() || description.getText().isEmpty() ||
                price.getText().isEmpty() || dom.getText().isEmpty() ||
                batchNumber.getText().isEmpty()
        ) {
            JOptionPane.showMessageDialog(view, "Missing Data");
            return;
        }

        try {
            Toy toy = new Toy();
            toy.setName(nameField.getText());
            toy.setDescription(description.getText());
            toy.setPrice(Integer.parseInt(price.getText()));
            toy.setDom(dom.getText());
            toy.setBatchNumber(batchNumber.getText());

            socketClient.sendToy(toy);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Invalid price");
            return;
        }

        nameField.setText(null);
        description.setText(null);
        price.setText(null);
        dom.setText(null);
        batchNumber.setText(null);

        JOptionPane.showMessageDialog(null, "Data Sent");
    }

    private void sendToyIdentification(ActionEvent event) {
        JTextField nameField = view.getIdNameField();
        JTextField codeField = view.getIdCodeField();

        if (nameField.getText().isEmpty() || codeField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Missing Data");
            return;
        }

        Toy toy = new Toy();
        toy.setName(nameField.getText());
        toy.setCode(codeField.getText());

        socketClient.sendToy(toy);
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

    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(view,
                errorMessage,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
