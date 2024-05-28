import entidades.Paciente;
import entidades.Funcionario;
import entidades.Endereço;
import entidades.Nutricionista;
import entidades.Consulta;
import repositorios.Lista;
import repositorios.ListaFuncionario;
import repositorios.ListaNutricionista;
import repositorios.ListaConsulta;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Módulo 2 - Semana 03");
        while (true) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1 - Cadastrar novo paciente");
            System.out.println("2 - Listar pacientes");
            System.out.println("3 - Alterar informações do paciente");
            System.out.println("4 - Mostrar informações de um paciente");
            System.out.println("5 - Registrar atividade física para um paciente");
            System.out.println("6 - Remover paciente");
            System.out.println("7 - Cadastrar novo funcionário");
            System.out.println("8 - Cadastrar novo nutricionista");
            System.out.println("9 - Criar consulta");
            System.out.println("10 - Listar funcionários");
            System.out.println("11 - Listar Nutricionistas");
            System.out.println("12 - Listar consultas");
            System.out.println("13 - Realizar consulta");
            System.out.println("14 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarNovoPaciente(scanner);
                    break;
                case 2:
                    listarPacientes();
                    break;
                case 3:
                    alterarInformacoesPaciente(scanner);
                    break;
                case 4:
                    mostrarInformacoesPaciente(scanner);
                    break;
                case 5:
                    registrarAtividadeFisica(scanner);
                    break;
                case 6:
                    removerPaciente(scanner);
                    break;
                case 7:
                    cadastrarNovoFuncionario(scanner);
                    break;
                case 8:
                    cadastrarNovoNutricionista(scanner);
                    break;
                case 9:
                    criarConsulta(scanner);
                    break;
                case 10:
                    listarFuncionarios();
                    break;
                case 11:
                    listarNutricionistas();
                    break;
                case 12:
                    listarConsultas();
                    break;
                case 13:
                    realizarConsulta(scanner);
                    break;
                case 14:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void cadastrarNovoPaciente(Scanner scanner) {
        System.out.println("Informe o nome do paciente:");
        String nome = scanner.nextLine();

        System.out.println("Informe a idade do paciente:");
        int idade = scanner.nextInt();

        System.out.println("Informe o peso do paciente (kg):");
        double peso = scanner.nextDouble();

        System.out.println("Informe a altura do paciente (m):");
        double altura = scanner.nextDouble();

        System.out.println("Informe a pressão arterial do paciente:");
        double pressaoArterial = scanner.nextDouble();

        System.out.println("Informe a frequência cardíaca do paciente:");
        double frequenciaCardiaca = scanner.nextDouble();

        System.out.println("Informe a dieta alimentar do paciente:");
        scanner.nextLine();
        String dietaAlimentar = scanner.nextLine();

        Paciente paciente = new Paciente(nome, idade, peso, altura, pressaoArterial, frequenciaCardiaca, dietaAlimentar);
        Lista.adicionar(paciente);
        System.out.println("Paciente cadastrado com sucesso!");
    }

    public static void listarPacientes() {
        System.out.println("\nListagem de Pacientes:");
        List<Paciente> pacientes = Lista.listar();
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + " - " + pacientes.get(i).getNome());
        }
    }

    public static void alterarInformacoesPaciente(Scanner scanner) {
        listarPacientes();
        System.out.println("Informe o ID do paciente que deseja alterar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Paciente paciente = Lista.buscarPorId(id - 1);
        if (paciente != null) {
            System.out.println("\nInforme as novas informações:");
            System.out.println("Peso (kg):");
            double peso = scanner.nextDouble();
            paciente.setPeso(peso);

            System.out.println("Altura (m):");
            double altura = scanner.nextDouble();
            paciente.setAltura(altura);

            System.out.println("Pressão arterial:");
            double pressaoArterial = scanner.nextDouble();
            paciente.setPressaoArterial(pressaoArterial);

            System.out.println("Frequência cardíaca:");
            double frequenciaCardiaca = scanner.nextDouble();
            paciente.setFrequenciaCardiaca(frequenciaCardiaca);

            System.out.println("Dieta alimentar:");
            scanner.nextLine();
            String dietaAlimentar = scanner.nextLine();
            paciente.setDietaAlimentar(dietaAlimentar);

            Lista.alterar(id - 1, paciente);
            System.out.println("Informações do paciente atualizadas com sucesso!");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public static void mostrarInformacoesPaciente(Scanner scanner) {
        listarPacientes();
        System.out.println("Informe o ID do paciente para ver as informações:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Paciente paciente = Lista.buscarPorId(id - 1);
        if (paciente != null) {
            System.out.println("\nInformações do Paciente:");
            System.out.println(paciente.monitorarPaciente());
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public static void registrarAtividadeFisica(Scanner scanner) {
        listarPacientes();
        System.out.println("Informe o ID do paciente para registrar atividade física:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Paciente paciente = Lista.buscarPorId(id - 1);
        if (paciente != null) {
            System.out.println("Informe a atividade física realizada:");
            String atividade = scanner.nextLine();
            paciente.registrarAtividadeFisica(atividade);
            System.out.println("Atividade física registrada com sucesso para o paciente " + paciente.getNome() + ".");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public static void removerPaciente(Scanner scanner) {
        listarPacientes();
        System.out.println("Informe o ID do paciente que deseja remover:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Paciente paciente = Lista.buscarPorId(id - 1);
        if (paciente != null) {
            Lista.remover(id - 1);
            System.out.println("Paciente removido com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public static void cadastrarNovoFuncionario(Scanner scanner) {
        System.out.println("Informe o nome do funcionário:");
        String nome = scanner.nextLine();

        System.out.println("Informe a idade do funcionário:");
        int idade = scanner.nextInt();

        System.out.println("Informe o salário do funcionário:");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        Endereço endereco = cadastrarEndereco(scanner);

        Funcionario funcionario = new Funcionario(nome, idade, endereco, salario);
        ListaFuncionario.adicionar(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public static Endereço cadastrarEndereco(Scanner scanner) {
        System.out.println("Informe o logradouro:");
        String logradouro = scanner.nextLine();

        System.out.println("Informe o estado:");
        String estado = scanner.nextLine();

        System.out.println("Informe a cidade:");
        String cidade = scanner.nextLine();

        System.out.println("Informe o número:");
        int numero = scanner.nextInt();

        System.out.println("Informe o CEP:");
        String cep = scanner.next();

        return new Endereço(logradouro, estado, cidade, numero, cep);
    }

    public static void cadastrarNovoNutricionista(Scanner scanner) {
        System.out.println("Informe o nome do nutricionista:");
        String nome = scanner.nextLine();

        if (ListaNutricionista.buscarPorNome(nome) != null) {
            System.out.println("Já existe um nutricionista com esse nome.");
            return;
        }

        System.out.println("Informe a idade do nutricionista:");
        int idade = scanner.nextInt();

        System.out.println("Informe o salário do nutricionista:");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Informe o tempo de experiência do nutricionista (em anos):");
        int tempoDeExperiencia = scanner.nextInt();
        scanner.nextLine();

        Endereço endereco = cadastrarEndereco(scanner);

        Nutricionista nutricionista = new Nutricionista(nome, idade, endereco, salario, tempoDeExperiencia);

        System.out.println("Informe o número de certificações:");
        int numCertificacoes = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numCertificacoes; i++) {
            System.out.println("Informe a certificação " + (i + 1) + ":");
            String certificacao = scanner.nextLine();
            nutricionista.adicionarCertificacao(certificacao);
        }

        ListaNutricionista.adicionar(nutricionista);
        System.out.println("Nutricionista cadastrado com sucesso!");
    }

    public static void criarConsulta(Scanner scanner) {
        System.out.println("Informe o nome do nutricionista:");
        String nomeNutricionista = scanner.nextLine();

        Nutricionista nutricionista = ListaNutricionista.buscarPorNome(nomeNutricionista);
        if (nutricionista == null) {
            System.out.println("Nutricionista não encontrado.");
            return;
        }

        System.out.println("Informe o nome do paciente:");
        String nomePaciente = scanner.nextLine();

        Paciente paciente = Lista.buscarPorNome(nomePaciente);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.println("Informe a data e hora da consulta (formato: yyyy-MM-ddTHH:mm):");
        String dataHoraStr = scanner.nextLine();
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr);

        Consulta consulta = new Consulta(nomeNutricionista, nomePaciente, dataHora, false);
        ListaConsulta.adicionar(consulta);
        System.out.println("Consulta criada com sucesso!");
    }

    public static void listarFuncionarios() {
        System.out.println("\nListagem de Funcionários:");
        List<Funcionario> funcionarios = ListaFuncionario.listar();
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println((i + 1) + " - " + funcionarios.get(i).getNome());
        }
    }

    public static void listarNutricionistas() {
        System.out.println("\nListagem de Nutricionistas:");
        List<Nutricionista> nutricionistas = ListaNutricionista.listar();
        for (int i = 0; i < nutricionistas.size(); i++) {
            Nutricionista nutricionista = nutricionistas.get(i);
            System.out.println("Nome: " + nutricionista.getNome());
            System.out.println("Idade: " + nutricionista.getIdade());
            System.out.println("Endereço: " + nutricionista.getEndereco());
            System.out.println("Salário: " + nutricionista.getSalario());
            System.out.println("Número de consultas: " + nutricionista.getNumeroConsultas());
            System.out.println("Tempo de experiência: " + nutricionista.getTempoExperiencia());
            System.out.println("Certificações:");
            for (String certificado : nutricionista.getCertificacoes()) {
                System.out.println("- " + certificado);
            }
            System.out.println();
        }
    }

    public static void listarConsultas() {
        System.out.println("\nListagem de Consultas:");
        List<Consulta> consultas = ListaConsulta.listar();
        for (int i = 0; i < consultas.size(); i++) {
            Consulta consulta = consultas.get(i);
            String statusConsulta = consulta.isConsultaRealizada() ? "Realizada" : "Não realizada";
            System.out.println((i + 1) + " - Nutricionista: " + consulta.getNomeNutricionista() + ", Paciente: " + consulta.getNomePaciente() + ", Data e Hora: " + consulta.getDataHora() + ", Status: " + statusConsulta);
        }
    }

    public static void realizarConsulta(Scanner scanner) {
        listarConsultas();
        System.out.println("Informe o ID da consulta que deseja realizar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Consulta consulta = ListaConsulta.buscarPorId(id - 1);
        if (consulta != null) {
            consulta.setConsultaRealizada(true);
            ListaConsulta.alterar(id - 1, consulta);
            System.out.println("Consulta realizada com sucesso.");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }
}