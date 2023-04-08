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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    private BCryptPasswordEncoder encoder;
    public void instaciaDB(){
        Tecnico t1 = new Tecnico(null, "Kaio Andrade", "457.895.102-02","kaio@mail.com", encoder.encode("123"));
        Tecnico t2 = new Tecnico(null, "Luan Rollemberg", "757.895.102-02","luan@mail.com", encoder.encode("123"));
        Tecnico t3 = new Tecnico(null, "Anaison Kemmyt", "857.995.522-10","anailson@mail.com", encoder.encode("123"));
        t1.addPerfis(Perfil.ADMIN);
        t2.addPerfis(Perfil.ADMIN);
        t3.addPerfis(Perfil.ADMIN);

        Cliente c1 = new Cliente(null, "Linus Garcia", "997.995.522-10", "linux@gmail.com", encoder.encode("123"));
        Cliente c2 = new Cliente(null, "Thassio Valdson", "888.910.522-10", "Thassio@gmail.com", encoder.encode("123"));
        Cliente c3 = new Cliente(null, "Dijenal Giba Jr", "867.910.110-10", "Dijenal@gmail.com", encoder.encode("123"));

        Chamado g1 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Chamado 01",
                "primeiro chamado", t1, c1);

        Chamado g2 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Trocar a memoria ram", "Troca a memoria do notebook", t1, c1);
        Chamado g3 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Meu pc nao liga", "Meu pc nao liga",  t1, c1);
        Chamado g4 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Meu celular ta quebrado", "Teste chamado 3",  t1, c1);
        Chamado g5 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Tela azul", "Teste chamado 4",  t1, c1);
        Chamado g6 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Celular entortou", "Teste chamado 5",  t1, c1);



        tecnicoRepository.saveAll(Arrays.asList(t1));
        tecnicoRepository.saveAll(Arrays.asList(t2));
        tecnicoRepository.saveAll(Arrays.asList(t3));

        clienteRepository.saveAll(Arrays.asList(c1));
        clienteRepository.saveAll(Arrays.asList(c2));
        clienteRepository.saveAll(Arrays.asList(c3));

        chamadoRepository.saveAll(Arrays.asList(g1));
        chamadoRepository.saveAll(Arrays.asList(g2));
        chamadoRepository.saveAll(Arrays.asList(g3));
        chamadoRepository.saveAll(Arrays.asList(g4));
        chamadoRepository.saveAll(Arrays.asList(g5));
        chamadoRepository.saveAll(Arrays.asList(g6));
    }
}
