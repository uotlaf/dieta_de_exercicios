package Atividades;

public class Caminhada extends Atividade{
    private float gastoCaloricoEspecifico = 5.5F; // Por minutos. Específico do programa


    public Caminhada(String nome, int[] data, float tempo) {
        super(nome, data);
        super.setTempo(tempo); // Tempo em horas
        super.setGastoCaloricoPadrao(gastoCaloricoEspecifico);
    }

    @Override
    public String toString() {
        return "Caminhada " + nome + ", feito por " + tempo + " horas. Foram gastos " + gastoCaloricoAprox + " calorias";
    }
}