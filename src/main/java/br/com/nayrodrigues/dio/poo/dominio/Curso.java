package br.com.nayrodrigues.dio.poo.dominio;

public class Curso extends Conteudo {
    private int cargaHoraria; // em horas

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria; }

    @Override
    public String toString() {
        return super.toString().replace("}", ", cargaHoraria=" + cargaHoraria + "h}");
    }
}
