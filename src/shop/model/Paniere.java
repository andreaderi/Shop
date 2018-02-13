package Shop.model;

import java.util.ArrayList;

public class Paniere {

    private int idPaniere;
    private String nome;
    private String data; //di creazione
    private String orario;
    private ArrayList<Prodotto> partipaniere;
    private ArrayList<String> nomeprodottipaniere;
    private int utenteregistrato_idutenteregistrato;


    public int getIdPaniere() {
        return idPaniere;
    }

    public void setIdPaniere(int idPaniere) {
        this.idPaniere = idPaniere;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOrario() {
        return orario;
    }

    public void setOrario(String orario) {
        this.orario = orario;
    }

    public ArrayList<Prodotto> getPartipaniere() {
        return partipaniere;
    }

    public void setPartipaniere(ArrayList<Prodotto> partipaniere) {
        this.partipaniere = partipaniere;
    }

    public ArrayList<String> getNomeprodottipaniere() {
        return nomeprodottipaniere;
    }

    public void setNomeprodottipaniere(ArrayList<String> nomeprodottipaniere) {
        this.nomeprodottipaniere = nomeprodottipaniere;
    }

    public int getUtenteregistrato_idutenteregistrato() {
        return utenteregistrato_idutenteregistrato;
    }

    public void setUtenteregistrato_idutenteregistrato(int utenteregistrato_idutenteregistrato) {
        this.utenteregistrato_idutenteregistrato = utenteregistrato_idutenteregistrato;
    }

}