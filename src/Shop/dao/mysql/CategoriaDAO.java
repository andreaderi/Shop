package Shop.dao.mysql;

import Shop.dao.interfaces.IBaseDAO;
import Shop.dbinterface.Dbconnection;
import Shop.model.Categoria;
import Shop.model.Prodotto;

import java.util.ArrayList;
import java.util.Iterator;


    public class CategoriaDAO implements IBaseDAO<Categoria> {

        private static CategoriaDAO instance;

        public static CategoriaDAO getInstance() {
            if (instance == null)
                instance = new CategoriaDAO();
            return instance;
        }


        public Categoria findById(int id) {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM categoria WHERE idcategoria=" + id);
            if (risultato.size() == 0) return null;
            Categoria c = new Categoria();
            String[] riga = risultato.get(0);
            c.setIdCategoria(Integer.parseInt(riga[0]));
            c.setNome(riga[1]);

            return c;
        }


        public ArrayList<Categoria> findAll() {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM categoria");

            ArrayList<Categoria> listaCategorie = new ArrayList<Categoria>();

            Iterator<String[]> i = risultato.iterator();

            while (i.hasNext()) {
                String[] riga = i.next();
                Categoria c = new Categoria();
                c.setIdCategoria(Integer.parseInt(riga[0]));
                c.setNome(riga[1]);

                listaCategorie.add(c);
            }

            return listaCategorie;
        }

        public ArrayList<Prodotto> ricerca(String nome){ //ricerco i prodotti dal nome della categoria selezionata
            String query1= "SELECT idcategoria FROM categoria WHERE nome='"+nome+"'";
            ArrayList<String[]> risultato=Dbconnection.getInstance().eseguiQuery(query1);
            String[] riga=risultato.get(0);
            int idcategoria=Integer.parseInt(riga[0]);

            String query2="SELECT * FROM prodotto WHERE categoria_idcategoria='"+idcategoria+"'";
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


