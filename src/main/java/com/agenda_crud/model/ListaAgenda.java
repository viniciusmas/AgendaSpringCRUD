package com.agenda_crud.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaAgenda {
	
	@XmlElement(name="agenda")
	private List<Agenda> agenda;
	
	ListaAgenda() {		
	}

	public ListaAgenda(List<Agenda> agenda) {
		this.agenda = agenda;
	}

	public List<Agenda> getAgenda() {
		return agenda;
	}
}
