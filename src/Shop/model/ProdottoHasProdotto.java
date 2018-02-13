package Shop.model;

import java.util.ArrayList;

public class ProdottoHasProdotto { //classe del prodotto composto

        private int idProdottoHasProdotto;
        private String nome; //del prodotto composto
        private ArrayList<Prodotto> partiprodottocomposto;

        public int getIdProdottoHasProdotto() {
        return idProdottoHasProdotto;
    }

        public void setIdProdottoHasProdotto(int idProdottoHasProdotto) { this.idProdottoHasProdotto = idProdottoHasProdotto; }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) { this.nome = nome; }

        public ArrayList<Prodotto> getpartiprodottocomposto() {
            return partiprodottocomposto;
        }

        public void setpartiprodottocomposto(ArrayList<Prodotto> partiprodottocomposto) {
            this.partiprodottocomposto = partiprodottocomposto; }
}
