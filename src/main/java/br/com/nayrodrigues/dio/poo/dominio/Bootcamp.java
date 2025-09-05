package br.com.nayrodrigues.dio.poo.dominio;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicio = LocalDate.now();
    private final LocalDate dataFim = dataInicio.plusDays(45);

    private Set<Conteudo> conteudos = new LinkedHashSet<>();
    private Set<Dev> devsInscritos = new LinkedHashSet<>();

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public LocalDate getDataInicio() { return dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public Set<Conteudo> getConteudos() { return conteudos; }
    public void setConteudos(Set<Conteudo> conteudos) { this.conteudos = conteudos; }
    public Set<Dev> getDevsInscritos() { return devsInscritos; }

    void registrarDev(Dev dev) { // package-private para controle via Dev
        devsInscritos.add(dev);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bootcamp)) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome);
    }

    @Override
    public int hashCode() { return Objects.hash(nome); }

    @Override
    public String toString() {
        return "Bootcamp{" +
                "nome='" + nome + '\'' +
                ", inicio=" + dataInicio +
                ", fim=" + dataFim +
                ", conteudos=" + conteudos.size() +
                ", devsInscritos=" + devsInscritos.size() +
                '}';
    }
}
