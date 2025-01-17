package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServer {

    private final Controller controller;
    private final List<ServerMessageListener> clientTasks;

    public SocketServer(Controller controller) {
        this.controller = controller;
        clientTasks = new ArrayList<>();
    }

    public void startServer(int portNumber) {
        final ExecutorService threadPool = Executors.newFixedThreadPool(10);

        Runnable serverTask = () -> {
            System.out.println("Server Started");
            try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
                //noinspection InfiniteLoopStatement
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    MultiServerThread newClient = new MultiServerThread(clientSocket, controller);
                    threadPool.submit(newClient);
                    clientTasks.add(newClient);
                }

            } catch (IOException e) {
                System.out.println("Exception caught when trying to listen on port "
                        + portNumber + " or listening for a connection");
                System.out.println(e.getMessage());
            }
        };

        Thread serverThread = new Thread(serverTask);
        serverThread.start();
    }

    public void requestToyInformation() {
        for (ServerMessageListener listener : clientTasks) {
            listener.requestToyInformation();
        }
    }

    public void requestToyId() {
        for (ServerMessageListener listener : clientTasks) {
            listener.requestToyId();
        }
    }

    public void requestManufacturer() {
        for (ServerMessageListener listener : clientTasks) {
            listener.requestManufacturer();
        }
    }

    public void requestThanks() {
        for (ServerMessageListener listener : clientTasks) {
            listener.requestThanks();
        }
    }

    public void requestAll() {
        for (ServerMessageListener listener : clientTasks) {
            listener.requestAll();
        }
    }
}
