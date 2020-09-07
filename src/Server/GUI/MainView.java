package Server.GUI;

import javax.swing.*;

public class MainView extends JFrame {
    private JTextArea messageTextArea;
    private JButton toyInfoBtn;
    private JButton toyIdBtn;
    private JPanel mainPanel;
    private JButton toyManuBtn;
    private JButton thanksBtn;
    private JButton allBtn;

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

    public JButton getToyIdBtn() {
        return toyIdBtn;
    }

    public JButton getToyManuBtn() {
        return toyManuBtn;
    }

    public JButton getThanksBtn() {
        return thanksBtn;
    }

    public JButton getAllBtn() {
        return allBtn;
    }
}
