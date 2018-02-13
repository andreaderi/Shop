package Shop.dao.mysql;

import Shop.dao.interfaces.IBaseDAO;
import Shop.dbinterface.Dbconnection;
import Shop.model.ProdottoHasProdotto;

import java.util.ArrayList;
import java.util.Iterator;

    public class ProdottoHasProdottoDAO  implements IBaseDAO<ProdottoHasProdotto> { //sto analizzando i prodotti composti

        private static ProdottoHasProdottoDAO instance;

        public static ProdottoHasProdottoDAO getInstance() {
            if (instance == null)
                instance = new ProdottoHasProdottoDAO();
            return instance;
        }


        public ProdottoHasProdotto findById(int id) {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM prodottohasprodotto WHERE idprodottohasprodotto=" + id);
            if (risultato.size() == 0) return null;
            ProdottoHasProdotto php = new ProdottoHasProdotto();
            String[] riga = risultato.get(0);
            php.setIdProdottoHasProdotto(Integer.parseInt(riga[0]));
            php.setNome(riga[1]);

            return php;
        }


        public ArrayList<ProdottoHasProdotto> findAll() {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM prodotto_composto");

            ArrayList<ProdottoHasProdotto> listaProdottiHadProdotti= new ArrayList<ProdottoHasProdotto>();

            Iterator<String[]> i = risultato.iterator();

            while (i.hasNext()) {
                String[] riga = i.next();
                ProdottoHasProdotto php = new ProdottoHasProdotto();
                php.setIdProdottoHasProdotto(Integer.parseInt(riga[0]));
                php.setNome(riga[1]);

                listaProdottiHadProdotti.add(php);

            }

            return listaProdottiHadProdotti;
        }
    }
