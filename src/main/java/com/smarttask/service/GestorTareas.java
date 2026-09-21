package com.smarttask.service;

import java.util.ArrayList;
import java.util.List;

import com.smarttask.model.Tarea;

/**
 * Gestiona las tareas de SmartTask.
 */
public class GestorTareas {

    private List<Tarea> tareas;
    private int siguienteId;

    /**
     * Crea un gestor de tareas vacío.
     */
    public GestorTareas() {
        tareas = new ArrayList<>();
        siguienteId = 1;
    }

    /**
     * Agrega una tarea al gestor y le asigna un ID automáticamente.
     *
     * @param tarea tarea que se desea agregar
     */
    public void agregarTarea(Tarea tarea) {
        tarea.setId(siguienteId);
        siguienteId++;
        tareas.add(tarea);

        System.out.println("Tarea agregada correctamente.");

    }

    /**
     * Muestra todas las tareas registradas.
     */
    public void listarTareas() {
        System.out.println("=== Tareas ===");

        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
            return;
        }

        for (Tarea tarea : tareas) {
            System.out.println("- ID: " + tarea.getId()
                    + " | " + tarea.getNombre()
                    + " | Completada: " + tarea.isCompletado());
        }
    }

    /**
     * Marca una tarea como completada utilizando su ID.
     *
     * @param id identificador de la tarea
     */
    public void marcarComoCompletada(int id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                tarea.setCompletado(true);
                System.out.println("Tarea marcada como completada.");
                return;
            }
        }

        System.out.println("Tarea no encontrada.");
    }

    /**
     * Elimina una tarea utilizando su ID.
     *
     * @param id identificador de la tarea
     */
    public void eliminarTarea(int id) {
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getId() == id) {
                tareas.remove(i);
                System.out.println("Tarea eliminada correctamente.");
                return;
            }
        }

        System.out.println("Tarea no encontrada.");
    }



}