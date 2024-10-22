package br.com.devset.reclamesaude.testes;

import br.com.devset.reclamesaude.model.Hospital;
import br.com.devset.reclamesaude.model.Reclamacao;
import br.com.devset.reclamesaude.model.Usuario;

public class ReclameApp {
    public static void main(String[] args) {


        Hospital hospital = new Hospital("Hospital 1");
        Usuario usuario = new Usuario("ZE ","ze@email","senha12345");
        Reclamacao relamacao = new Reclamacao(hospital,usuario,"Descrição da reclamação");

        usuario.setEmail("zeas@email");
        System.out.println(usuario.toString());
        System.out.println(relamacao.toString());
    }
}
