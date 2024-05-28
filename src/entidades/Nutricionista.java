package entidades;
import java.util.ArrayList;
import java.util.List;
//Ex.04 e 05 Semana 3
public class Nutricionista extends Funcionario{
    private List<String> certificacoes;
    private int numeroConsultas;
    private int tempoExperiencia;

    public Nutricionista(String nome, int idade, Endereço endereco, double salario, int tempoExperiencia) {
        super(nome, idade, endereco, salario);
        this.certificacoes = new ArrayList<>();
        this.numeroConsultas = 0;
        this.tempoExperiencia = tempoExperiencia;
    }

    public List<String> getCertificacoes() {
        return certificacoes;
    }

    public void setCertificacoes(List<String> certificacoes) {
        this.certificacoes = certificacoes;
    }

    public int getNumeroConsultas() {
        return numeroConsultas;
    }

    public void setNumeroConsultas(int numeroConsultas) {
        this.numeroConsultas = numeroConsultas;
    }

    public int getTempoExperiencia() {
        return tempoExperiencia;
    }

    public void setTempoExperiencia(int tempoExperiencia) {
        this.tempoExperiencia = tempoExperiencia;
    }

    public void adicionarCertificacao(String certificacao) {
        certificacoes.add(certificacao);
    }

    public void adicionarAnoExperiencia() {
        tempoExperiencia++;
    }
}