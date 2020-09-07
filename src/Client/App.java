package Client;

import Client.GUI.ClientView;
import Models.Util;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
//        if (args.length != 2) {
//            System.err.println(
//                    "Usage: java EchoClient <host name> <port number>");
//            System.exit(1);
//        }
//
//        String hostName = args[0];
//        int portNumber = Integer.parseInt(args[1]);

        String hostName = (String) JOptionPane.showInputDialog(null,
                "Input server host IPv4 address", "Client Gui", JOptionPane.PLAIN_MESSAGE,
                null, null, "127.0.0.1");

        if (Util.isValidInet4Address(hostName)) {
            String portNumberString = (String) JOptionPane.showInputDialog(null,
                    "Input server port number", "Server Gui", JOptionPane.PLAIN_MESSAGE,
                    null, null, "4444");

            int portNumber = 4444;
            try {
                portNumber = Integer.parseInt(portNumberString);
            } catch (NumberFormatException e) {
                System.err.println("Invalid port number");
                JOptionPane.showMessageDialog(null,
                        "Invalid port number",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }

            ClientView jFrame = new ClientView("Client GUI");
            jFrame.setVisible(true);

            Controller controller = new Controller(hostName, portNumber, jFrame);
            controller.init();
        } else {
            System.err.println("Invalid IPv4 address");
            JOptionPane.showMessageDialog(null,
                    "Invalid IPv4 address",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

}
