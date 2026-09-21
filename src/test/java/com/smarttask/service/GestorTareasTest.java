package com.smarttask.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import com.smarttask.model.TareaNormal;
import com.smarttask.model.TareaUrgente;

public class GestorTareasTest {

    @Test
    public void testAgregarTarea() {
        GestorTareas gestor = new GestorTareas();

        TareaNormal tareaNormal = new TareaNormal(0, "Estudiar Java");

        gestor.agregarTarea(tareaNormal);

        assertEquals(1, tareaNormal.getId());

        TareaUrgente tareaUrgente = new TareaUrgente(0, "Terminar proyecto", 5);

        gestor.agregarTarea(tareaUrgente);

        assertEquals(2, tareaUrgente.getId());
        assertEquals(5, tareaUrgente.getDiasLimite());

        tareaUrgente.setDiasLimite(3);
        
        assertEquals(3, tareaUrgente.getDiasLimite());
        assertTrue(!tareaUrgente.estaVencida());

        tareaUrgente.setDiasLimite(0);
        
        assertTrue(tareaUrgente.estaVencida());
    }

    @Test
    public void testListarTareas() {
        GestorTareas gestor = new GestorTareas();

        TareaNormal tarea = new TareaNormal(0, "Estudiar Java");

        gestor.agregarTarea(tarea);

        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;
        System.setOut(new PrintStream(salida));

        try {
            gestor.listarTareas();
        } finally {
            System.setOut(salidaOriginal);
        }

        String resultado = salida.toString();

        assertTrue(resultado.contains(
            "[NORMAL] ID: 1 | Nombre: Estudiar Java | Completada: false"
        ));
        gestor.eliminarTarea(1);
        gestor.eliminarTarea(99);
    }

   @Test
    public void testMarcarComoCompletada() {
        GestorTareas gestor = new GestorTareas();

        TareaNormal tarea = new TareaNormal(0, "Estudiar Java");

        gestor.agregarTarea(tarea);
        gestor.marcarComoCompletada(1);

        assertTrue(tarea.isCompletado());

        gestor.marcarComoCompletada(99);
    }
}