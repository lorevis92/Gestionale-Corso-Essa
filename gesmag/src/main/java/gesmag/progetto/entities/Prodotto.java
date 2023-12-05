package gesmag.progetto.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nomeProdotto;
	private String codiceProdotto;
    private String descrizione;
    private String um;
    private double prezzo;
	private double prezzoAcquisto;
	private int quantitaMagazzino;
	private int quantitaVenduta;
	private int quantitaAcquistata;
	@JsonIgnore
	@OneToMany(mappedBy = "prodotto", cascade = CascadeType.ALL)
	private List<Movimento> movimenti;
}
    
