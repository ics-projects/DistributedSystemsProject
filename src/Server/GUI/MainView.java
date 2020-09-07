package Server.GUI;

import javax.swing.*;

public class MainView extends JFrame {
    private JTextArea messageTextArea;
    private JButton toyInfoBtn;
    private JButton toyIdBtn;
    private JPanel mainPanel;

    public MainView(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public JButton getToyInfoBtn() {
        return toyInfoBtn;
    }

    public JTextArea getMessageTextArea() {
        return messageTextArea;
    }
}
