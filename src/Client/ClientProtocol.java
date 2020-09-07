package Client;

import Models.Toy;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClientProtocol {

    private final ObjectOutputStream objectOutputStream;

    public ClientProtocol(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }

    public void sendToy(Toy toy) throws IOException {
        objectOutputStream.writeObject(toy);
    }
}
