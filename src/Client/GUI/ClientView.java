package Client.GUI;

import javax.swing.*;

public class ClientView extends JFrame {
    private JTabbedPane toyDetailTabs;
    private JTextField idNameField;
    private JTextField idCodeField;
    private JButton idSendBtn;
    private JLabel toyNameLabel;
    private JLabel toyCodeLabel;
    private JPanel toyIdPane;
    private JPanel toyInfoPane;
    private JPanel toyManuPane;
    private JPanel toyAllPane;
    private JPanel toyThanksPane;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton sendButton;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JButton sendButton1;
    private JButton sendThanksButton;
    private JTextArea messageTextArea;
    private JPanel mainPanel;

    public ClientView(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public JTextArea getMessageTextArea() {
        return messageTextArea;
    }

    public JTextField getIdNameField() {
        return idNameField;
    }

    public JTextField getIdCodeField() {
        return idCodeField;
    }

    public JButton getIdSendBtn() {
        return idSendBtn;
    }
}
