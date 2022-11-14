package com.eventoapp.evento.app.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventoapp.evento.app.models.Convidado;
import com.eventoapp.evento.app.models.Evento;
import com.eventoapp.repository.ConvidadoRepository;
import com.eventoapp.repository.EventoRepository;

@Controller
@EnableJpaRepositories(basePackages = "com.eventoapp.repository.EventoRepository;")
public class EventoController {

	@Autowired
	private  EventoRepository er;
	
	@Autowired
	private  ConvidadoRepository cr;
	
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
	
	@RequestMapping(value = "/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo) {
		Evento evento = er.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("Evento/detalhesEvento");
		mv.addObject("evento", evento);
		Iterable<Convidado> convidados = cr.findByEvento(evento);
		mv.addObject("convidados", convidados);
		return mv;
	}
	
	@RequestMapping(value = "/{codigo}", method=RequestMethod.POST)
	public String detalhesEventoPost(@PathVariable("codigo") long codigo, @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem","Verifique os campos !");
			return "redirect:/{codigo}";
		}
		Evento evento = er.findByCodigo(codigo);
		convidado.setEvento(evento);
		cr.save(convidado);
		attributes.addFlashAttribute("mensagem","Convidado adicionado com sucesso!");
		return "redirect:/{codigo}";
	}
}
