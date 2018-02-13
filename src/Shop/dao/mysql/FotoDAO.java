package Shop.dao.mysql;

import Shop.dbinterface.Dbconnection;

import java.util.ArrayList;

public class FotoDAO {

        private static FotoDAO instance;

        public static FotoDAO getInstance() {
            if (instance == null)
                instance = new FotoDAO();
            return instance;
        }

        public String linkfoto(int id_prodotto){

            String query1 = "SELECT link FROM foto WHERE prodotto_idprodotto='"+id_prodotto+"';";

            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery(query1);

            String[] riga = risultato.get(0);

            String link = riga[0];

            return (link);
        }

        public void aggiungolinkfoto(int id_prodotto,String link){

            String query1 ="INSERT INTO foto (link,prodotto_idprodotto)values('"+link+"','"+id_prodotto+"') ;";

            Dbconnection.getInstance().eseguiAggiornamento(query1);
        }

    }
