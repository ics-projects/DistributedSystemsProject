package Client;

import Models.Toy;

public interface ClientMessageListener {
    void sendToy(Toy toy);
}
