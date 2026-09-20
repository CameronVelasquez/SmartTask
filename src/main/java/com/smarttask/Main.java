package com.smarttask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Punto de entrada de la aplicación SmartTask.
 *
 * <p>Esta clase contiene métodos iniciales para practicar
 * la lógica de gestión de tareas antes de incorporar
 * el modelo completo de objetos.</p>
 */
public class Main {

    /**
     * Inicia la ejecución de SmartTask.
     *
     * @param args argumentos recibidos desde la línea de comandos
     */
    public static void main(String[] args) {

        List<String> tareas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SmartTask ===");

        System.out.print("Ingrese una tarea: ");
        String nombre = scanner.nextLine();

        agregarTarea(tareas, nombre);
        listarTareas(tareas);

        eliminarTarea(tareas, 0);
        listarTareas(tareas);

        scanner.close();
    }

    /**
     * Agrega una tarea a la lista.
     *
     * @param tareas lista donde se almacenarán las tareas
     * @param nombre nombre de la tarea que se desea agregar
     */
    public static void agregarTarea(List<String> tareas, String nombre) {
        tareas.add(nombre);
        System.out.println("Tarea agregada correctamente.");
    }

    /**
     * Muestra las tareas almacenadas en la lista.
     *
     * @param tareas lista de tareas que se desea mostrar
     */
    public static void listarTareas(List<String> tareas) {

        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
            return;
        }

        System.out.println("=== Tareas ===");

        for (String tarea : tareas) {
            System.out.println("- " + tarea);
        }
    }

    /**
     * Elimina una tarea utilizando su posición en la lista.
     *
     * @param tareas lista de tareas
     * @param posicion posición de la tarea que se desea eliminar
     */
    public static void eliminarTarea(List<String> tareas, int posicion) {

        if (posicion >= 0 && posicion < tareas.size()) {
            tareas.remove(posicion);
            System.out.println("Tarea eliminada correctamente.");
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }
}