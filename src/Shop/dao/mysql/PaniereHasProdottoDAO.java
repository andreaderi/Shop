package Shop.dao.mysql;

import Shop.dao.interfaces.IBaseDAO;
import Shop.dbinterface.Dbconnection;
import Shop.model.PaniereHasProdotto;

import java.util.ArrayList;

public class PaniereHasProdottoDAO implements IBaseDAO<PaniereHasProdotto> { //analizzo la costituzione del paniere

    private static PaniereHasProdottoDAO instance;

    public static PaniereHasProdottoDAO getInstance() {
        if (instance == null)
            instance = new PaniereHasProdottoDAO();
        return instance;
    }


    public void inserisciunprodottonelpaniere(int id_paniere,int id_prodotto){
        String query1="INSERT INTO paniere_has_prodotto (paniere_idpaniere,prodotto_idprodotto) VALUES('"+id_paniere+"','"+id_prodotto+"')";
        Dbconnection.getInstance().eseguiAggiornamento(query1);
    }


    @Override
    public PaniereHasProdotto findById(int id) {
        return null;
    }

    @Override
    public ArrayList<PaniereHasProdotto> findAll() {
        return null;
    }
}