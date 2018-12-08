package com.agenda_crud.service;

import java.util.List;

import com.agenda_crud.model.Agenda;

public interface AgendaService {
	
	public List<Agenda> listarTodosAgenda();
	
	public void adicionarAgenda(Agenda agenda);
	
	public void atualizarAgenda(Agenda agenda);
	
	public void deletar(int id);
	
	public Agenda procuraAgendaPorId(int id);

}
