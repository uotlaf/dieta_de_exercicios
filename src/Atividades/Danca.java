package Atividades;

public class Danca extends Atividade{
    private float gastoCaloricoEspecifico = 3.5f; // Por minutos. Específico do programa


    public Danca(String nome, int[] data, float tempo) {
        super(nome, data);
        super.setTempo(tempo); // Tempo em horas
        super.setGastoCaloricoPadrao(gastoCaloricoEspecifico);
    }

    @Override
    public String toString() {
        return "Dança " + nome + ", feito por " + tempo + " horas. Foram gastos " + gastoCaloricoAprox + " calorias";
    }

}