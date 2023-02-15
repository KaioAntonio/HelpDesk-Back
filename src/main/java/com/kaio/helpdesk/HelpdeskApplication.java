package com.kaio.helpdesk;

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
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Tecnico t1 = new Tecnico(null, "Kaio", "1234578901","kaio@mail.com", "123");
		t1.addPerfis(Perfil.ADMIN);

		Cliente c1 = new Cliente(null, "Linux Valdson", "1241231240", "linux@gmail.com", "123");

		Chamado g1 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Chamado 01",
				"primeiro chamado", t1, c1);

		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		chamadoRepository.saveAll(Arrays.asList(g1));
	}
}
