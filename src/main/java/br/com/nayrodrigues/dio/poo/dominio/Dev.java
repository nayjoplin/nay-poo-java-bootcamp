package br.com.nayrodrigues.dio.poo.dominio;

import java.util.*;
import java.util.stream.Collectors;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        Objects.requireNonNull(bootcamp, "Bootcamp não pode ser nulo");
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.registrarDev(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            Conteudo c = conteudo.get();
            conteudosConcluidos.add(c);
            conteudosInscritos.remove(c);
        } else {
            System.out.println("[AVISO] " + nome + " não possui conteúdos inscritos.");
        }
    }

    public double calcularTotalXp() {
        return conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public String relatorio() {
        String inscritos = conteudosInscritos.stream()
                .map(Conteudo::toString).collect(Collectors.joining(", "));
        String concluidos = conteudosConcluidos.stream()
                .map(Conteudo::toString).collect(Collectors.joining(", "));
        return "Dev{" + nome + "}\n" +
               "- Inscritos: [" + inscritos + "]\n" +
               "- Concluídos: [" + concluidos + "]\n" +
               "- XP total: " + calcularTotalXp();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Set<Conteudo> getConteudosInscritos() { return conteudosInscritos; }
    public Set<Conteudo> getConteudosConcluidos() { return conteudosConcluidos; }
}
