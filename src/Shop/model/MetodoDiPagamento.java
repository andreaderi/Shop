package Shop.model;

public class MetodoDiPagamento {

        private int idMetodoDiPagamento;
        private String enteemittente;
        private String esercente;
        private String datadiscadenza;
        private String numero; //della carta

    public int getIdMetodoDiPagamento() {
        return idMetodoDiPagamento;
    }

    public void setIdMetodoDiPagamento(int idMetodoDiPagamento) {
        this.idMetodoDiPagamento = idMetodoDiPagamento;
    }

    public String getEnteemittente() {
        return enteemittente;
    }

    public void setEnteemittente(String enteemittente) {
        this.enteemittente = enteemittente;
    }

    public String getEsercente() {
        return esercente;
    }

    public void setEsercente(String esercente) {
        this.esercente = esercente;
    }

    public String getDatadiscadenza() {
        return datadiscadenza;
    }

    public void setDatadiscadenza(String datadiscadenza) {
        this.datadiscadenza = datadiscadenza;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
