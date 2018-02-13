package Shop.model;

public class UtenteRegistrato {

        private int idUtenteRegistrato;
        private String nome;
        private String cognome;
        private String email;
        private int numerotelefono;
        private String username;
        private byte[] password;
        public int ruolo;


        public int getIdUtenteRegistrato() {
            return idUtenteRegistrato;
        }

        public void setIdUtenteRegistrato(int idUtenteRegistrato) {
            this.idUtenteRegistrato = idUtenteRegistrato;
        }

        public String getNome() { return nome; }

        public void setNome(String nome) { this.nome = nome; }

        public String getCognome() { return cognome; }

        public void setCognome(String cognome) { this.cognome = cognome; }

        public String getEmail() { return email; }

        public void setEmail(String email) { this.email = email; }

        public int getNumeroTelefono() { return numerotelefono; }

        public void setNumeroTelefono(int numerotelefono) { this.numerotelefono = numerotelefono; }

        public String getUsername() {
        return username;
    }

        public void setUsername(String username) { this.username = username;}

        public byte[] getPassword() {
        return password;
    }

        public void setPassword(byte[] password) {
        this.password = password;
    }

        public int getRuolo() {
        return ruolo;
    }

        public void setRuolo(int ruolo) {
        this.ruolo = ruolo;
    }

}