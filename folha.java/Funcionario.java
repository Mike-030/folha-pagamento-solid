public class Funcionario {

    private String nome;
    private double salarioBase;
    private int horasExtras;

    public Funcionario(String nome, double salarioBase, int horasExtras) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.horasExtras = horasExtras;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public int getHorasExtras() {
        return horasExtras;
    }
}