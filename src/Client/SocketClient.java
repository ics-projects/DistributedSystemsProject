package Client;

import Models.Message;
import Models.Toy;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient implements ClientMessageListener {

    private final Controller controller;
    private ClientProtocol clientProtocol;

    public SocketClient(Controller controller) {
        this.controller = controller;
    }

    public void startClient(String hostName, int portNumber) {
        Runnable clientApp = () -> {
            try (
                    Socket socket = new Socket(hostName, portNumber);
                    InputStream inputStream = socket.getInputStream();
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

                    OutputStream outputStream = socket.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)
            ) {
                System.out.println("Server Connected...");

                clientProtocol = new ClientProtocol(objectOutputStream);

                while (socket.getInputStream() != null) {
                    Message message = (Message) objectInputStream.readObject();
                    System.out.println(message.getMessageText());
                    controller.postMessage(message);
                }
            } catch (UnknownHostException e) {
                System.err.println("Don't know about host " + hostName);
                controller.showError("Don't know about host " + hostName);
                System.exit(1);
            } catch (ConnectException e) {
                System.err.println("Connection Refused");
                controller.showError("Connection Refused");
                System.exit(1);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Couldn't get I/O for the connection to " +
                        hostName);
                controller.showError("Couldn't get I/O for the connection to " +
                        hostName);
                System.exit(1);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                controller.showError("Error occured");
                System.exit(1);
            }
        };

        Thread clientSocketThread = new Thread(clientApp);
        clientSocketThread.start();
    }

    @Override
    public void sendToy(Toy toy) {
        try {
            clientProtocol.sendToy(toy);
            controller.postToy(toy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
