package com.agenda_crud.dao;

import java.util.List;

import com.agenda_crud.model.Agenda;

public interface AgendaDAO {
	
	public List<Agenda> listarTodosAgenda();
	
	public void adicionarAgenda(Agenda agenda);
	
	public void atualizarAgenda(Agenda agenda);
	
	public void deletar(int id);
	
	public Agenda procuraAgendaPorId(int id);
	

}
