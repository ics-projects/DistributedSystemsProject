package Server;

import Server.GUI.MainView;

public class App {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: java Server.SocketServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        MainView jFrame = new MainView("Server GUI");
        jFrame.setVisible(true);

        Controller controller = new Controller(portNumber, jFrame);
        controller.init();
    }

}
