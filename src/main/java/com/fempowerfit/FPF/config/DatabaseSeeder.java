package com.fempowerfit.FPF.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fempowerfit.FPF.Model.Suplemento;
import com.fempowerfit.FPF.repository.SuplementoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
    
    @Autowired
    SuplementoRepository suplementoRepository;

    @Override
    public void run (String... args) throws Exception {
        suplementoRepository.saveAll(
            List.of(
                Suplemento.builder().id(1L).marca("Max Titanium").tipo("Creatina").quantidade(1).build(),
                Suplemento.builder().id(2L).marca("Intermédica").tipo("WheyProtein").quantidade(1).build(),
                Suplemento.builder().id(3L).marca("Vitafor").tipo("Pre-Treino").quantidade(1).build(),
                Suplemento.builder().id(4L).marca("BodyBuilders").tipo("Outro").quantidade(2).build()
            )
        );
    }
}
