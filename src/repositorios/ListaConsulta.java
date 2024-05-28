package repositorios;
//Ex.07 Semana 03 (adicionado Status da consulta)
import entidades.Consulta;
import entidades.Nutricionista;

import java.util.ArrayList;
import java.util.List;

public class ListaConsulta {

    private static List<Consulta> consultas = new ArrayList<>();

    public static void adicionar(Consulta consulta) {
        consulta.setConsultaRealizada(false);
        consultas.add(consulta);
        Nutricionista nutricionista = ListaNutricionista.buscarPorNome(consulta.getNomeNutricionista());
        if (nutricionista != null) {
            nutricionista.setNumeroConsultas(nutricionista.getNumeroConsultas() + 1);
        }
    }

    public static List<Consulta> listar() {
        return consultas;
    }

    public static Consulta buscarPorId(int id) {
        if (id >= 0 && id < consultas.size()) {
            return consultas.get(id);
        }
        return null;
    }

    public static void remover(int id) {
        if (id >= 0 && id < consultas.size()) {
            consultas.remove(id);
        }
    }

    public static void alterar(int id, Consulta novaConsulta) {
        if (id >= 0 && id < consultas.size()) {
            consultas.set(id, novaConsulta);
        }
    }

    // Método para exibir a listagem de consultas com o status
    public static void listarComStatus() {
        System.out.println("Listagem de Consultas:");
        for (int i = 0; i < consultas.size(); i++) {
            Consulta consulta = consultas.get(i);
            String statusConsulta = consulta.isConsultaRealizada() ? "Realizada" : "Não realizada";
            System.out.println((i + 1) + " - Nutricionista: " + consulta.getNomeNutricionista() +
                    ", Paciente: " + consulta.getNomePaciente() +
                    ", Data e Hora: " + consulta.getDataHora() +
                    ", Status: " + statusConsulta);
        }
    }
}

