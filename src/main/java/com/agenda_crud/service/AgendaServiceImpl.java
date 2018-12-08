package com.agenda_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda_crud.dao.AgendaDAO;
import com.agenda_crud.model.Agenda;

@Service
public class AgendaServiceImpl implements AgendaService{
	
	AgendaDAO agendaDAO;
	
	@Autowired
	public void setAgendaDAO(AgendaDAO agendaDAO) {
		this.agendaDAO = agendaDAO;
	}

	public List<Agenda> listarTodosAgenda() {
		return agendaDAO.listarTodosAgenda();
	}

	public void adicionarAgenda(Agenda agenda) {
		agendaDAO.adicionarAgenda(agenda);
	}

	public void atualizarAgenda(Agenda agenda) {
		agendaDAO.atualizarAgenda(agenda);
	}

	public void deletar(int id) {
		agendaDAO.deletar(id);
	}

	public Agenda procuraAgendaPorId(int id) {
		return agendaDAO.procuraAgendaPorId(id);
	}

}
