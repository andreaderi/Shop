package Shop.model;

public class ProdottoSelezionato {

        private int IdProdottoSelezionato;
        private String nome;
        private float prezzo;
        private float sconto;

        public int getIdProdottoSelezionato() {
            return IdProdottoSelezionato;
        }

        public void setIdProdottoSelezionato(int idProdottoSelezionato) {
            IdProdottoSelezionato = idProdottoSelezionato;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public float getPrezzo() {
            return prezzo;
        }

        public void setPrezzo(float prezzo) {
            this.prezzo = prezzo;
        }

        public float getSconto() {
            return sconto;
        }

        public void setSconto(float sconto) {
            this.sconto = sconto;
        }
    }
