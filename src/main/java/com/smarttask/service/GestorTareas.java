package com.smarttask.service;

import java.util.ArrayList;
import java.util.List;

import com.smarttask.model.Tarea;

            /**
             * Gestiona las tareas de SmartTask.
             *
             * <p>Implementa las operaciones definidas por la interfaz
             * {@link Accionable} y almacena las tareas utilizando una
             * lista de tipo Tarea.</p>
             */
            public class GestorTareas implements Accionable {

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
            @Override
            public void agregarTarea(Tarea tarea) {
                tarea.setId(siguienteId);
                siguienteId++;
                tareas.add(tarea);

                System.out.println("Tarea agregada correctamente.");
            }

    /**
     * Muestra las tareas separadas entre activas y completadas.
     *
     * <p>El método utiliza el polimorfismo de Java al invocar
     * toString() sobre cada objeto almacenado como Tarea.</p>
     */
    @Override
    public void listarTareas() {
        System.out.println("=== TAREAS ACTIVAS ===");

        boolean hayActivas = false;

        for (Tarea tarea : tareas) {
            if (!tarea.isCompletado()) {
                System.out.println("- " + tarea);
                hayActivas = true;
            }
        }

        if (!hayActivas) {
            System.out.println("No hay tareas activas.");
        }

        System.out.println();
        System.out.println("=== TAREAS COMPLETADAS ===");

        boolean hayCompletadas = false;

        for (Tarea tarea : tareas) {
            if (tarea.isCompletado()) {
                System.out.println("- " + tarea);
                hayCompletadas = true;
            }
        }

        if (!hayCompletadas) {
            System.out.println("No hay tareas completadas.");
        }
    }

    /**
     * Marca una tarea como completada utilizando su ID.
     *
     * @param id identificador de la tarea
     */
    @Override
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
    @Override
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