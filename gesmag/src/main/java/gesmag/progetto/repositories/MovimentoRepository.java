package gesmag.progetto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gesmag.progetto.entities.Movimento;

@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Long> {
	public Movimento findByCodice_movimento(String codice_movimento);

	public List<Movimento> findAll();

	public List<Movimento> findByNome_cliente(String nome_cliente);
}
