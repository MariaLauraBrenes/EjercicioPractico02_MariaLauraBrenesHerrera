/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiendaAllanAzofeifa.demo.impl;

import TiendaAllanAzofeifa.demo.dao.EventosDao;
import TiendaAllanAzofeifa.demo.domain.Eventos;
import TiendaAllanAzofeifa.demo.Service.EventosService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventosServiceImpl implements EventosService {
    
    @Autowired
    private EventosDao eventosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Eventos> getEventos() {
        return eventosDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Eventos getEvento(Eventos eventos) {
        return eventosDao.findById(eventos.getIdEventos()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Eventos eventos) {
        eventosDao.save(eventos);
    }

    @Override
    @Transactional
    public void delete(Eventos eventos) {
        eventosDao.delete(eventos);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Eventos> buscarEventosNativo(String tipo, LocalDate fechaInicio, LocalDate fechaFin) {
        return eventosDao.buscarEventosNativo(tipo, fechaInicio, fechaFin);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Eventos> buscarEventosPorFechaNativo(LocalDate fechaInicio, LocalDate fechaFin) {
        return eventosDao.buscarEventosPorFechaNativo(fechaInicio, fechaFin);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Eventos> buscarEventosPorTipoNativo(String tipo) {
        return eventosDao.buscarEventosPorTipoNativo(tipo);
    }
}