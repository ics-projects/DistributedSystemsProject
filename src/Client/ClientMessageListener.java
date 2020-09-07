package Client;

import Models.Toy;

public interface ClientMessageListener {
    void sendToyId(Toy toy);
}
