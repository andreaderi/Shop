package Shop.actionListeners;

import Shop.view.LoginFrame;
import Shop.view.FirstPageFrame;
import Shop.view.IscrizioneFrame;
import Shop.view.CatalogoFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPageListener implements ActionListener {


        private FirstPageFrame first;

        public FirstPageListener(FirstPageFrame first) {
            this.first = first;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Evento catturato!");

            if ("Login".equals(e.getActionCommand())) {

                new LoginFrame();
                first.setVisible(false);
            }
            if ("Registrazione".equals(e.getActionCommand())){
                new IscrizioneFrame();
                first.setVisible(false);
            }
            if("Catalogo".equals(e.getActionCommand())){
                new CatalogoFrame();
                first.setVisible(false);
            }
        }

    }

}
