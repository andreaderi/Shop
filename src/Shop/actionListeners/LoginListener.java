package Shop.actionListeners;

import Shop.business.SessionManager;
import Shop.business.UtenteBusiness;
import Shop.view.LoginFrame;
import Shop.view.CatalogoFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginListener implements ActionListener{

    private LoginFrame finestra;

    public LoginListener(LoginFrame finestra) {
        this.finestra = finestra;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("Evento catturato!");

        if ("RANDOM_MENU_ITEM".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(null, "Hai premuto la voce di menu random");
        }
        if (e.getSource() instanceof JButton
                || e.getSource() instanceof JTextField
                || e.getSource() instanceof JPasswordField) {


                /*String username = "gabri.vitti";
                byte[] password = "Password1".getBytes();*/

            String username = finestra.getTxtUsername().getText();
            byte[] password = new String(finestra.getTxtPassword().getPassword()).getBytes();

            Utente u = UtenteBusiness.getInstance().login(username, password);

            if (u != null) {
                System.out.println("LOGIN OK!");

                if (u.ruolo == 0) {

                    //visualizzo l'interfaccia dell'amministratore del servizio

                    System.out.println("Benvenuto amministratore " + u.getNome() + " " + u.getCognome() + "!");
                    JOptionPane.showMessageDialog(null, "Benvenuto amministratore " + u.getNome() + " " + u.getCognome() + "!");
                    SessionManager.getInstance().getSession().put("amministratore", a);
                    new CatalogoFrame();
                    finestra.setVisible(false);
                }

                else if (u.ruolo == 1) {

                    //visualizzo l'interfaccia del gestore del catalogo

                    System.out.println("Benvenuto gestore del catalogo " + u.getNome() + " " + u.getCognome() + "!");

                    JOptionPane.showMessageDialog(null, "Benvenuto gestore " + u.getNome() + " " + u.getCognome() + "!");
                    SessionManager.getInstance().getSession().put("gestore", g);
                    new CatalogoFrame();
                    finestra.setVisible(false);
                }

                else if (u.ruolo == 2){

                    //visualizzo l'interfaccia dell'utente registrato

                    System.out.println("Benvenuto utente registrato" + u.getNome() + " " + u.getCognome() + "!");
                    JOptionPane.showMessageDialog(null, "Benvenuto utente registrato " + u.getNome() + " " + u.getCognome() + "!");
                    SessionManager.getInstance().getSession().put("utente", u);
                    new CatalogoFrame();
                    finestra.setVisible(false);}

            } else {
                System.out.println("Il login non è andato a buon fine...");
                JOptionPane.showMessageDialog(null,"Il login non è andato a buon fine...");
            }
        }
    }
}