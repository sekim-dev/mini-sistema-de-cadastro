package br.me.desafio3.minisistemadecadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MiniSistemaDeCadastroApplication{


    public static void main(String[] args) {
        SpringApplication.run(MiniSistemaDeCadastroApplication.class, args);
    }


}

