package gesmag.progetto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gesmag.progetto.entities.Movimento;

@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Long> {
	public Movimento findByCodiceMovimento(String codiceMovimento);

	public List<Movimento> findAll();

}
