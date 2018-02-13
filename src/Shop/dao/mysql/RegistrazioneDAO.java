package Shop.dao.mysql;

import Shop.dao.interfaces.IBaseDAO;
import Shop.dbinterface.Dbconnection;
import Shop.model.Registrazione;

import java.util.ArrayList;
import java.util.Iterator;

public class RegistrazioneDAO implements IBaseDAO<Registrazione> {

        private static RegistrazioneDAO instance;

        public static RegistrazioneDAO getInstance() {
            if (instance == null)
                instance = new RegistrazioneDAO();
            return instance;
        }

    public Registrazione findById(int id) {
        ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM registrazione WHERE idregistrazione=" + id);
        if (risultato.size() == 0) return null;
        Registrazione reg = new Registrazione();
        String[] riga = risultato.get(0);
        reg.setIdRegistrazione(Integer.parseInt(riga[0]));
        reg.setNome(riga[1]);
        reg.setCognome(riga[2]);
        reg.setEmail(riga[3]);
        reg.setUsername(riga[4]);
        reg.setPassword(riga[5].getBytes());
        reg.setConferma(Integer.parseInt(riga[6]));
        reg.setMessaggiodiconferma(riga[7]);
        reg.setUtenteregistrato_idutenteregistrato(Integer.parseInt(riga[8]));


        return reg;
    }

        public ArrayList<Registrazione> findAll() {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM registrazione");

            ArrayList<Registrazione> listaRegistrazioni = new ArrayList<Registrazione>();

            Iterator<String[]> i = risultato.iterator();

            while (i.hasNext()) {
                String[] riga = i.next();
                Registrazione reg = new Registrazione();
                reg.setNome(riga[1]);
                reg.setCognome(riga[2]);
                reg.setEmail(riga[3]);
                reg.setUsername(riga[4]);
                reg.setPassword(riga[5].getBytes());
                reg.setConferma(Integer.parseInt(riga[6]));
                if(reg.getConferma()== 0){
                    reg.setMessaggiodiconferma("L'amministratore sta valutando la sua registrazione, la preghiamo di attendere");
                }
                else if(reg.getConferma()==1){
                    reg.setMessaggiodiconferma("La sua registrazione è stata negata, la preghiamo di riprovare");
                }
                else if(reg.getConferma()==2){
                    reg.setMessaggiodiconferma("La sua registrazione è stata effettuata con successo");
                }
                reg.setUtenteregistrato_idutenteregistrato(Integer.parseInt(riga[7]));
                listaRegistrazioni.add(reg);

            }

            return listaRegistrazioni;
        }

        public void confermadellaregistrazione(int id_registrazione,int utenteregistrato_idutenteregistrato){
            String query1="UPDATE registrazione SET conferma=2 WHERE idregistrazione='"+id_registrazione+"'";
            Dbconnection.getInstance().eseguiAggiornamento(query1);
            String query2="UPDATE utente registrato SET ruolo=2 WHERE idutenteregistrato='"+utenteregistrato_idutenteregistrato+"'";
            Dbconnection.getInstance().eseguiAggiornamento(query2);
        }

        public void negazionedellaregistrazione(int id_registrazione){
            String query1="UPDATE registrazione SET conferma=1 WHERE registrazione='"+id_registrazione+"'";
            Dbconnection.getInstance().eseguiAggiornamento(query1);
        }

    }
