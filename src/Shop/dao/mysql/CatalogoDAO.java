package Shop.dao.mysql;

import Shop.dbinterface.Dbconnection;
import Shop.model.Catalogo;
import Shop.model.Prodotto;

import java.util.ArrayList;
import java.util.Iterator;

public class CatalogoDAO {

        private static CatalogoDAO instance;

        public static CatalogoDAO getInstance() {
            if (instance == null)
                instance = new CatalogoDAO();
            return instance;
        }

        public Catalogo CreazioneCatalogo(){
            Catalogo c=new Catalogo();


            ArrayList<Prodotto> ProdottiCatalogo = new ArrayList<Prodotto>();

            ArrayList<String[]> ris =  Dbconnection.getInstance().eseguiQuery("SELECT idprodotto, nome, descrizione testuale, prezzo, sconto, categoria, distributore, produttore,sezione FROM prodotto as p\n" +
                    "JOIN categoria AS c\n" +
                    "JOIN distributore AS d\n" +
                    "JOIN produttore AS prod\n" +
                    "JOIN sezione AS s\n" +
                    "WHERE p.categoria_idcategoria=c.idcategoria AND p.distributore_iddistributore=d.iddistributore \n" +
                    "AND p.produttore_idproduttore=prod.idproduttore AND p.sezione_idsezione=s.idsezione");

            if(ris.size() != 0) {
                Iterator<String[]> i = ris.iterator();
                while(i.hasNext()) {
                    String[] riga2 = i.next();
                    Prodotto p = new Prodotto();
                    p.setIdProdotto(Integer.parseInt(riga2[0]));
                    p.setNome(riga2[1]);
                    p.setDescrizionetestuale(riga2[2]);
                    p.setPrezzo(Float.parseFloat(riga2[3]));
                    p.setSconto(Float.parseFloat(riga2[4]));
                    p.setCategoria(riga2[5]);
                    p.setDistributore(riga2[6]);
                    p.setProduttore(riga2[7]);
                    p.setSezione(riga2[8]);

                    ProdottiCatalogo.add(p);
                }
            }

            c.setProdotticatalogo(ProdottiCatalogo);

            return c;

        }
    }

