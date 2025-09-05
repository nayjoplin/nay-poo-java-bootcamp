package br.com.nayrodrigues.dio.poo;

import br.com.nayrodrigues.dio.poo.dominio.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    private static final String BANNER =
        " ____              _                              ____ ______ _____ \n" +
        "|  _ \\            | |                            / __ \\|  ___|  __ \\\n" +
        "| |_) | ___   ___ | | ___   _ _ __   __ _  ___  | |  | | |_  | |  | |\n" +
        "|  _ < / _ \\ / _ \\| |/ / | | | '_ \\ / _` |/ _ \\ | |  | |  _| | |  | |\n" +
        "| |_) | (_) | (_) |   <| |_| | | | | (_| |  __/ | |__| | |   | |__| |\n" +
        "|____/ \\___/ \\___/|_|\\_\\\\__,_|_| |_|\\__, |\\___|  \\____/|_|   |_____/\n" +
        "                                     __/ |                           \n" +
        "                                    |___/        Bootcamp GTF | Nay Rodrigues\n";
;

    public static void main(String[] args) {
        System.out.println(BANNER);

        // Cursos
        Curso java = new Curso();
        java.setTitulo("Java POO – Abstração/Encapsulamento");
        java.setDescricao("Modelando domínio de Bootcamp");
        java.setCargaHoraria(8);

        Curso spring = new Curso();
        spring.setTitulo("API REST com Spring");
        spring.setDescricao("CRUD + JPA + validação");
        spring.setCargaHoraria(10);

        // Mentoria
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de carreira");
        mentoria.setDescricao("Estratégia de portfólio e GitHub");
        mentoria.setData(LocalDate.now().plusDays(2));

        // Bootcamp
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp GTF – Back-End com Java");
        bootcamp.setDescricao("Imersão prática em Java, REST e POO");
        Set<Conteudo> trilha = new LinkedHashSet<>();
        trilha.add(java);
        trilha.add(spring);
        trilha.add(mentoria);
        bootcamp.setConteudos(trilha);

        // Devs
        Dev nay = new Dev();
        nay.setNome("Nay Rodrigues");
        nay.inscreverBootcamp(bootcamp);

        Dev joao = new Dev();
        joao.setNome("João Silva");
        joao.inscreverBootcamp(bootcamp);

        // Progresso
        nay.progredir();  // conclui Java
        nay.progredir();  // conclui Spring

        joao.progredir(); // conclui Java

        // Relatórios
        System.out.println(bootcamp);
        System.out.println("----");
        System.out.println(nay.relatorio());
        System.out.println("----");
        System.out.println(joao.relatorio());
    }
}
