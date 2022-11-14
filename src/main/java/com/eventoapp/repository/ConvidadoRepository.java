package com.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.eventoapp.evento.app.models.Convidado;
import com.eventoapp.evento.app.models.Evento;
@Component
public interface ConvidadoRepository extends CrudRepository<Convidado, String> {

	Iterable<Convidado> findByEvento(Evento evento);
}
