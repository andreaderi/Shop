package Shop.view;

import Shop.actionListeners.LoginListener;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField txtUsername = new JTextField();
    private JPasswordField txtPassword = new JPasswordField();

    public LoginFrame() {
        super("Nuova finestra");
        Container c = getContentPane();



        c.setLayout(new BorderLayout());

        LoginListener listener = new LoginListener(this);

        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(2,2));
        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        centro.add(lblUsername);
        centro.add(txtUsername);
        centro.add(lblPassword);
        centro.add(txtPassword);
        txtUsername.addActionListener(listener);
        txtPassword.addActionListener(listener);

        JPanel sud = new JPanel();
        sud.setLayout(new FlowLayout());
        sud.add(new JLabel("Benvenuto!"));
        JButton btnLogin = new JButton(("LOGIN"));
        btnLogin.addActionListener(listener);
        sud.add(btnLogin);

        c.add(centro, BorderLayout.CENTER);
        c.add(sud, BorderLayout.SOUTH);

        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu move = new JMenu("Move");
        move.add(new JMenuItem("Up"));
        move.add(new JMenuItem("Down"));
        bar.add(file);
        bar.add(edit);
        edit.add(move);
        JMenuItem random = new JMenuItem("Random");
        edit.add(random);
        random.addActionListener(listener);
        random.setActionCommand("RANDOM_MENU_ITEM");

        setJMenuBar(bar);


        setSize(400,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }
}
