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

import gesmag.progetto.entities.Movimento;
import gesmag.progetto.service.MovimentoService;

@RestController
@RequestMapping("/api/movimenti")
public class MovimentoController {

	private final MovimentoService movimentoService;

	@Autowired
	public MovimentoController(MovimentoService movimentoService) {
		this.movimentoService = movimentoService;
	}

	@GetMapping
	public ResponseEntity<List<Movimento>> getAllMovimenti() {
		List<Movimento> movimenti = movimentoService.getAllMovimenti();
		return new ResponseEntity<>(movimenti, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Movimento> getMovimentoById(@PathVariable Long id) {
		Optional<Movimento> movimento = movimentoService.getMovimentoById(id);
		return movimento.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<Movimento> saveMovimento(@RequestBody Movimento movimento) {
		Movimento savedMovimento = movimentoService.saveMovimento(movimento);
		return new ResponseEntity<>(savedMovimento, HttpStatus.CREATED);
	}

}
