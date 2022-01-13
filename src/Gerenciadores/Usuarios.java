package Gerenciadores;

import Entidades.Usuario;

import java.util.ArrayList;

public class Usuarios {
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();


    public void createUsuario(String nome,
                                 float altura,      // Em metros
                                 float peso,        // Em kg
                                 float gordura ) {  // Em %
        listaUsuarios.add(new Usuario(nome, altura, peso, gordura));
    }

    public Usuario getUsuario(String nome) {
        for (Usuario user : listaUsuarios) {
            if (user.getNome().equals(nome)) {
                return user;
            }
        }
        return null;
    }

    public Usuario getUsuario(int index) {
        if (index < listaUsuarios.size()) {
            return listaUsuarios.get(index);
        }
        return null;
    }

    public int getQuantUsuarios() {
        return listaUsuarios.size();
    }


    public void removerUsuario(int index) {
        if (index < listaUsuarios.size()) {
            listaUsuarios.remove(index);
        }
    }

}
