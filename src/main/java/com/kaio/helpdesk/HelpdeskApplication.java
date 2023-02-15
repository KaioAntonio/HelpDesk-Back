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
public class HelpdeskApplication{

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

}
