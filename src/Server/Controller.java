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
        mainView.getMessageTextArea().append("Server: Requesting toy information");
        server.requestToyInformation();
    }

    public void init() {
        server = new SocketServer(this);
        server.startServer(this.portNumber);
        System.out.println(mainView.getDefaultCloseOperation());
        mainView.getToyInfoBtn().addActionListener(this::requestToyInfo);
    }

    public void postToy(Toy clientToy) {

    }
}
