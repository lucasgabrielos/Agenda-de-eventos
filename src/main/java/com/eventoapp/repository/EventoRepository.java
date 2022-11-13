package com.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.eventoapp.evento.app.models.Evento;
@Component
public interface EventoRepository extends CrudRepository<Evento, String> {

}
