package Shop.dao.interfaces;

import java.util.ArrayList;

public interface IBaseDAO<T> {
        //findById
        T findById(int id);

        //findall
        ArrayList<T> findAll();

}


