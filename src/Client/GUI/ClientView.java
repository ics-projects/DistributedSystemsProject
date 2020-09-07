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
    private JTextField infoNameField;
    private JTextField infoDescField;
    private JTextField infoPriceField;
    private JTextField infoDomField;
    private JTextField infoBatchField;
    private JButton infoSendBtn;
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

    public JTextField getInfoNameField() {
        return infoNameField;
    }

    public JTextField getInfoDescField() {
        return infoDescField;
    }

    public JTextField getInfoPriceField() {
        return infoPriceField;
    }

    public JTextField getInfoDomField() {
        return infoDomField;
    }

    public JTextField getInfoBatchField() {
        return infoBatchField;
    }

    public JButton getInfoSendBtn() {
        return infoSendBtn;
    }
}
