package gesmag.progetto.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gesmag.progetto.entities.Prodotto;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {

	public Prodotto findByCodice(long id);

	public List<Prodotto> findAll();
}
