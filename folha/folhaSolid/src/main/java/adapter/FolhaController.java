package adapter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.Entities;
import domain.FuncionarioRepository;
import usecase.GerarFolhaUseCase;

import java.util.Optional;

@RestController
@RequestMapping("/api/folha")
public class FolhaController {

    private final FuncionarioRepository repository;
    private final GerarFolhaUseCase gerarFolhaUseCase;

    public FolhaController(FuncionarioRepository repository, GerarFolhaUseCase gerarFolhaUseCase) {
        this.repository = repository;
        this.gerarFolhaUseCase = gerarFolhaUseCase;
    }

    @GetMapping("/funcionarios")
    public Iterable<Entities.Funcionario> listarFuncionarios() {
        return repository.findAll();
    }

    @GetMapping("/holerite/{id}")
    public ResponseEntity<Entities.Holerite> gerarHolerite(@PathVariable Long id) {
        Optional<Entities.Funcionario> funcionario = repository.findById(id);
        
        if (funcionario.isPresent()) {
            Entities.Holerite holerite = gerarFolhaUseCase.executar(funcionario.get());
            return ResponseEntity.ok(holerite);
        }
        
        return ResponseEntity.notFound().build();
    }
}
