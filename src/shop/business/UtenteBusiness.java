package Shop.business;


public class UtenteBusiness {

    private static UtenteBusiness instance;

    public static UtenteBusiness getInstance() {
        if (instance == null)
            instance = new UtenteBusiness();
        return instance;
    }

    public Persona login(String username, byte[] password) {

        Persona p = PersonaDAO.getInstance().findUserByUsernameAndPassword(username, password);

        return p;
    }
}