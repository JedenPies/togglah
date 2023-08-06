package pl.patrykdobrowolski.togglah.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "pl.patrykdobrowolski.togglah")
public class TogglahApplication {

    public static void main(String[] args) {
        SpringApplication.run(TogglahApplication.class);
    }
}
