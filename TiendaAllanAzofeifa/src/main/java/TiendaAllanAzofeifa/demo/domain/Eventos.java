/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiendaAllanAzofeifa.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Entity
@Data
@Table (name="eventos")
public class Eventos implements Serializable  {

     private static final long serialVersionUID = 1L;
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEventos;

    private String nombre;
    private String descripcion;
    private String tipo;
    private Date fechaInicio;
    private Date fechaFin;
    private int capacidad;

    public Eventos() {
    }

    public Eventos(Long idEventos, String nombre, String descripcion, String tipo, Date fechaInicio, Date fechaFin, int capacidad) {
        this.idEventos = idEventos;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.capacidad = capacidad;
    }
    
    
    
}


