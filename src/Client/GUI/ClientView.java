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
    private JTextField manNameField;
    private JTextField manStreetField;
    private JTextField manZipField;
    private JTextField manCountryField;
    private JButton manSendBtn;
    private JButton sendThanksBtn;
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

    public JTextField getManNameField() {
        return manNameField;
    }

    public JTextField getManStreetField() {
        return manStreetField;
    }

    public JTextField getManZipField() {
        return manZipField;
    }

    public JTextField getManCountryField() {
        return manCountryField;
    }

    public JButton getManSendBtn() {
        return manSendBtn;
    }

    public JButton getSendThanksBtn() {
        return sendThanksBtn;
    }
}
