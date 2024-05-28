package repositorios;

//Ex.08 Semana 3

import entidades.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class ListaFuncionario {


    private static List<Funcionario> funcionarios = new ArrayList<>();

    public static void adicionar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public static List<Funcionario> listar() {
        return funcionarios;
    }

    public static Funcionario buscarPorId(int id) {
        if (id >= 0 && id < funcionarios.size()) {
            return funcionarios.get(id);
        }
        return null;
    }

    public static void remover(int id) {
        if (id >= 0 && id < funcionarios.size()) {
            funcionarios.remove(id);
        }
    }

    public static void alterar(int id, Funcionario funcionario) {
        if (id >= 0 && id < funcionarios.size()) {
            funcionarios.set(id, funcionario);
        }
    }
}

