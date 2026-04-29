package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
@NamedQuery(name = "Ticket.findByStatut", query = "SELECT t FROM Ticket t WHERE t.statut = :statut")
@NamedQuery(name = "Ticket.findByUtilisateur", query = "SELECT t FROM Ticket t WHERE t.utilisateur.idPersonne = :utilisateurId")
public class Ticket implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTicket;
	private String numeroPlace;

	@Enumerated(EnumType.STRING)
	private StatutTicketEnum statut;

	private Double prixUnitaire;
	private LocalDateTime dateAchat;
	private LocalDateTime dateAnnulation;
	private LocalDateTime dateRemboursement;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "evenement_id")
	private Evenement evenement;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;

	public Ticket() {}

	public Ticket(String numeroPlace, Double prixUnitaire, Evenement evenement) {
		this.numeroPlace = numeroPlace;
		this.prixUnitaire = prixUnitaire;
		this.evenement = evenement;
	}

	public Long getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(Long idTicket) {
		this.idTicket = idTicket;
	}

	public LocalDateTime getDateRemboursement() {
		return dateRemboursement;
	}

	public void setDateRemboursement(LocalDateTime dateRemboursement) {
		this.dateRemboursement = dateRemboursement;
	}

	public LocalDateTime getDateAnnulation() {
		return dateAnnulation;
	}

	public void setDateAnnulation(LocalDateTime dateAnnulation) {
		this.dateAnnulation = dateAnnulation;
	}

	public LocalDateTime getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(LocalDateTime dateAchat) {
		this.dateAchat = dateAchat;
	}

	public Double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public StatutTicketEnum getStatut() {
		return statut;
	}

	public void setStatut(StatutTicketEnum statut) {
		this.statut = statut;
	}

	public String getNumeroPlace() {
		return numeroPlace;
	}

	public void setNumeroPlace(String numeroPlace) {
		this.numeroPlace = numeroPlace;
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Ticket{" +
				"ticketId=" + idTicket +
				", numeroPlace='" + numeroPlace + '\'' +
				", statut=" + statut +
				", prixUnitaire=" + prixUnitaire +
				", dateAchat=" + dateAchat +
				", dateAnnulation=" + dateAnnulation +
				", dateRemboursement=" + dateRemboursement +
				'}';
	}
}