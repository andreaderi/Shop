package Shop.model;

public class Registrazione {

    private int idRegistrazione;
    private String nome;
    private String cognome;
    private String email;
    private String username;
    private byte[] password;
    private int conferma;
    private String messaggiodiconferma;
    private int utenteregistrato_idutenteregistrato;


    public int getIdRegistrazione() { return idRegistrazione; }

    public void setIdRegistrazione(int idRegistrazione) { this.idRegistrazione = idRegistrazione; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }

    public void setCognome(String cognome) { this.cognome = cognome; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public int getConferma() { return conferma; }

    public void setConferma(int conferma) { this.conferma = conferma; }

    public String getMessaggiodiconferma() { return messaggiodiconferma; }

    public void setMessaggiodiconferma(String messaggiodiconferma) { this.messaggiodiconferma = messaggiodiconferma; }

    public int getUtenteregistrato_idutenteregistrato() { return utenteregistrato_idutenteregistrato; }

    public void setUtenteregistrato_idutenteregistrato(int utenteregistrato_idutenteregistrato) { this.utenteregistrato_idutenteregistrato = utenteregistrato_idutenteregistrato; }
}
