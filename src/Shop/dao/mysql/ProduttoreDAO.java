package Shop.dao.mysql;

import Shop.dao.interfaces.IBaseDAO;
import Shop.dbinterface.Dbconnection;
import Shop.model.Produttore;

import java.util.ArrayList;
import java.util.Iterator;


    public class ProduttoreDAO implements IBaseDAO<Produttore> {
        private static ProduttoreDAO instance;

        public static ProduttoreDAO getInstance() {
            if (instance == null)
                instance = new ProduttoreDAO();
            return instance;
        }


        public Produttore findById(int id) {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM produttore WHERE idproduttore=" + id);
            if (risultato.size() == 0) return null;
            Produttore prod = new Produttore();
            String[] riga = risultato.get(0);
            prod.setIdProduttore(Integer.parseInt(riga[0]));
            prod.setNome(riga[1]);
            prod.setInformazioniproduttore(riga[2]);

            return prod;
        }


        public ArrayList<Produttore> findAll() {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM produttore");

            ArrayList<Produttore> listaProduttori = new ArrayList<Produttore>();

            Iterator<String[]> i = risultato.iterator();

            while (i.hasNext()) {
                String[] riga = i.next();
                Produttore prod = new Produttore();
                prod.setIdProduttore(Integer.parseInt(riga[0]));
                prod.setNome(riga[1]);
                prod.setInformazioniproduttore(riga[2]);


                listaProduttori.add(prod);

            }

            return listaProduttori;
        }

    }
