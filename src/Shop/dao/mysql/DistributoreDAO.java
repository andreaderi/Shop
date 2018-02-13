package Shop.dao.mysql;

import Shop.dao.interfaces.IBaseDAO;
import Shop.dbinterface.Dbconnection;
import Shop.model.Distributore;

import java.util.ArrayList;
import java.util.Iterator;

public class DistributoreDAO implements IBaseDAO<Distributore> {

        private static DistributoreDAO instance;

        public static DistributoreDAO getInstance() {
            if (instance == null)
                instance = new DistributoreDAO();
            return instance;
        }


        public Distributore findById(int id) {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM distributore WHERE iddistributore=" + id);
            if (risultato.size() == 0) return null;
            Distributore d = new Distributore();
            String[] riga = risultato.get(0);
            d.setIdDistributore(Integer.parseInt(riga[0]));
            d.setNome(riga[1]);
            d.setInformazionidistributore(riga[2]);

            return d;
        }


        public ArrayList<Distributore> findAll() {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM distributore");

            ArrayList<Distributore> listaDistributori = new ArrayList<Distributore>();

            Iterator<String[]> i = risultato.iterator();

            while (i.hasNext()) {
                String[] riga = i.next();
                Distributore d = new Distributore();
                d.setIdDistributore(Integer.parseInt(riga[0]));
                d.setNome(riga[1]);
                d.setInformazionidistributore(riga[2]);
                listaDistributori.add(d);

            }

            return listaDistributori;
        }
    }

