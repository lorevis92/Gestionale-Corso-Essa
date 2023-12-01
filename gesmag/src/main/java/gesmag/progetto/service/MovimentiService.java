package gesmag.progetto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gesmag.progetto.repositories.MovimentoRepository;

@Service
public class MovimentiService {

	@Autowired
	MovimentoRepository movimentoRepository;
}
