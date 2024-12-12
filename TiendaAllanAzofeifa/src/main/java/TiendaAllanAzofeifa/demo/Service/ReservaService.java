/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TiendaAllanAzofeifa.demo.Service;

import TiendaAllanAzofeifa.demo.domain.Reservas;
import java.util.ArrayList;
import java.util.List;

public interface ReservaService {
    List<Reservas> listaReservas = new ArrayList<>();

    List<Reservas> getReservas();

    Reservas get(Reservas reserva);

    void save(Reservas reserva);

    void delete(Reservas reserva);

    void actualizar(Reservas reserva);
}
