package app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import domain.Entities;
import domain.FuncionarioRepository;
import usecase.GerarFolhaUseCase;
import adapter.Presenters;

@Component
public class AppRunner implements CommandLineRunner {

    private final FuncionarioRepository repository;
    private final GerarFolhaUseCase gerarFolhaUseCase;

    public AppRunner(FuncionarioRepository repository, GerarFolhaUseCase gerarFolhaUseCase) {
        this.repository = repository;
        this.gerarFolhaUseCase = gerarFolhaUseCase;
    }

    @Override
    public void run(String... args) throws Exception {
        
        System.out.println(">>> [1/3] Regras e Casos de Uso instanciados pelo Spring!");

        System.out.println(">>> [2/3] Salvando funcionários no Banco de Dados H2...");
        Entities.Funcionario clt = new Entities.FuncionarioCLT("João Silva (CLT)", 3000, 10, true);
        Entities.Funcionario pj = new Entities.FuncionarioPJ("Empresa do Marcos (PJ)", 8000);
        
        repository.save(clt);
        repository.save(pj);

        System.out.println(">>> [3/3] Lendo funcionários do Banco e gerando Holerites...\n");
        Iterable<Entities.Funcionario> funcionariosDoBanco = repository.findAll();

        Presenters.HoleritePresenter presenter = new Presenters.ConsoleHoleritePresenter();

        for (Entities.Funcionario func : funcionariosDoBanco) {
            Entities.Holerite holerite = gerarFolhaUseCase.executar(func);
            presenter.apresentar(holerite);
        }
        
        System.out.println(">>> FIM DA EXECUCAO <<<");
    }
}
