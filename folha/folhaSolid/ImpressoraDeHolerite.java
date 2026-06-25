package folhaSolid;

public class ImpressoraDeHolerite {

    public void imprimir(Holerite holerite) {
        System.out.println("======== FOLHA DE PAGAMENTO ========");
        System.out.println("Funcionário: " + holerite.getNomeFuncionario());
        System.out.println();

        System.out.println("PROVENTOS");
        for (ItemHolerite item : holerite.getItens()) {
            if (item.isProvento()) {
                System.out.printf("%-20s R$ %8.2f%n", item.getDescricao(), item.getValor());
            }
        }

        System.out.println();
        System.out.println("DESCONTOS");
        for (ItemHolerite item : holerite.getItens()) {
            if (!item.isProvento()) {
                System.out.printf("%-20s R$ %8.2f%n", item.getDescricao(), item.getValor());
            }
        }

        System.out.println("------------------------------------");
        System.out.printf("SALÁRIO FINAL       R$ %8.2f%n", holerite.calcularTotal());
        System.out.println("====================================\n");
    }
}
