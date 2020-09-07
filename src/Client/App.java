package Client;

import Client.GUI.ClientView;

public class App {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println(
                    "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        ClientView jFrame = new ClientView("Client GUI");
        jFrame.setVisible(true);

        Controller controller = new Controller(hostName, portNumber, jFrame);
        controller.init();
    }

}
