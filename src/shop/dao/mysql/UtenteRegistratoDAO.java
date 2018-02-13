package Shop.dao.mysql;

import Shop.dao.interfaces.IBaseDAO;
import Shop.dbinterface.Dbconnection;
import Shop.model.UtenteRegistrato;

import java.util.ArrayList;
import java.util.Iterator;

public class UtenteRegistratoDAO implements IBaseDAO<UtenteRegistrato> {

        //singleton design pattern
        private static UtenteRegistratoDAO instance;

        public static UtenteRegistratoDAO getInstance(){

            if (instance==null)
                instance = new UtenteRegistratoDAO();
            return instance;
        }

    @Override
        public UtenteRegistrato findById (int id) {

        ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT * FROM utente registrato WHERE idutente=" + id);

        if (risultato.size() == 0) return null;

        UtenteRegistrato u = new UtenteRegistrato();

        String[] riga = risultato.get(0);

        u.setIdUtenteRegistrato(Integer.parseInt(riga[0]));
        u.setNome(riga[1]);
        u.setCognome(riga[2]);
        u.setEmail(riga[3]);
        u.setNumeroTelefono(Integer.parseInt(riga[4]));
        u.setUsername(riga[5]);
        u.setPassword(riga[6].getBytes());
        u.setRuolo(Integer.parseInt(riga[7]));

        return u;
    }


        @Override
        public ArrayList<UtenteRegistrato> findAll() {

            //relazione con la DBConnection
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT * FROM utente registrato");

            //traduzione
            ArrayList<UtenteRegistrato> listaUtentiregistrati = new ArrayList<UtenteRegistrato>();

            //riempo l'ArrayList

            Iterator<String[]> i = risultato.iterator();

            while (i.hasNext()) {
                String[] riga = i.next();
                UtenteRegistrato u = new UtenteRegistrato();
                u.setIdUtenteRegistrato(Integer.parseInt(riga[0]));
                u.setNome(riga[1]);
                u.setCognome(riga[2]);
                u.setEmail(riga[3]);
                u.setNumeroTelefono(Integer.parseInt(riga[4]));
                u.setUsername(riga[5]);
                u.setPassword(riga[6].getBytes());
                u.setRuolo(Integer.parseInt(riga[7]));

                listaUtentiregistrati.add(u);/*definiamo l'utente definito prima in coda alla listaUtentiRegistrati*/
                //  }
            }

            return listaUtentiregistrati;
        }


    public UtenteRegistrato findUserByUsernameAndPassword(String username, byte[] password) {

            String query = "SELECT * FROM utente registrato WHERE " +
                    "username = '" + username + "' AND " +
                    "password = '" + new String(password) + "'";

        ArrayList<String[]> ris = Dbconnection.getInstance().eseguiQuery(query);
        if (ris.size() == 0) return null;
        //esiste un utente registrato
        UtenteRegistrato u=new UtenteRegistrato();
        String[] persona = ris.get(0);
        u.setIdUtenteRegistrato(Integer.parseInt(persona[0]));
        u.setNome(persona[1]);
        u.setCognome(persona[2]);
        u.setEmail(persona[3]);
        u.setNumeroTelefono(Integer.parseInt(persona[4]));
        u.setUsername(persona[5]);
        u.setPassword(persona[6].getBytes());
        u.setRuolo(Integer.parseInt(persona[7]));

        return u;

    }

    public UtenteRegistrato aggiunginuovoutenteregistrato(String username, byte[] password, String email, int numerotelefono, String nome,
                                       String cognome, String ente_emittente, String esercente, String data_scadenza,
                                       String numero_carta, String via, String numero_civico, String nazione,
                                       String citta, String provincia, String CAP, int id_utenteregistrato) {



        String query1 = "INSERT INTO utente registrato(nome,cognome,email,numero telefono, username,password,ruolo) values ('" + nome + "','" + cognome + "','" + email + "','" + numerotelefono + "','" + username + "','" + new String(password) + "', '"+3+"');";

        Dbconnection.getInstance().eseguiAggiornamento(query1);

        String query_idutenteregistrato = "SELECT * FROM utente registrato WHERE username ='"+username+"'";
        ArrayList<String[]> ris = Dbconnection.getInstance().eseguiQuery(query_idutenteregistrato);

        String[] user = ris.get(0);
        int idNuovoUtenteRegistrato = Integer.parseInt(user[0]);

        String query2 = "INSERT INTO indirizzo(via,numero_civico, nazione, citta, provincia, CAP, utenteregistrato_idutenteregistrato) values('" + via + "','" + numero_civico + "','" + nazione + "','" + citta + "','" + provincia + "','"+ CAP + "','"+ idNuovoUtenteRegistrato+"');";
        Dbconnection.getInstance().eseguiAggiornamento(query2);

        String query3 = "INSERT INTO metodo di pagamento(ente_emittente,esercente,data_scadenza, numero_carta,) values('" + ente_emittente + "','" + esercente + "','" + data_scadenza + numero_carta + "','"+idNuovoUtenteRegistrato+"');";
        Dbconnection.getInstance().eseguiAggiornamento(query3);


        String query4="INSERT INTO registrazione(nome,cognome,email,numero telefono,username,password,conferma) values('"+nome+"','"+cognome+"','"+email+"','"+ numerotelefono+ "','"+ username+"','"+1+"','"+idNuovoUtenteRegistrato+"');";
        Dbconnection.getInstance().eseguiAggiornamento(query4);




        UtenteRegistrato u = new UtenteRegistrato();

        u.setNome(nome);
        u.setCognome(cognome);
        u.setEmail(email);
        u.setNumeroTelefono(numerotelefono);
        u.setUsername(username);
        u.setPassword(password);
        u.setRuolo(0);


        return u;
    }

    public void cancellautenteregistrato(int UtenteRegistrato_idUtenteRegistrato){

        String query1="DELETE FROM utente registrato WHERE idUtenteRegistrato='"+UtenteRegistrato_idUtenteRegistrato+"'";
        Dbconnection.getInstance().eseguiAggiornamento(query1);
        String query2="DELETE FROM indirizzo WHERE UtenteRegistrato_idUtenteRegistrato='"+UtenteRegistrato_idUtenteRegistrato+"'";
        Dbconnection.getInstance().eseguiAggiornamento(query2);
        String query3= "DELETE FROM metodo_di_pagamento WHERE UtenteRegistrato_idUtenteRegistrato='"+UtenteRegistrato_idUtenteRegistrato+"'";
        Dbconnection.getInstance().eseguiAggiornamento(query3);
        String query4="DELETE FROM registrazione WHERE UtenteRegistrato_idUtenteRegistrato='"+UtenteRegistrato_idUtenteRegistrato+"'";
        Dbconnection.getInstance().eseguiAggiornamento(query4);
    }
}