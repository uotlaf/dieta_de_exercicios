package Atividades;

@SuppressWarnings("FieldMayBeFinal")
public class Corrida extends Atividade{
    private int gastoCaloricoEspecifico = 10; // Por minutos. Específico do programa


    public Corrida(String nome, int[] data, float tempo) {
        super(nome, data);
        super.setTempo(tempo); // Tempo em horas
        super.setGastoCaloricoPadrao(gastoCaloricoEspecifico);
    }

    @Override
    public String toString() {
        return "Corrida " + nome + ", feito por " + tempo + " horas. Foram gastos " + gastoCaloricoAprox + " calorias";
    }

}
