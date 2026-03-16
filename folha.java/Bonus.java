public class Bonus implements ItemFolha {

    private double valor;

    public Bonus(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return "Bônus";
    }

    public double calcular(Funcionario funcionario) {
        return valor;
    }

    public boolean isProvento() {
        return true;
    }
}