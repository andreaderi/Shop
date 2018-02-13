package Shop.model;

public class Prodotto {

        private int idProdotto;
        private String nome;
        private String descrizionetestuale;
        private float prezzo;
        private float sconto;
        private String categoria;
        private String distributore;
        private String produttore;
        private String sezione;

        public int getIdProdotto() { return idProdotto; }

        public void setIdProdotto(int idProdotto) { this.idProdotto = idProdotto; }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescrizionetestuale() {
            return descrizionetestuale;
        }

        public void setDescrizionetestuale(String descrizionetestuale) {
            this.descrizionetestuale = descrizionetestuale;
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

        public String getCategoria() {
        return categoria;
    }

        public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

        public String getDistributore() {
            return distributore;
        }

        public void setDistributore(String distributore) {
            this.distributore = distributore;
        }

        public String getProduttore() {
            return produttore;
        }

        public void setProduttore(String nome_produttore) {
            this.produttore = produttore;
        }

        public String getSezione() {
            return sezione;
        }

        public void setSezione(String sezione) {
            this.sezione = sezione;
        }
    }
