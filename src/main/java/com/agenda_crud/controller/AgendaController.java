package com.agenda_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.agenda_crud.model.Agenda;
import com.agenda_crud.service.AgendaService;

@Controller
@RequestMapping(value = "/agenda")
public class AgendaController {

	@Autowired
	AgendaService agendaService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView model = new ModelAndView("agenda/agenda_page");
		List<Agenda> list = agendaService.listarTodosAgenda();
		model.addObject("listarAgenda", list);
		return model;
	}

	@RequestMapping(value = "/adicionar", method = RequestMethod.GET)
	public ModelAndView adicionar() {
		ModelAndView model = new ModelAndView("agenda/agenda_form");
		Agenda agenda = new Agenda();
		model.addObject("agendaForm", agenda);

		return model;
	}

	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.GET)
	public ModelAndView atualizar(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("agenda/agenda_form");
		Agenda agenda = agendaService.procuraAgendaPorId(id);
		model.addObject("agendaForm", agenda);
		return model;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute("agendaForm") Agenda agenda) {
		if (agenda != null && agenda.getId() != null) {
			agendaService.atualizarAgenda(agenda);
		} else {
			agendaService.adicionarAgenda(agenda);
		}

		return new ModelAndView("redirect:/agenda/listar");
	}

	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.GET)
	public ModelAndView deletar(@PathVariable("id") int id) {
		agendaService.deletar(id);

		return new ModelAndView("redirect:/agenda/listar");
	}
}
