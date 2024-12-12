/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiendaAllanAzofeifa.demo.impl;


import TiendaAllanAzofeifa.demo.domain.Reservas;
import TiendaAllanAzofeifa.demo.Service.ReservaService;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Override
    public List<Reservas> getReservas() {
        return listaReservas;
    }

    @Override
    public void save(Reservas reserva) {
        boolean existe = false;
        for (Reservas r : listaReservas) {
            if (Objects.equals(r.getEventos().getIdEventos(), reserva.getEventos().getIdEventos())) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            reserva.setFechaReserva(new Timestamp(System.currentTimeMillis()));
            listaReservas.add(reserva);
        }
    }

    @Override
    public void delete(Reservas reserva) {
        listaReservas.removeIf(r -> Objects.equals(r.getEventos().getIdEventos(), reserva.getEventos().getIdEventos()));
    }

    @Override
    public Reservas get(Reservas reserva) {
        for (Reservas r : listaReservas) {
            if (Objects.equals(r.getEventos().getIdEventos(), reserva.getEventos().getIdEventos())) {
                return r;
            }
        }
        return null;
    }

    @Override
    public void actualizar(Reservas reserva) {
        for (Reservas r : listaReservas) {
            if (Objects.equals(r.getEventos().getIdEventos(), reserva.getEventos().getIdEventos())) {
                r.setFechaReserva(reserva.getFechaReserva());
                break;
            }
        }
    }
}


