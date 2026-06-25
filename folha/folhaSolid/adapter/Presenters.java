package adapter;

import domain.Entities;

public class Presenters {

    public interface HoleritePresenter {
        void apresentar(Entities.Holerite holerite);
    }

    public static class ConsoleHoleritePresenter implements HoleritePresenter {
        @Override
        public void apresentar(Entities.Holerite holerite) {
            System.out.println("======== FOLHA DE PAGAMENTO ========");
            System.out.println("Funcionário: " + holerite.getNomeFuncionario());
            System.out.println("\nPROVENTOS");
            for (Entities.ItemHolerite item : holerite.getItens()) {
                if (item.isProvento()) {
                    System.out.printf("%-20s R$ %8.2f\n", item.getDescricao(), item.getValor());
                }
            }

            System.out.println("\nDESCONTOS");
            for (Entities.ItemHolerite item : holerite.getItens()) {
                if (!item.isProvento()) {
                    System.out.printf("%-20s R$ %8.2f\n", item.getDescricao(), item.getValor());
                }
            }
            System.out.println("------------------------------------");
            System.out.printf("SALÁRIO FINAL       R$ %8.2f\n", holerite.calcularTotal());
            System.out.println("====================================\n");
        }
    }
}
