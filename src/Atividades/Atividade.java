package Atividades;

public class Atividade {
    protected String nome; // Identificador personalizado
    protected float tempo; // Tempo feito por dia, em minutos
    protected int[] data = new int[3]; // (Dia, mes, ano)
    protected float gastoCaloricoAprox;
    protected float gastoCaloricoPadrao;


    public Atividade(String nome, int[] data) {
        this.nome = nome;
        // Previne data de ser um ponteiro pra data geral do programa
        this.data[0] = data[0];
        this.data[1] = data[1];
        this.data[2] = data[2];
    }

    public void setGastoCaloricoPadrao(float gasto) {
        this.gastoCaloricoPadrao = gasto;
    }


    public int[] getData() {
        return data;
    }

    public String getNome() {
        return nome;
    }


    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public float getGastoCaloricoAprox() {
        return gastoCaloricoAprox;
    }

    public void updateGastoCaloricoAprox() { // tempo em horas
        gastoCaloricoAprox = gastoCaloricoPadrao * tempo;
    }

}
