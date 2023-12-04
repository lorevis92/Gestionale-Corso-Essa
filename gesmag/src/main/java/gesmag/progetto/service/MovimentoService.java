package gesmag.progetto.service;


import gesmag.progetto.entities.Movimento;
import gesmag.progetto.entities.Prodotto;
import gesmag.progetto.repositories.MovimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentoService {

    private final MovimentoRepository movimentoRepository;
    private final ProdottoService prodottoService;

    @Autowired
    public MovimentoService(MovimentoRepository movimentoRepository, ProdottoService prodottoService) {
        this.movimentoRepository = movimentoRepository;
        this.prodottoService = prodottoService;
    }

    public Movimento saveMovimento(Movimento movimento) {
        // Aggiorna la quantità in giacenza del prodotto in base al tipo di movimento
        updateQuantities(movimento);
        return movimentoRepository.save(movimento);
    }

    public List<Movimento> getAllMovimenti() {
        return movimentoRepository.findAll();
    }

    public Optional<Movimento> getMovimentoById(Long id) {
        return movimentoRepository.findById(id);
    }

    private void updateQuantities(Movimento movimento) {
        Prodotto prodotto = movimento.getProdotto();
        int quantitaMovimentata = movimento.getQuantita_movimentata();

        if ("A".equals(movimento.getCodiceMovimento())) { // Acquisto
            prodotto.setQuantita_in_giacenza(prodotto.getQuantita_in_giacenza() + quantitaMovimentata);
            prodottoService.saveProdotto(prodotto);
        } else if ("V".equals(movimento.getCodiceMovimento())) { // Vendita
            prodotto.setQuantita_venduta(prodotto.getQuantita_venduta() + quantitaMovimentata);
            prodotto.setQuantita_in_giacenza(prodotto.getQuantita_in_giacenza() - quantitaMovimentata);
            prodottoService.saveProdotto(prodotto);
        }
    }
}
