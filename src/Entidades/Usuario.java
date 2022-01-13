package Entidades;

import Atividades.Atividade;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private float altura; // Em M
    private float peso;   // Em kg
    private float gordura;// Em %
    private ArrayList<Atividade> listaAtividades = new ArrayList<>();

    public Usuario(String nome, float altura, float peso, float gordura) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.gordura = gordura;
    }

    public float getIMC() {
        return peso / (altura * altura);
    }

    public String getStatus() {
        float IMC = peso / (altura * altura);
        if (IMC < 17) {
            return ( IMC + " - Muito abaixo do peso");
        } else if (IMC < 18.50) {
            return ( IMC + " - Abaixo do peso");
        } else if (IMC < 25) {
            return ( IMC + " - Peso normal");
        } else if (IMC < 30) {
            return ( IMC + " - Obesidade");
        } else if (IMC < 40) {
            return ( IMC + " - Obesidade Severa");
        }
        return ( IMC + " - Obesidade Mórbida");
    }

    public String getNome() {
        return nome;
    }


    public float getAltura() {
        return altura;
    }


    public float getPeso() {
        return peso;
    }

    public void addAtividade(Atividade ativ) {
        listaAtividades.add(ativ);
    }

    public Atividade getAtividade(int index) {
        if (index < listaAtividades.size()) {
            return listaAtividades.get(index);
        }
        return null;
    }

    public ArrayList<Atividade> getAtividades(int[] data) {
        ArrayList<Atividade> atividadesEncontradas = new ArrayList<>();
        for (Atividade ativ : listaAtividades) {
            if (ativ.getData()[0] == data[0] && ativ.getData()[1] == data[1] && ativ.getData()[2] == data[2]) {
                atividadesEncontradas.add(ativ);
            }
        }
        return atividadesEncontradas;
    }

    public int getQuantAtividades() {
        return listaAtividades.size();
    }

    @Override
    public String toString() {
        return nome + ", Atividades: " + listaAtividades.size();
    }
}
