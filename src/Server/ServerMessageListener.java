package Server;

public interface ServerMessageListener {
    void requestToyInformation();

    void requestToyId();

    void requestManufacturer();

    void requestThanks();

    void requestAll();
}
