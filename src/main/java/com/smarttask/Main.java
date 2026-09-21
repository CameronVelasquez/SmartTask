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

                   int opcion;

                do {
                    System.out.println("\n=== SmartTask ===");
                    System.out.println("1. Agregar tarea");
                    System.out.println("2. Listar tareas");
                    System.out.println("3. Eliminar tarea");
                    System.out.println("4. Salir");
                    System.out.print("Seleccione una opción: ");

                opcion = scanner.nextInt();
                scanner.nextLine();


                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese una tarea: ");
                        String nombre = scanner.nextLine();

                        Tarea tarea = new Tarea(1, nombre);
                        agregarTarea(tareas, tarea);
                        break;

                    case 2:
                        listarTareas(tareas);
                        break;

                    case 3:
                        System.out.print("Ingrese la posición de la tarea a eliminar: ");
                        int posicion = scanner.nextInt();

                        eliminarTarea(tareas, posicion);
                        break;

                    case 4:
                        System.out.println("Programa finalizado.");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                    }

                    } while (opcion != 4);

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
     * Elimina una tarea utilizando su posición.
     *
     * @param tareas lista de tareas
     * @param posicion posición indicada por el usuario, comenzando en 1
     */
    public static void eliminarTarea(List<Tarea> tareas, int posicion) {

        int indice = posicion - 1;

        if (indice >= 0 && indice < tareas.size()) {
            tareas.remove(indice);
            System.out.println("Tarea eliminada correctamente.");
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }


}