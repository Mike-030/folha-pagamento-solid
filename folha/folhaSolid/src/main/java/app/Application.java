package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import domain.Regras;
import usecase.GerarFolhaUseCase;

@SpringBootApplication(scanBasePackages = {"app", "domain", "adapter", "usecase"})
@EntityScan(basePackages = "domain")
@EnableJpaRepositories(basePackages = "domain")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public GerarFolhaUseCase gerarFolhaUseCase() {
        return new GerarFolhaUseCase(Arrays.asList(
                new Regras.RegraHoraExtra(),
                new Regras.RegraBonus(500),
                new Regras.RegraINSS(),
                new Regras.RegraValeTransporte(),
                new Regras.RegraPlanoDeSaude(150),
                new Regras.RegraAdicionalNoturno()
        ));
    }
}
