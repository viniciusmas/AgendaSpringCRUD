package com.agenda_crud.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.agenda_crud.model.Agenda;
import com.agenda_crud.model.ListaAgenda;

@WebService
public interface AgendaWS {
	
	 @WebMethod public ListaAgenda listarTodosAgenda();
	
	 @WebMethod public void adicionarAgenda(Agenda agenda);
	
	 @WebMethod public void atualizarAgenda(Agenda agenda);
	
	 @WebMethod public void deletar(int id);
	
	 @WebMethod public Agenda procuraAgendaPorId(int id);

}
