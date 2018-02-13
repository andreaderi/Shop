package Shop.dao.mysql;

import Shop.dao.interfaces.IBaseDAO;
import Shop.dbinterface.Dbconnection;
import Shop.model.MetodoDiPagamento;

import java.util.ArrayList;
import java.util.Iterator;


public class MetodoDiPagamentoDAO implements IBaseDAO<MetodoDiPagamento> {

        private static MetodoDiPagamentoDAO instance;

        public static MetodoDiPagamentoDAO getInstance() {
            if (instance == null)
                instance = new MetodoDiPagamentoDAO();
            return instance;
        }


        public MetodoDiPagamento findById(int id) {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM metodo_di_pagamento WHERE idmetodo_di_pagamento=" + id);
            if (risultato.size() == 0) return null;
            MetodoDiPagamento mp = new MetodoDiPagamento();
            String[] riga = risultato.get(0);
            mp.setIdMetodoDiPagamento(Integer.parseInt(riga[0]));
            mp.setEnteemittente(riga[1]);
            mp.setEsercente(riga[2]);
            mp.setDatadiscadenza(riga[3]);
            mp.setNumero(riga[4]);

            return mp;
        }


        public ArrayList<MetodoDiPagamento> findAll() {
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery("SELECT* FROM metodo_di_pagamento");

            ArrayList<MetodoDiPagamento> listaMetodiDiPagamento = new ArrayList<MetodoDiPagamento>();

            Iterator<String[]> i = risultato.iterator();

            while (i.hasNext()) {
                String[] riga = i.next();
                MetodoDiPagamento mp = new MetodoDiPagamento();
                mp.setIdMetodoDiPagamento(Integer.parseInt(riga[0]));
                mp.setEnteemittente(riga[1]);
                mp.setEsercente(riga[2]);
                mp.setDatadiscadenza(riga[3]);
                mp.setNumero(riga[4]);

                listaMetodiDiPagamento.add(mp);

            }

            return listaMetodiDiPagamento;
        }



        public ArrayList<MetodoDiPagamento> findallbyidutenteregistrato(int id_utenteregistrato) {
            String query1 = ("SELECT * FROM metodo_di_pagamento WHERE utenteregistrato_idutenteregisrato='" + id_utenteregistrato + "'");
            ArrayList<String[]> risultato = Dbconnection.getInstance().eseguiQuery(query1);

            ArrayList<MetodoDiPagamento> listaMetodiDiPagamento = new ArrayList<MetodoDiPagamento>();
            Iterator<String[]> i = risultato.iterator();

            while (i.hasNext()) {
                String[] riga = i.next();
                MetodoDiPagamento mp = new MetodoDiPagamento();
                mp.setIdMetodoDiPagamento(Integer.parseInt(riga[0]));
                mp.setEnteemittente(riga[1]);
                mp.setEsercente(riga[2]);
                mp.setDatadiscadenza(riga[3]);
                mp.setNumero(riga[4]);

                listaMetodiDiPagamento.add(mp);

            }

            return listaMetodiDiPagamento;
        }


        public void inseriscinuovometododipagamento(String ente_emittente,String esercente,String data_scadenza, String numero_carta,int id_utenteregistrato){
            String query1="INSERT INTO metodo_di_pagamento(ente_emittente,esercente,data_scadenza,numero_carta,utenteregistrato_idutenteregistrato) values('"+ente_emittente+"','"+esercente+"','"+data_scadenza+"','"+numero_carta+"','"+id_utenteregistrato+"')";
            Dbconnection.getInstance().eseguiAggiornamento(query1);
        }

    }