package Server;

import Models.Toy;

import java.io.*;
import java.net.Socket;

public class MultiServerThread implements Runnable, MessagesListener {
    private final Socket socket;
    private ServerProtocol serverProtocol;
    private final Controller controller;

    public MultiServerThread(Socket socket, Controller controller) {
        this.socket = socket;
        this.controller = controller;
    }

    @Override
    public void run() {
        try (
                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)
        ) {
            System.out.println("Connected to host: " + socket.getInetAddress().getHostAddress() + " on port: " + socket.getPort());


            serverProtocol = new ServerProtocol(objectOutputStream);
            serverProtocol.sendWelcomeMessage();

            while (socket.getInputStream() != null) {
                Toy clientToy = (Toy) objectInputStream.readObject();
                System.out.println("Received from client: " + clientToy.getName());
                controller.postToy(clientToy);
            }

            socket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void requestToyInformation() {
        try {
            serverProtocol.requestToyInformation();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
