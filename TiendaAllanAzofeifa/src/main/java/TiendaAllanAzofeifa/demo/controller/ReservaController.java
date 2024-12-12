/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiendaAllanAzofeifa.demo.controller;

import TiendaAllanAzofeifa.demo.domain.Eventos;
import TiendaAllanAzofeifa.demo.domain.Reservas;
import TiendaAllanAzofeifa.demo.Service.EventosService;
import TiendaAllanAzofeifa.demo.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private EventosService eventoService;

    @GetMapping("/listado")
    public String listarReservas(Model model) {
        var reservas = reservaService.getReservas();
        model.addAttribute("reservas", reservas);
        return "/reservas/listado";
    }

    @GetMapping("/agregar/{idEvento}")
    public ModelAndView agregarReserva(Eventos eventos, Model model) {
        var evento = eventoService.getEvento(eventos);
        if (evento == null) {
            return new ModelAndView("redirect:/eventos/listado");
        }

        Reservas nuevaReserva = new Reservas();
        nuevaReserva.setEventos(evento);
        reservaService.save(nuevaReserva);

        var reservas = reservaService.getReservas();
        model.addAttribute("reservas", reservas);
        return new ModelAndView("/reservas/fragmentos :: listaReservas");
    }

@GetMapping("/eliminar/{idEvento}")
public ModelAndView eliminarReserva(Eventos eventos, Model model) {
    var evento = eventoService.getEvento(eventos);
    if (evento == null) {
        return new ModelAndView("redirect:/reservas/listado");
    }

    Reservas reservaAEliminar = new Reservas();
    reservaAEliminar.setEventos(evento);
    reservaService.delete(reservaAEliminar);

    var reservas = reservaService.getReservas();
    model.addAttribute("reservas", reservas);
    return new ModelAndView("/reservas/fragmentos :: listaReservas");
}
}
