package br.com.nayrodrigues.dio.poo.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo {
    private LocalDate data;

    @Override
    public double calcularXp() {
        // Mentorias valem um bônus fixo sobre o XP padrão
        return XP_PADRAO * 20;
    }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    @Override
    public String toString() {
        return super.toString().replace("}", ", data=" + data + "}");
    }
}
