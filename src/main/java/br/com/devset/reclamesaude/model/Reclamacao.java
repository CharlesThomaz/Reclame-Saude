package br.com.devset.reclamesaude.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_reclamacao")
public class Reclamacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID da reclamação

    @ManyToOne // Relacionamento com Hospital
    @JoinColumn(name = "hospital_id", nullable = false) // Chave estrangeira
    private Hospital hospital;

    @ManyToOne // Relacionamento com Usuario
    @JoinColumn(name = "usuario_id", nullable = false) // Chave estrangeira
    private Usuario usuario;

    private String descricao; // Descrição da reclamação

    // Construtores, getters e setters...
    public Reclamacao() {
    }


    public Reclamacao(Hospital hospital, Usuario usuario, String descricao) {
        this.hospital = hospital;
        this.usuario = usuario;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Reclamacao{" +
                "id=" + id +
                ", hospital=" + hospital +
                ", usuario=" + usuario +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
