package gesmag.progetto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Movimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codice_movimento;
	private String data_ora_movimento;
	private String nome_cliente;
	@ManyToOne
	private Prodotto prodotto_id;
	private double prezzo;
	private int quantita_movimentata;

	public double getTotale() {
		return (this.prezzo * this.quantita_movimentata);
	}

}