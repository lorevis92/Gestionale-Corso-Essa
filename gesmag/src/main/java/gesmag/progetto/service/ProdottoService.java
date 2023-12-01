package gesmag.progetto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gesmag.progetto.entities.Prodotto;
import gesmag.progetto.repositories.ProdottoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProdottoService {

	@Autowired
	private ProdottoRepository prodottoRepository;
	
	public Prodotto creaProdotto(String codice, String descrizione,String um, double prezzo, double prezzo_acquisto, int quantita_in_giacenza, int quantita_venduta, int quantita_da_acquistare) {
		Prodotto nuovo_prodotto = new Prodotto(null, codice, descrizione, um, prezzo, prezzo_acquisto,
				quantita_in_giacenza, quantita_venduta, quantita_da_acquistare);
		return prodottoRepository.save(nuovo_prodotto);		
	}

}
