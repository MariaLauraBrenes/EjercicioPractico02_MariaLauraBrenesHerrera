/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TiendaAllanAzofeifa.demo.dao;

import TiendaAllanAzofeifa.demo.domain.Eventos;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventosDao extends JpaRepository<Eventos, Long> {
    
    @Query(nativeQuery = true,
           value = "SELECT * FROM eventos WHERE tipo = :tipo AND fecha_inicio BETWEEN :fechaInicio AND :fechaFin ORDER BY fecha_inicio ASC")
    List<Eventos> buscarEventosNativo(@Param("tipo") String tipo, @Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);

    @Query(nativeQuery = true,
           value = "SELECT * FROM eventos WHERE fecha_inicio BETWEEN :fechaInicio AND :fechaFin ORDER BY fecha_inicio ASC")
    List<Eventos> buscarEventosPorFechaNativo(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);

    @Query(nativeQuery = true,
           value = "SELECT * FROM eventos WHERE tipo = :tipo ORDER BY fecha_inicio ASC")
    List<Eventos> buscarEventosPorTipoNativo(@Param("tipo") String tipo);
}