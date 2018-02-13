package Shop.dao.mysql;

import Shop.dao.interfaces.IBaseDAO;
import Shop.model.ProdottoSelezionato;
import Shop.dbinterface.Dbconnection;

import java.util.ArrayList;
import java.util.Iterator;

public class ProdottoSelezionatoDAO implements IBaseDAO<ProdottoSelezionato> {

        private static ProdottoSelezionatoDAO instance;

        public static ProdottoSelezionatoDAO getInstance() {

            if (instance == null)
                instance = new ProdottoSelezionatoDAO();
            return instance;
        }


        public ProdottoSelezionato findById(int id) {

            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT * FROM prodotto selezionato WHERE  idprodottoselezionato=" +id);

            if(risultato.size()==0)
                return null;


            ProdottoSelezionato ps = new ProdottoSelezionato();

            String[] riga = risultato.get(0);

            ps.setIdProdottoSelezionato(Integer.parseInt(riga[0]));
            ps.setNome(riga[1]);
            ps.setPrezzo(Float.parseFloat(riga[2]));
            ps.setSconto(Float.parseFloat(riga[3]));

            return ps;

        }


        public ArrayList<ProdottoSelezionato> findAll() {

            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT * FROM prodotto selezionato");

            ArrayList<ProdottoSelezionato> listaProdotti = new ArrayList<ProdottoSelezionato>();

            Iterator<String[]> i = risultato.iterator();

            while(i.hasNext()){     //hasNext--> finchè c'è un altro elemento dammelo

                String[] riga = i.next();       //.next--> scorre la lista
                ProdottoSelezionato ps = new ProdottoSelezionato();

                ps.setIdProdottoSelezionato(Integer.parseInt(riga[0]));
                ps.setNome(riga[1]);
                ps.setPrezzo(Float.parseFloat(riga[2]));
                ps.setSconto(Float.parseFloat(riga[3]));

                listaProdotti.add(ps);
            }

            return listaProdotti;
        }


        public ProdottoSelezionato aggiungounprodotto(String nome,String prezzo,String sconto,int idUtenteRegistrato,String idProdotto)
        {
            String query = "INSERT INTO prodotto selezionato (nome ,prezzo,sconto,prodotto_idprodotto,utenteregistrato_idutenteregistrato) values('"+nome+"','"+prezzo+"','"+sconto+"','"+idProdotto+"','"+idUtenteRegistrato+"');";

            Dbconnection.getInstance().eseguiAggiornamento(query);

            ProdottoSelezionato ps = new ProdottoSelezionato();

            ps.setNome(nome);
            ps.setPrezzo(Float.parseFloat(prezzo));
            ps.setSconto(Float.parseFloat(sconto));

            return ps;

        }

        public ArrayList<ProdottoSelezionato> findallbyidutenteregistrato(int id_utenteregistrato){
            String query1="SELECT* FROM prodotto selezionato where utenteregistrato_idutenteregistrato='"+id_utenteregistrato+"'";
            ArrayList<String[]> risultato=Dbconnection.getInstance().eseguiQuery(query1);
            ArrayList<ProdottoSelezionato> listaProdotti = new ArrayList<ProdottoSelezionato>();

            Iterator<String[]> i = risultato.iterator();

            while(i.hasNext()){

                String[] riga = i.next();
                ProdottoSelezionato ps = new ProdottoSelezionato();

                ps.setIdProdottoSelezionato(Integer.parseInt(riga[0]));
                ps.setNome(riga[1]);
                ps.setPrezzo(Float.parseFloat(riga[2]));
                ps.setSconto(Float.parseFloat(riga[3]));


                listaProdotti.add(ps);
            }

            return listaProdotti;

        }


    public void eliminazioneprodotto(int idutenteregistrato, int idprodottoselezionato){
        String query1="DELETE FROM prodottoselzionato WHERE utente_idutente='"+idutenteregistrato+"'AND idprodottoselezionato='"+idprodottoselezionato+"'";
        Dbconnection.getInstance().eseguiAggiornamento(query1);
    }

        public int importototale(int id_utenteregistrato){
            String query1=("SELECT prezzo,sconto FROM prodotto selezionato WHERE utenteregistrato_idutenteregistrato='"+id_utenteregistrato+"'");

            ArrayList<String[]> prezzi=Dbconnection.getInstance().eseguiQuery(query1);



            Iterator<String[]> i = prezzi.iterator();
            int importo=0;

            while(i.hasNext()){

                String[] riga = i.next();
                float prezzo=Float.parseFloat(riga[0]);
                float sconto=Float.parseFloat(riga[1]);
                if(sconto==0) {
                    importo += prezzo;
                }else {
                    importo+=(prezzo*sconto)/100;

                }
            }
            return importo;
        }
}
