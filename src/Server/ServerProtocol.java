package Server;

import Models.Constants;
import Models.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class ServerProtocol {
    private Message message;
    private final ObjectOutputStream objectOutputStream;

    public ServerProtocol(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }

    public void requestToyName() throws IOException {
        message = new Message();
        message.setMessage(Constants.MESSAGE_A);
        message.setMessageCode(Constants.A);
        objectOutputStream.writeObject(message);
    }

    public void requestMessage() throws IOException {
        message = new Message();
        message.setMessage(Constants.MESSAGE_D);
        message.setMessageCode(Constants.D);
        objectOutputStream.writeObject(message);
    }

    public void requestManufacturerDetails() throws IOException {
        message = new Message();
        message.setMessage(Constants.MESSAGE_C);
        message.setMessageCode(Constants.C);
        objectOutputStream.writeObject(message);
    }

    public void sendWelcomeMessage() throws IOException {
        message = new Message();
        message.setMessageCode(Constants.WELCOME);
        message.setMessage(Constants.WELCOME_MESSAGE);
        objectOutputStream.writeObject(message);
    }

    public void requestToyInformation() throws IOException {
        message = new Message();
        message.setMessageCode(Constants.B);
        message.setMessage(Constants.MESSAGE_B);
        objectOutputStream.writeObject(message);
    }

    public void requestAllToyInformation() throws IOException {
        message = new Message();
        message.setMessageCode(Constants.E);
        message.setMessage(Constants.MESSAGE_E);
        objectOutputStream.writeObject(message);
    }

    public String testInput(String input) {
        return "Hello!";
    }


//    public String processInput(String theInput) {
//        String theOutput = null;
//
//        if (state == WAITING) {
//            theOutput = "Knock! Knock!";
//            state = SENTKNOCKKNOCK;
//        } else if (state == SENTKNOCKKNOCK) {
//            if (theInput.equalsIgnoreCase("Who's there?")) {
//                theOutput = clues[currentJoke];
//                state = SENTCLUE;
//            } else {
//                theOutput = "You're supposed to say \"Who's there?\"! " +
//                        "Try again. Knock! Knock!";
//            }
//        } else if (state == SENTCLUE) {
//            if (theInput.equalsIgnoreCase(clues[currentJoke] + " who?")) {
//                theOutput = answers[currentJoke] + " Want another? (y/n)";
//                state = ANOTHER;
//            } else {
//                theOutput = "You're supposed to say \"" +
//                        clues[currentJoke] +
//                        " who?\"" +
//                        "! Try again. Knock! Knock!";
//                state = SENTKNOCKKNOCK;
//            }
//        } else if (state == ANOTHER) {
//            if (theInput.equalsIgnoreCase("y")) {
//                theOutput = "Knock! Knock!";
//                if (currentJoke == (NUMJOKES - 1))
//                    currentJoke = 0;
//                else
//                    currentJoke++;
//                state = SENTKNOCKKNOCK;
//            } else {
//                theOutput = "Bye.";
//                state = WAITING;
//            }
//        }
//        return theOutput;
//    }

}
