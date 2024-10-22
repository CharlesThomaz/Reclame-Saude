package br.com.devset.reclamesaude.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOSPITAL_SEQ")
    @SequenceGenerator(name = "HOSPITAL_SEQ", sequenceName = "HOSPITAL_SEQ", allocationSize = 1)
    private Long id; // ID do hospital

    private String nome; // Nome do hospital

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Reclamacao> reclamacoes; // Lista de reclamações associadas ao hospital

    // Construtor padrão
    public Hospital() {}

    // Construtor com parâmetros
    public Hospital( String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Reclamacao> getReclamacoes() {
        return reclamacoes;
    }

    public void setReclamacoes(List<Reclamacao> reclamacoes) {
        this.reclamacoes = reclamacoes;
    }
    @JsonProperty("quantidadeDeReclamacoes")
    public int getQuantidadeDeReclamacoes() {
        return (reclamacoes != null) ? reclamacoes.size() : 0;
    }


    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", quantidadeDeReclamacoes=" + getQuantidadeDeReclamacoes() +
                '}'; // Mostra a quantidade de reclamações
    }
}
