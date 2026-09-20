package com.smarttask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.smarttask.model.Tarea;

/**
 * Punto de entrada de la aplicación SmartTask.
 *
 * <p>Esta clase contiene las primeras pruebas de la lógica
 * de gestión de tareas utilizando objetos de tipo Tarea.</p>
 */
public class Main {

    /**
     * Inicia la ejecución de SmartTask.
     *
     * @param args argumentos recibidos desde la línea de comandos
     */
    public static void main(String[] args) {

        List<Tarea> tareas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SmartTask ===");

        System.out.print("Ingrese una tarea: ");
        String nombre = scanner.nextLine();

        Tarea tarea = new Tarea(1, nombre);

        agregarTarea(tareas, tarea);
        listarTareas(tareas);

        if (!tarea.isCompletado()) {
         System.out.println("La tarea todavía está pendiente.");
        }            

        int opcion = 1;

        switch (opcion) {
           case 1:
               System.out.println("Opción seleccionada: revisar tarea.");
        break;
            case 2:
               System.out.println("Opción seleccionada: completar tarea.");
        break;
            default:
                 System.out.println("Opción no reconocida.");
        }

        int contador = 0;

        while (contador < 2) {
             System.out.println("Comprobación while: " + (contador + 1));
                      contador++;
        }

        scanner.close();
    }

    /**
     * Agrega una tarea a la lista.
     *
     * @param tareas lista donde se almacenarán las tareas
     * @param tarea tarea que se desea agregar
     */
    public static void agregarTarea(List<Tarea> tareas, Tarea tarea) {
        tareas.add(tarea);
        System.out.println("Tarea agregada correctamente.");
    }

    /**
     * Muestra las tareas almacenadas en la lista.
     *
     * @param tareas lista de tareas que se desea mostrar
     */
    public static void listarTareas(List<Tarea> tareas) {

        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
            return;
        }

        System.out.println("=== Tareas ===");

        for (Tarea tarea : tareas) {
            System.out.println("- ID: " + tarea.getId()
                    + " | " + tarea.getNombre()
                    + " | Completada: " + tarea.isCompletado());
        }
    }

    /**
     * Elimina una tarea utilizando su posición en la lista.
     *
     * @param tareas lista de tareas
     * @param posicion posición de la tarea que se desea eliminar
     */
    public static void eliminarTarea(List<Tarea> tareas, int posicion) {

        if (posicion >= 0 && posicion < tareas.size()) {
            tareas.remove(posicion);
            System.out.println("Tarea eliminada correctamente.");
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }
}