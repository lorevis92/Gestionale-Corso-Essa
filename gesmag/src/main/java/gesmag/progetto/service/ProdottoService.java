package gesmag.progetto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gesmag.progetto.entities.Prodotto;
import gesmag.progetto.repositories.ProdottoRepository;

@Service
public class ProdottoService {

	private final ProdottoRepository prodottoRepository;

	@Autowired
	public ProdottoService(ProdottoRepository prodottoRepository) {
		this.prodottoRepository = prodottoRepository;
	}

	public Prodotto saveProdotto(Prodotto prodotto) {
		return prodottoRepository.save(prodotto);
	}

	public List<Prodotto> getAllProdotti() {
		return prodottoRepository.findAll();
	}

	public Optional<Prodotto> getProdottoById(Long id) {
		return prodottoRepository.findById(id);
	}

	public Optional<Prodotto> getProdottoByCodice(String codice) {
		return Optional.of(prodottoRepository.findByCodice(codice));
	}

}

