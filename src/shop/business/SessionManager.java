package shop.business;



import java.util.HashMap;

public class SessionManager {

    private static SessionManager instance;

    private HashMap<String, Object> session = new HashMap<String, Object>();

    public HashMap<String, Object> getSession() {
        return session;
    }

    public static SessionManager getInstance() {
        if(instance == null)
            instance = new SessionManager();
        return instance;
    }
}
