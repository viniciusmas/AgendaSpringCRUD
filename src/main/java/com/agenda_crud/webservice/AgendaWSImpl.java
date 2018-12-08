package com.agenda_crud.webservice;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.agenda_crud.model.Agenda;
import com.agenda_crud.model.ListaAgenda;
import com.agenda_crud.service.AgendaService;

@WebService(serviceName = "AgendaWS")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public class AgendaWSImpl extends SpringBeanAutowiringSupport implements AgendaWS {

	@Autowired(required=true)
	AgendaService agendaService;

	public ListaAgenda listarTodosAgenda() {
		List<Agenda> list = agendaService.listarTodosAgenda();
		return new ListaAgenda(list);
	}

	public void adicionarAgenda(Agenda agenda) {
		if (agenda != null && agenda.getId() != null) {
			agendaService.atualizarAgenda(agenda);
		} else {
			agendaService.adicionarAgenda(agenda);
		}
	}

	public void atualizarAgenda(Agenda agenda) {
		agendaService.atualizarAgenda(agenda);
	}

	public void deletar(int id) {
		agendaService.deletar(id);
	}

	public Agenda procuraAgendaPorId(int id) {
		Agenda agenda = agendaService.procuraAgendaPorId(id);
		return agenda;
	}
}
