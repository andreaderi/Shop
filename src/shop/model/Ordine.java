package Shop.model;

public class Ordine {

        private int idOrdine;
        private String data; //in cui è stato effettuato l'ordine
        private int conferma; //conferma dell'ordine
        private String codice;
        private int stato; //dell'ordine
        private float importototale;
        public String messaggiodiconferma;
        public String messaggiodistato;

        public int getIdOrdine() {
        return idOrdine;
    }

        public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

        public String getData() {
        return data;
    }

        public void setData(String data) {
        this.data = data;
    }

        public int getConferma() {
        return conferma;
    }

        public void setConferma(int conferma) {
        this.conferma = conferma;
    }

        public String getCodice() {
        return codice;
    }

        public void setCodice(String codice) {
        this.codice = codice;
    }

        public int getStato() {
        return stato;
    }

        public void setStato(int stato) {
        this.stato = stato;
    }

        public float getImportototale() {
            return importototale;
        }

        public void setImportototale(float importototale) {
            this.importototale = importototale;
        }

        public String getMessaggiodiconferma() {
            return messaggiodiconferma;
        }

        public void setMessaggiodiconferma(String messaggiodiconferma) {
            this.messaggiodiconferma = messaggiodiconferma;
        }

        public String getMessaggiodistato() {
            return messaggiodistato;
        }

        public void setMessaggiodistato(String messaggiodistato) {
            this.messaggiodistato = messaggiodistato;
        }
    }
