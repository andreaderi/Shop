package Shop.dao.mysql;

import Shop.dao.interfaces.IBaseDAO;
import Shop.dbinterface.Dbconnection;
import Shop.model.Prodotto;

import java.util.ArrayList;
import java.util.Iterator;

    public class ProdottoDAO implements IBaseDAO<Prodotto> {
        private static ProdottoDAO instance;

        public static ProdottoDAO getInstance() {
            if (instance == null)
                instance = new ProdottoDAO();
            return instance;
        }


        public Prodotto findById(int id) {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM prodotto WHERE idprodotto=" + id);
            if (risultato.size() == 0) return null;
            Prodotto p = new Prodotto();
            String[] riga = risultato.get(0);
            p.setIdProdotto(Integer.parseInt(riga[0]));
            p.setNome(riga[1]);
            p.setDescrizionetestuale(riga[2]);
            p.setPrezzo(Float.parseFloat(riga[3]));
            p.setSconto(Float.parseFloat(riga[4]));

            return p;
        }


        public ArrayList<Prodotto> findAll() {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM prodotto");

            ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();

            Iterator<String[]> i = risultato.iterator();

            while (i.hasNext()) {
                String[] riga = i.next();
                Prodotto p = new Prodotto();
                p.setIdProdotto(Integer.parseInt(riga[0]));
                p.setNome(riga[1]);
                p.setDescrizionetestuale(riga[2]);
                p.setPrezzo(Float.parseFloat(riga[3]));
                p.setSconto(Float.parseFloat(riga[4]));

                listaProdotti.add(p);

            }

            return listaProdotti;
        }


        public void aggiungounprodottoalcatalogo(String nome, String descrizionetestuale, float prezzo, float sconto, String categoria, String distributore, String produttore, String sezione) {

            String query5 = "SELECT idcategoria FROM categoria where nome='" + categoria + "'";
            ArrayList<String[]> ris1 = Dbconnection.getInstance().eseguiQuery(query5);
            String[] riga1 = ris1.get(0);

            int idcategoria = Integer.parseInt(riga1[0]);

            String query6 = "SELECT iddistributore FROM distributore where nome='" + distributore + "'";
            ArrayList<String[]> ris2 = Dbconnection.getInstance().eseguiQuery(query6);
            String[] riga2 = ris2.get(0);

            int iddistributore = Integer.parseInt(riga2[0]);

            String query7 = "SELECT idproduttore FROM produttore where nome='" + produttore + "'";
            ArrayList<String[]> ris3 = Dbconnection.getInstance().eseguiQuery(query7);
            String[] riga3 = ris3.get(0);

            int idproduttore = Integer.parseInt(riga3[0]);


            String query8 = "SELECT idsezione FROM sezione where nome='" + sezione + "'";
            ArrayList<String[]> ris4 = Dbconnection.getInstance().eseguiQuery(query8);
            String[] riga4 = ris4.get(0);

            int idsezione = Integer.parseInt(riga4[0]);


            String query9 = "INSERT INTO prodotto(nome,descrizionetestuale,prezzo,sconto,categoria_idcategoria,distributore_iddistributore,produttore_idproduttore,sezione_idsezione) values('" + nome + "','" + descrizionetestuale + "','" + prezzo + "','" + sconto + "','" + idcategoria + "','" + iddistributore + "','" + idproduttore + "','" + idsezione + "');";
            Dbconnection.getInstance().eseguiAggiornamento(query9);

        }

        public void eliminaunprodottodalcatalogo(int id_prodotto) {
            String query1 = "DELETE FROM prodotto where idprodotto='" + id_prodotto + "';";
            String query2 = "DELETE FROM prodotto selezionato where prodotto_idprodotto='" + id_prodotto + "'";
            String query3 = "DELETE FROM paniere has prodotto where prodotto_idprodotto='" + id_prodotto + "'";
            String query4 = "DELETE FROM prodotto has prodotto where prodotto_idprodotto='" + id_prodotto + "'";
            Dbconnection.getInstance().eseguiAggiornamento(query1);
            Dbconnection.getInstance().eseguiAggiornamento(query2);
            Dbconnection.getInstance().eseguiAggiornamento(query3);
            Dbconnection.getInstance().eseguiAggiornamento(query4);
        }
    }