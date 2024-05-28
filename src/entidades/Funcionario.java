package entidades;
//Ex. 03 Semana 3
public class Funcionario {
    private String nome;
    private int idade;
    private Endereço endereco;
    private double salario;

    // Construtor completo
    public Funcionario(String nome, int idade, Endereço endereco, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.salario = salario;
    }

    // Construtor vazio
    public Funcionario() {}

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereço getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereço endereco) {
        this.endereco = endereco;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}

