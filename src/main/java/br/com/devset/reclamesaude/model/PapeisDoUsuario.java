package br.com.devset.reclamesaude.model;

public enum PapeisDoUsuario {
    ADMIN("admin"),
    USER("user");

    private final String papel;

    PapeisDoUsuario(String papel) {
        this.papel = papel;
    }

    public String getPapel() {
        return papel;
    }

    // Método para obter o papel padrão
    public static PapeisDoUsuario getPapelDefault() {
        return USER; // Define USER como o papel padrão
    }
}
