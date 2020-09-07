package Server;

import Server.GUI.MainView;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

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

        MainView jFrame = new MainView("Server GUI");
        jFrame.setVisible(true);

        Controller controller = new Controller(portNumber, jFrame);
        controller.init();
    }

}
