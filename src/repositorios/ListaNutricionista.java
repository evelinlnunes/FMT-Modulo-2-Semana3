package repositorios;
//Ex.08 Semana 3
import entidades.Nutricionista;

import java.util.ArrayList;
import java.util.List;

public class ListaNutricionista {

    private static List<Nutricionista> nutricionistas = new ArrayList<>();

    public static void adicionar(Nutricionista nutricionista) {
        for (Nutricionista n : nutricionistas) {
            if (n.getNome().equalsIgnoreCase(nutricionista.getNome())) {
                System.out.println("Nutricionista com esse nome já existe!");
                return;
            }
        }
        nutricionistas.add(nutricionista);
    }

    public static List<Nutricionista> listar() {
        return nutricionistas;
    }

    public static Nutricionista buscarPorId(int id) {
        if (id >= 0 && id < nutricionistas.size()) {
            return nutricionistas.get(id);
        }
        return null;
    }

    public static Nutricionista buscarPorNome(String nome) {
        for (Nutricionista n : nutricionistas) {
            if (n.getNome().equalsIgnoreCase(nome)) {
                return n;
            }
        }
        return null;
    }

    public static void remover(int id) {
        if (id >= 0 && id < nutricionistas.size()) {
            nutricionistas.remove(id);
        }
    }

    public static void alterar(int id, Nutricionista nutricionista) {
        if (id >= 0 && id < nutricionistas.size()) {
            nutricionistas.set(id, nutricionista);
        }
    }
}

