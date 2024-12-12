/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiendaAllanAzofeifa.demo.controller;

import TiendaAllanAzofeifa.demo.Service.EventosService;
import TiendaAllanAzofeifa.demo.domain.Eventos;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/eventos")
public class EventosController {

    @Autowired
    private EventosService eventosService;

    @GetMapping("/listado")
    public String listarEventos(Model model) {
        List<Eventos> eventos = eventosService.getEventos();
        model.addAttribute("eventos", eventos);
        return "/eventos/listado";
    }

    @PostMapping("/guardar")
    public String guardarEvento(Eventos eventos) {
        eventosService.save(eventos);
        return "redirect:/eventos/listado";
    }

    @PostMapping("/queryFecha")
    public String consultaQueryFecha(@RequestParam(value = "fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam(value = "fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            Model model) {
        var eventos = eventosService.buscarEventosPorFechaNativo(fechaInicio, fechaFin);
        model.addAttribute("eventos", eventos);
        model.addAttribute("totalEventos", eventos.size());
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        return "/eventos/listado";
    }

    @PostMapping("/queryTipoFecha")
    public String consultaQueryTipoFecha(@RequestParam(value = "tipo") String tipo,
            @RequestParam(value = "fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam(value = "fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            Model model) {
        var eventos = eventosService.buscarEventosNativo(tipo, fechaInicio, fechaFin);
        model.addAttribute("eventos", eventos);
        model.addAttribute("totalEventos", eventos.size());
        model.addAttribute("tipo", tipo);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        return "/eventos/listado";
    }

}
