package shop.view;

import shop.business.SessionManager;

public class Main {
    public static void main(String args[]) {
        HomeFrame HomeFrame = new HomeFrame();
        SessionManager.getInstance().getSession().put("Finestra_Home", HomeFrame);

    }
}