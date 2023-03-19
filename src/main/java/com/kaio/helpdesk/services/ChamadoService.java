package com.kaio.helpdesk.services;

import com.kaio.helpdesk.domain.Chamado;
import com.kaio.helpdesk.domain.Cliente;
import com.kaio.helpdesk.domain.Tecnico;
import com.kaio.helpdesk.domain.enums.Prioridade;
import com.kaio.helpdesk.domain.enums.Status;
import com.kaio.helpdesk.dtos.ChamadoDTO;
import com.kaio.helpdesk.repositories.ChamadoRepository;
import com.kaio.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private ClienteService clienteService;

    public Chamado findById(Integer id){
        Optional<Chamado> obj = chamadoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));

    }

    public List<Chamado> findAll() {
        return chamadoRepository.findAll();
    }

    public Chamado create(ChamadoDTO objDTO) throws IllegalAccessException {
        return chamadoRepository.save(newChamado(objDTO));

    }

    public Chamado update(Integer id, ChamadoDTO objDTO) throws IllegalAccessException {
        objDTO.setId(id);
        Chamado oldObj = findById(id);
        oldObj = newChamado(objDTO);
        return chamadoRepository.save(oldObj);

    }

    private Chamado newChamado(ChamadoDTO obj) throws IllegalAccessException {
        Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
        Cliente cliente = clienteService.findById(obj.getCliente());

        Chamado chamado = new Chamado();
        if(obj.getId() != null){
            chamado.setId(obj.getId());
        }

        if(obj.getStatus().equals(2)){
            chamado.setDataFechamento(LocalDate.now());
        }

        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        chamado.setStatus(Status.toEnum(obj.getStatus()));
        chamado.setTitulo(obj.getTitulo());
        chamado.setObservacoes(obj.getObservacoes());
        return chamado;
    }
}
