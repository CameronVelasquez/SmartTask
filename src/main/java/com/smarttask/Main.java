package com.smarttask;

import java.util.Scanner;

import com.smarttask.model.Tarea;
import com.smarttask.service.GestorTareas;

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

                 GestorTareas gestor = new GestorTareas();
                 Scanner scanner = new Scanner(System.in);

                   int opcion;

                do {
                    System.out.println("\n=== SmartTask ===");
                    System.out.println("1. Agregar tarea");
                    System.out.println("2. Listar tareas");
                    System.out.println("3. Marcar tarea como completada");
                    System.out.println("4. Eliminar tarea");
                    System.out.println("5. Salir");
                    System.out.print("Seleccione una opción: ");

                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese una tarea: ");
                        String nombre = scanner.nextLine();

                        Tarea tarea = new Tarea(0, nombre);
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

                    } while (opcion != 5);

                    scanner.close();
       }
    
}