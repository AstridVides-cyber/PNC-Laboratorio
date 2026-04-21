package com.example.laboratorio_1;

import com.example.laboratorio_1.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Laboratorio1Application {

    public static void main(String[] args) {
        SpringApplication.run(Laboratorio1Application.class, args);
    }

    @Bean
    public CommandLineRunner run(ProductService productService) {

        return args -> {

            productService.getProduct().forEach(p ->
                    System.out.println(
                            "[HYRULE-DB] Nombre: " + p.getNombre()
                                    + " | Categoría: " + p.getCategoria()
                                    + " | Precio: " + p.getPrecio() + " Rupias"
                    )
            );
        };
    }
}
