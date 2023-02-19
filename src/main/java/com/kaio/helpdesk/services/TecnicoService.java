package com.kaio.helpdesk.services;

import com.kaio.helpdesk.domain.Tecnico;
import com.kaio.helpdesk.repositories.TecnicoRepository;
import com.kaio.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id));
    }


}
