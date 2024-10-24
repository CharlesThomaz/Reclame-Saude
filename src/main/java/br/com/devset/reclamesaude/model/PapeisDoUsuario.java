package br.com.devset.reclamesaude.model;

public enum PapeisDoUsuario {
    ADMIN("admin"),
    USER("user");

    private String papeis;

    private PapeisDoUsuario(String papeis) {
        this.papeis = papeis;
    }
    public String getPapeis() {
        return papeis;
    }
}
