package com.eventoapp.evento.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;






@Entity
public class Convidado {
		@Id
		@Column(name = "rg", nullable=false)
		private String rg;
		@Column(name = "nomeConvidado", nullable=false)
		private String nomeConvidado;
		
		@ManyToOne
		private Evento evento;
		
		public Evento getEvento() {
			return evento;
		}
		public void setEvento(Evento evento) {
			this.evento = evento;
		}
		public String getRg() {
			return rg;
		}
		public void setRg(String rg) {
			this.rg = rg;
		}
		public String getNomeConvidado() {
			return nomeConvidado;
		}
		public void setNomeConvidado(String nomeConvidado) {
			this.nomeConvidado = nomeConvidado;
		}
}
