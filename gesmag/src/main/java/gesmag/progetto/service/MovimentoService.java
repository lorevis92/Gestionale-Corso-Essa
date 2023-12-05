package gesmag.progetto.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gesmag.progetto.entities.Movimento;
import gesmag.progetto.entities.Prodotto;
import gesmag.progetto.repositories.MovimentoRepository;

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
        System.out.println("Prodotto: " + movimento.getProdotto());
        System.out.println("id prodotto = " + movimento.getProdotto().getId());

        Optional<Prodotto> optionalProdotto = this.prodottoService.getProdottoById(movimento.getProdotto().getId());

        if (optionalProdotto.isPresent()) {
            Prodotto prodotto = optionalProdotto.get();
            int quantitaMovimentata = movimento.getQuantitaMovimentata();
            int quantitaMagazzino = prodotto.getQuantitaMagazzino();

            if ("A".equals(movimento.getCodiceMovimento())) {
                int quantitaAcquistata = prodotto.getQuantitaAcquistata();
                prodotto.setQuantitaAcquistata(quantitaAcquistata + quantitaMovimentata);
                prodotto.setQuantitaMagazzino(quantitaMagazzino + quantitaMovimentata);
                prodottoService.saveProdotto(prodotto);
            } else if ("V".equals(movimento.getCodiceMovimento())) {
                int quantitaVenduta = prodotto.getQuantitaVenduta();
                prodotto.setQuantitaVenduta(quantitaVenduta + quantitaMovimentata);
                prodotto.setQuantitaMagazzino(quantitaMagazzino - quantitaMovimentata);
                prodottoService.saveProdotto(prodotto);
            }
        } else {
            System.out.println("Prodotto non trovato con ID: " + movimento.getProdotto().getId());
        }
    }

}
