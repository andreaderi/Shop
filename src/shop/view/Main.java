package Shop.view;

import Shop.business.SessionManager;

import com.itextpdf.text.DocumentException;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws DocumentException, IOException {
        LoginFrame loginFrame = new LoginFrame();
        SessionManager.getInstance().getSession().put("Finestra Login", loginFrame);
        new LoginFrame();
    }
}
