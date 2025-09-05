package br.com.nayrodrigues.dio.poo;

import br.com.nayrodrigues.dio.poo.dominio.*;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class DevTest {
    @Test
    void calculaXpAoProgredir() {
        Curso c = new Curso(); c.setTitulo("C"); c.setCargaHoraria(5);
        Mentoria m = new Mentoria(); m.setTitulo("M");

        Set<Conteudo> conteudos = new LinkedHashSet<>();
        conteudos.add(c); conteudos.add(m);

        Bootcamp b = new Bootcamp(); b.setNome("B"); b.setConteudos(conteudos);

        Dev d = new Dev(); d.setNome("Dev");
        d.inscreverBootcamp(b);

        d.progredir(); // conclui Curso (5*10 = 50)
        d.progredir(); // conclui Mentoria (20*10 = 200)

        assertEquals(250d, d.calcularTotalXp(), 0.001);
        assertTrue(d.getConteudosInscritos().isEmpty());
        assertEquals(2, d.getConteudosConcluidos().size());
    }
}
