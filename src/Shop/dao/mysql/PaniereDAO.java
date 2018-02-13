package Shop.dao.mysql;

import Shop.dao.interfaces.IBaseDAO;
import Shop.dbinterface.Dbconnection;
import Shop.model.Paniere;
import Shop.model.ProdottoSelezionato;
import Shop.model.Prodotto;

import java.util.ArrayList;
import java.util.Iterator;


public class PaniereDAO implements IBaseDAO<Paniere> {
        private static PaniereDAO instance;

        public static PaniereDAO getInstance() {
            if (instance == null)
                instance = new PaniereDAO();
            return instance;
        }


        public Paniere findById(int id) {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM paniere WHERE idpaniere=" + id);
            if (risultato.size() == 0) return null;
            Paniere pan = new Paniere();
            String[] riga = risultato.get(0);
            pan.setIdPaniere(Integer.parseInt(riga[0]));
            pan.setNome(riga[1]);

            return pan;
        }


        public ArrayList<Paniere> findAll() {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM paniere");

            ArrayList<Paniere> listaPanieri = new ArrayList<Paniere>();

            Iterator<String[]> i = risultato.iterator();

            while (i.hasNext()) {
                String[] riga = i.next();
                Paniere pan = new Paniere();
                pan.setIdPaniere(Integer.parseInt(riga[0]));
                pan.setNome(riga[1]);

                listaPanieri.add(pan);

            }

            return listaPanieri;
        }

        public void aggiungiunpaniere(String nome, String data, int id_utenteregistrato) {
            String query1 = "INSERT INTO paniere (nome,data,utenteregistrato_idutenteregistrato)values('" + nome+ "','" + data + "','" + id_utenteregistrato + "')";
            Dbconnection.getInstance().eseguiAggiornamento(query1);
        }

        public int findIdByName(String nome, int id_utenteregistrato) { //cerco il paniere inserendo il suo nome
            String query1 = "SELECT idpaniere FROM paniere WHERE nome='" + nome + "' AND utenteregistrato_idutenteregistrato='" + id_utenteregistrato + "'";
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery(query1);
            String[] riga = risultato.get(0);
            int idPaniere = Integer.parseInt(riga[0]);
            return idPaniere;
        }

        public ArrayList<Paniere> findAllByIdUtente(int id_utente) {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM paniere WHERE utente_idutente='" + id_utente + "'");

            ArrayList<Paniere> listaPanieri = new ArrayList<Paniere>();

            Iterator<String[]> i = risultato.iterator();

            while (i.hasNext()) {
                String[] riga = i.next();
                Paniere pan = new Paniere();
                pan.setIdPaniere(Integer.parseInt(riga[0]));
                pan.setNome(riga[1]);
                pan.setData(riga[2]);

                listaPanieri.add(pan);

            }
            return listaPanieri;


        }

        public ArrayList<Prodotto> trovaiprodottipresentinelpaniere(int id_utenteregistrato,int id_paniere){
            String query1="SELECT * FROM prodotto as P\n " +
                    "join paniere_has_paniere as PHP\n" +
                    "join paniere as PA WHERE PHP.paniere_idpaniere=PA.idpaniere AND PHP.prodotto_idprodotto=P.idprodotto AND PHP.paniere_idpaniere ='"+id_paniere+"' AND PA.utenteregistrato_idutenteregistrato='"+id_utenteregistrato+"' ;";

            ArrayList<String[]> risultato=Dbconnection.getInstance().eseguiQuery(query1);

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

        public void acquistaunprodottodalpaniere(String nome,float prezzo,float sconto,int idUtenteRegistrato,int idProdotto){
            String query = "INSERT INTO prodotto selezionato(nome,prezzo,sconto,prodotto_idprodotto,utenteregistrato_idutenteregistrato) values('"+nome+"','"+prezzo+"','"+sconto+"','"+idProdotto+"','"+idUtenteRegistrato+"');";

            Dbconnection.getInstance().eseguiAggiornamento(query);

        }

    }

