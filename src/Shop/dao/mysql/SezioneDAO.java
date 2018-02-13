package Shop.dao.mysql;

import Shop.dao.interfaces.IBaseDAO;
import Shop.dbinterface.Dbconnection;
import Shop.model.Prodotto;
import Shop.model.Sezione;

import java.util.ArrayList;
import java.util.Iterator;

    public class SezioneDAO implements IBaseDAO<Sezione> {

        private static SezioneDAO instance;

        public static SezioneDAO getInstance() {
            if (instance == null)
                instance = new SezioneDAO();
            return instance;
        }


        public Sezione findById(int id) {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM sezione WHERE idsezione=" + id);
            if (risultato.size() == 0) return null;
            Sezione s = new Sezione();
            String[] riga = risultato.get(0);
            s.setIdSezione(Integer.parseInt(riga[0]));
            s.setNome(riga[1]);

            return s;
        }


        public ArrayList<Sezione> findAll() {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM reparto");

            ArrayList<Sezione> listaSezioni = new ArrayList<Sezione>();

            Iterator<String[]> i = risultato.iterator();

            while (i.hasNext()) {
                String[] riga = i.next();
                Sezione s = new Sezione();
                s.setIdSezione(Integer.parseInt(riga[0]));
                s.setNome(riga[1]);

                listaSezioni.add(s);

            }

            return listaSezioni;
        }

        public ArrayList<Prodotto> ricercadanome(String nome) { //cerco i prodotti dal nome della sezione selezionata
            String query1 = "SELECT idsezione FROM sezione WHERE nome='" + nome + "'";
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery(query1);

            String[] riga = risultato.get(0);
            int idsezione = Integer.parseInt(riga[0]);
            String query2 = "SELECT * FROM prodotto WHERE sezione_idsezione='" + idsezione + "'";
            ArrayList<String[]> risultato1 = Dbconnection.getInstance().eseguiQuery(query2);

            ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();

            Iterator<String[]> i = risultato1.iterator();

            while (i.hasNext()) {
                String[] riga1 = i.next();
                Prodotto p = new Prodotto();
                p.setIdProdotto(Integer.parseInt(riga1[0]));
                p.setNome(riga1[1]);
                p.setDescrizionetestuale(riga1[2]);
                p.setPrezzo(Float.parseFloat(riga1[3]));
                p.setSconto(Float.parseFloat(riga1[4]));

                listaProdotti.add(p);

            }

            return listaProdotti;
        }
    }
