package Shop.dao.mysql;

import Shop.dao.interfaces.IBaseDAO;
import Shop.dbinterface.Dbconnection;
import Shop.model.Indirizzo;

import java.util.ArrayList;
import java.util.Iterator;


    public class IndirizzoDAO implements IBaseDAO<Indirizzo> {
        private static IndirizzoDAO instance;

        public static IndirizzoDAO getInstance() {
            if (instance == null)
                instance = new IndirizzoDAO();
            return instance;
        }


        public Indirizzo findById(int id) {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM indirizzo WHERE idindirizzo=" + id);
            if (risultato.size() == 0) return null;
            Indirizzo i = new Indirizzo();
            String[] riga = risultato.get(0);
            i.setIdIndirizzo(Integer.parseInt(riga[0]));
            i.setVia(riga[1]);
            i.setNumero_civico(riga[2]);
            i.setNazione(riga[3]);
            i.setCitta(riga[4]);
            i.setProvincia(riga[5]);
            i.setCAP(riga[6]);

            return i;
        }


        public ArrayList<Indirizzo> findAll() {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM indirizzo");

            ArrayList<Indirizzo> listaIndirizzi = new ArrayList<Indirizzo>();

            Iterator<String[]> f = risultato.iterator();

            while (f.hasNext()) {
                String[] riga = f.next();
                Indirizzo i = new Indirizzo();
                i.setIdIndirizzo(Integer.parseInt(riga[0]));
                i.setVia(riga[1]);
                i.setNumero_civico(riga[2]);
                i.setNazione(riga[3]);
                i.setCitta(riga[4]);
                i.setProvincia(riga[5]);
                i.setCAP(riga[6]);

                listaIndirizzi.add(i);

            }

            return listaIndirizzi;
        }


        public ArrayList<Indirizzo> findindirizzobyid(int id_utenteregistrato) {
            String query1 = ("SELECT* FROM indirizzo where utenteregistrato_idutenteregistrato='" + id_utenteregistrato + "'");

            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery(query1);

            ArrayList<Indirizzo> listaIndirizzi = new ArrayList<Indirizzo>();

            Iterator<String[]> f = risultato.iterator();

            while (f.hasNext()) {
                String[] riga = f.next();
                Indirizzo i = new Indirizzo();
                i.setIdIndirizzo(Integer.parseInt(riga[0]));
                i.setVia(riga[1]);
                i.setNumero_civico(riga[2]);
                i.setNazione(riga[3]);
                i.setCitta(riga[4]);
                i.setProvincia(riga[5]);
                i.setCAP(riga[6]);

                listaIndirizzi.add(i);

            }

            return listaIndirizzi;
        }


        public void inserimentodiunnuovoindirizzo(String via,String numero_civico,String nazione,String citta,String provincia, int CAP, int id_utenteregistrato){
            String query1="INSERT INTO indirizzo(via,numero_civico,nazione,citta,provincia,CAP) values('"+via+"','"+numero_civico+"','"+nazione+"','"+citta+"','"+provincia+"','"+CAP+"','"+id_utenteregistrato+"')";
            Dbconnection.getInstance().eseguiAggiornamento(query1);
        }
    }
