package com.eventoapp.evento.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventoapp.evento.app.models.Evento;
import com.eventoapp.repository.EventoRepository;

@Controller
@EnableJpaRepositories(basePackages = "com.eventoapp.repository.EventoRepository;")
public class EventoController {

	@Autowired
	private  EventoRepository er;
	
	@RequestMapping(value = "/cadastrarEvento", method=RequestMethod.GET)
	public String form() {
		return "Evento/formEvento";
	}
	
	@RequestMapping(value = "/cadastrarEvento", method=RequestMethod.POST)
	public String form(Evento evento) {
		er.save(evento);
		return "redirect:/cadastrarEvento";
	}
	
	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = er.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}
}
