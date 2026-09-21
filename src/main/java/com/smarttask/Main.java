package com.smarttask;

import java.util.Scanner;

import com.smarttask.model.Tarea;
import com.smarttask.model.TareaNormal;
import com.smarttask.model.TareaUrgente;
import com.smarttask.service.GestorTareas;

/**
 * Punto de entrada de la aplicación SmartTask.
 *
 * <p>Permite al usuario administrar tareas normales y urgentes
 * mediante un menú de consola.</p>
 */
public class Main {

    /**
     * Inicia la ejecución de SmartTask.
     *
     * @param args argumentos recibidos desde la línea de comandos
     */
    public static void main(String[] args) {

        GestorTareas gestor = new GestorTareas();
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("\n=== SmartTask ===");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {

                    case 1:
                        System.out.print("Ingrese el nombre de la tarea: ");
                        String nombre = scanner.nextLine();

                        System.out.println("Seleccione el tipo de tarea:");
                        System.out.println("1. Normal");
                        System.out.println("2. Urgente");
                        System.out.print("Seleccione una opción: ");

                        int tipo = scanner.nextInt();
                        scanner.nextLine();

                        Tarea tarea;

                        if (tipo == 1) {
                            tarea = new TareaNormal(0, nombre);

                        } else if (tipo == 2) {
                            System.out.print("Ingrese los días límite: ");
                            int diasLimite = scanner.nextInt();
                            scanner.nextLine();

                            tarea = new TareaUrgente(0, nombre, diasLimite);

                        } else {
                            System.out.println("Tipo de tarea no válido.");
                            break;
                        }

                        gestor.agregarTarea(tarea);
                        break;

                    case 2:
                        gestor.listarTareas();
                        break;

                    case 3:
                        System.out.print("Ingrese el ID de la tarea a completar: ");
                        int idCompletar = scanner.nextInt();

                        gestor.marcarComoCompletada(idCompletar);
                        break;

                    case 4:
                        System.out.print("Ingrese el ID de la tarea a eliminar: ");
                        int id = scanner.nextInt();

                        gestor.eliminarTarea(id);
                        break;

                    case 5:
                        System.out.println("Programa finalizado.");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida. Intente nuevamente.");
                scanner.nextLine();
            }

        } while (opcion != 5);

        scanner.close();
    }
}