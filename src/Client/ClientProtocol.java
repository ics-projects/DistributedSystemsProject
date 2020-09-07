package Client;

import Models.Toy;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClientProtocol {

    private ObjectOutputStream objectOutputStream;

    public ClientProtocol(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }

    public void sendToyId(Toy toy) throws IOException {
        objectOutputStream.writeObject(toy);
    }
}
