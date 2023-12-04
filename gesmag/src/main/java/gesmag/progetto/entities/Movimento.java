package gesmag.progetto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	private String codiceMovimento;
	private String data_ora_movimento;
	private String nome_cliente;
	@ManyToOne
	@JoinColumn(name = "prodotto_id")
	private Prodotto prodotto;
	private double prezzo;
	private int quantita_movimentata;

	public double getTotale() {
		return (this.prezzo * this.quantita_movimentata);
	}

}