public class ItemResultado {

    private String descricao;
    private double valor;
    private boolean provento;

    public ItemResultado(String descricao, double valor, boolean provento) {
        this.descricao = descricao;
        this.valor = valor;
        this.provento = provento;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public boolean isProvento() {
        return provento;
    }
}