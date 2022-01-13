package Atividades;

public class Levantamento extends Atividade{
    private int gastoCaloricoEspecifico = 5; // Por minutos. Específico do programa


    public Levantamento(String nome, int[] data, float tempo) {
        super(nome, data);
        super.setTempo(tempo); // Tempo em horas
        super.setGastoCaloricoPadrao(gastoCaloricoEspecifico);
    }

    @Override
    public String toString() {
        return "Leventamento " + nome + ", feito por " + tempo + " horas. Foram gastos " + gastoCaloricoAprox + " calorias";
    }

}