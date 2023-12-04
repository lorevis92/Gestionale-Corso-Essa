package gesmag.progetto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gesmag.progetto.entities.Prodotto;
import gesmag.progetto.service.ProdottoService;

@RestController
@RequestMapping("/api/prodotti")
public class ProdottoController {

	private final ProdottoService prodottoService;

	@Autowired
	public ProdottoController(ProdottoService prodottoService) {
		this.prodottoService = prodottoService;
	}

	@GetMapping
	public ResponseEntity<List<Prodotto>> getAllProdotti() {
		List<Prodotto> prodotti = prodottoService.getAllProdotti();
		return new ResponseEntity<>(prodotti, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Prodotto> getProdottoById(@PathVariable Long id) {
		Optional<Prodotto> prodotto = prodottoService.getProdottoById(id);
		return prodotto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<Prodotto> saveProdotto(@RequestBody Prodotto prodotto) {
		Prodotto savedProdotto = prodottoService.saveProdotto(prodotto);
		return new ResponseEntity<>(savedProdotto, HttpStatus.CREATED);
	}

}
