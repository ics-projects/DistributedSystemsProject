package Client;

import Models.Message;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println(
                    "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
                Socket socket = new Socket(hostName, portNumber);
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)
        ) {
            System.out.println("Server Connected...");

            while (socket.getInputStream() != null) {
                Message message = (Message) objectInputStream.readObject();
                System.out.println(message.getMessage());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
