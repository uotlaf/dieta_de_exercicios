package Atividades;

public class Malhacao extends Atividade{
    private int gastoCaloricoEspecifico = 5; // Por minutos. Específico do programa


    public Malhacao(String nome, int[] data, float tempo) {
        super(nome, data);
        super.setTempo(tempo); // Tempo em horas
        super.setGastoCaloricoPadrao(gastoCaloricoEspecifico);
    }

    @Override
    public String toString() {
        return "Malhação " + nome + ", feito por " + tempo + " horas. Foram gastos " + gastoCaloricoAprox + " calorias";
    }

}