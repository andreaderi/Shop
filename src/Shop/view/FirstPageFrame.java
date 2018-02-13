package Shop.view;

import Shop.actionListeners.FirstPageListener;

import javax.swing.*;
import java.awt.*;

public class FirstPageFrame extends JFrame {

        public FirstPageFrame() {

            super("Nuova finestra");
            Container c = getContentPane();


            c.setLayout(new BorderLayout());

            FirstPageListener listener = new FirstPageListener(this);

            JPanel nord = new JPanel();
            JButton btnLogin = new JButton(("Login"));
            btnLogin.addActionListener(listener);
            btnLogin.setActionCommand("Login");
            nord.add(btnLogin);
            JPanel centro = new JPanel();
            JButton btnRegistrazione = new JButton(("Registrazione"));
            btnRegistrazione.addActionListener(listener);
            btnRegistrazione.setActionCommand("Registrazione");
            centro.add(btnRegistrazione);
            JPanel sud = new JPanel();
            JButton btnCatalogo = new JButton("Visualizza il catalogo");
            btnCatalogo.addActionListener(listener);
            btnCatalogo.setActionCommand("Catalogo");
            sud.add(btnCatalogo);
            c.add(nord, BorderLayout.NORTH);
            setSize(400, 150);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            c.add(centro, BorderLayout.CENTER);
            setSize(400, 150);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            c.add(sud, BorderLayout.SOUTH);
            setSize(400, 150);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }
