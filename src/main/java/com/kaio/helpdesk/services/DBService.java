package com.kaio.helpdesk.services;

import com.kaio.helpdesk.domain.Chamado;
import com.kaio.helpdesk.domain.Cliente;
import com.kaio.helpdesk.domain.Tecnico;
import com.kaio.helpdesk.domain.enums.Perfil;
import com.kaio.helpdesk.domain.enums.Prioridade;
import com.kaio.helpdesk.domain.enums.Status;
import com.kaio.helpdesk.repositories.ChamadoRepository;
import com.kaio.helpdesk.repositories.ClienteRepository;
import com.kaio.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;
    public void instaciaDB(){
        Tecnico t1 = new Tecnico(null, "Kaio", "1234578901","kaio@mail.com", "123");
        t1.addPerfis(Perfil.ADMIN);

        Cliente c1 = new Cliente(null, "Linux Valdson", "1241231240", "linux@gmail.com", "123");

        Chamado g1 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Chamado 01",
                "primeiro chamado", t1, c1);

        Chamado g2 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Teste chamado 1", t1, c1);
        Chamado g3 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2",  t1, c1);
        Chamado g4 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3",  t1, c1);
        Chamado g5 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Teste chamado 4",  t1, c1);
        Chamado g6 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5",  t1, c1);



        tecnicoRepository.saveAll(Arrays.asList(t1));
        clienteRepository.saveAll(Arrays.asList(c1));
        chamadoRepository.saveAll(Arrays.asList(g1));
        chamadoRepository.saveAll(Arrays.asList(g2));
        chamadoRepository.saveAll(Arrays.asList(g3));
        chamadoRepository.saveAll(Arrays.asList(g4));
        chamadoRepository.saveAll(Arrays.asList(g5));
        chamadoRepository.saveAll(Arrays.asList(g6));
    }
}
