package Server;

import Models.Toy;
import Server.GUI.MainView;

import java.awt.event.ActionEvent;

public class Controller {

    private final MainView mainView;
    private final int portNumber;
    private SocketServer server;

    public Controller(int portNumber, MainView mainView) {
        this.mainView = mainView;
        this.portNumber = portNumber;
    }

    private void requestToyInfo(ActionEvent event) {
        mainView.getMessageTextArea().append("Server: Requesting toy information\n");
        server.requestToyInformation();
    }

    private void requestToyId(ActionEvent event) {
        mainView.getMessageTextArea().append("Server: Requesting toy identification\n");
        server.requestToyId();
    }

    private void requestManufacturer(ActionEvent event) {
        mainView.getMessageTextArea().append("Server: Requesting Manufacturer Details\n");
        server.requestManufacturer();
    }

    public void init() {
        server = new SocketServer(this);
        server.startServer(this.portNumber);
        mainView.getToyInfoBtn().addActionListener(this::requestToyInfo);
        mainView.getToyIdBtn().addActionListener(this::requestToyId);
        mainView.getToyManuBtn().addActionListener(this::requestManufacturer);
        mainView.getThanksBtn().addActionListener(this::requestThanks);
        mainView.getAllBtn().addActionListener(this::requestAll);
    }

    private void requestAll(ActionEvent event) {
        mainView.getMessageTextArea().append("Server: Requesting all Information\n");
        server.requestAll();
    }

    private void requestThanks(ActionEvent event) {
        mainView.getMessageTextArea().append("Server: Requesting thanks with unique code\n");
        server.requestThanks();
    }

    public void postToy(Toy clientToy) {

    }
}
