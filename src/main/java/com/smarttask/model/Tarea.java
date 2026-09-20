package com.smarttask.model;

/**
 * Representa una tarea básica dentro de SmartTask.
 *
 * <p>Una tarea posee un identificador, un nombre y un estado
 * que indica si ha sido completada.</p>
 */
public class Tarea {

    private int id;
    private String nombre;
    private boolean completado;

    /**
     * Crea una nueva tarea.
     *
     * @param id identificador inicial de la tarea
     * @param nombre nombre de la tarea
     */
    public Tarea(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.completado = false;
    }

    /**
     * Obtiene el identificador de la tarea.
     *
     * @return identificador de la tarea
     */
    public int getId() {
        return id;
    }

    /**
     * Modifica el identificador de la tarea.
     *
     * @param id nuevo identificador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la tarea.
     *
     * @return nombre de la tarea
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre de la tarea.
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Indica si la tarea está completada.
     *
     * @return true si la tarea está completada; false en caso contrario
     */
    public boolean isCompletado() {
        return completado;
    }

    /**
     * Modifica el estado de completitud de la tarea.
     *
     * @param completado nuevo estado de la tarea
     */
    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
}