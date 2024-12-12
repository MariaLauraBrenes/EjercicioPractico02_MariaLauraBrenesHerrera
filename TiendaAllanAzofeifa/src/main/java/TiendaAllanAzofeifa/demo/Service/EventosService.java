/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TiendaAllanAzofeifa.demo.Service;

import TiendaAllanAzofeifa.demo.domain.Eventos;
import java.time.LocalDate;
import java.util.List;

public interface EventosService {
    List<Eventos> getEventos();
    Eventos getEvento(Eventos eventos);
    void save(Eventos eventos);
    void delete(Eventos eventos);
    List<Eventos> buscarEventosNativo(String tipo, LocalDate fechaInicio, LocalDate fechaFin);
    List<Eventos> buscarEventosPorFechaNativo(LocalDate fechaInicio, LocalDate fechaFin);
    List<Eventos> buscarEventosPorTipoNativo(String tipo);
}