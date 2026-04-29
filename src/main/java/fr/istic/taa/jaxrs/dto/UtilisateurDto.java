package fr.istic.taa.jaxrs.dto;

import jakarta.ws.rs.core.MultivaluedMap;

/**
 * DTO pour la recherche et sérialisation des utilisateurs
 */
public class UtilisateurDto {
	private String nom;
	private String prenom;
	private String email;

	// Constructeur vide
	public UtilisateurDto() {
	}

	// Constructeur avec MultivaluedMap (depuis QueryParameters)
	public UtilisateurDto(MultivaluedMap<String, String> queryParameters) {
		if (queryParameters != null) {
			this.nom = queryParameters.getFirst("nom");
			this.prenom = queryParameters.getFirst("prenom");
			this.email = queryParameters.getFirst("email");
		}
	}

	// Getters et Setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

