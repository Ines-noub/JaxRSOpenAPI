package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.dao.generic.TicketDao;
import fr.istic.taa.jaxrs.dao.generic.EvenementDao;
import fr.istic.taa.jaxrs.domain.StatutTicketEnum;
import fr.istic.taa.jaxrs.domain.Ticket;

import java.util.List;

public class TicketService {

    private final TicketDao ticketDao;
    private final EvenementDao evenementDao;

    public TicketService() {
        ticketDao = new TicketDao();
        evenementDao = new EvenementDao();
    }

    // 🔹 CREATE
    public Ticket createTicket(Ticket ticket) {

        if (ticket == null || ticket.getEvenement() == null) {
            throw new IllegalArgumentException("Données invalides");
        }

        // 🔥 IMPORTANT : recharger l'événement (JPA)
        if (ticket.getEvenement().getIdEvenement() != null) {
            ticket.setEvenement(
                    evenementDao.findOne(ticket.getEvenement().getIdEvenement())
            );
        }

        ticketDao.save(ticket);
        return ticket;

    }

    // 🔹 READ ALL
    public List<Ticket> getAllTickets() {
        return ticketDao.findAll();
    }

    // 🔹 READ BY ID
    public Ticket getTicketById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID invalide");
        }
        return ticketDao.findOne(id);
    }

    // 🔹 UPDATE
    public Ticket updateTicket(Long id, Ticket ticket) {

        if (id == null || ticket == null) {
            throw new IllegalArgumentException("Données invalides");
        }

        Ticket existing = ticketDao.findOne(id);

        if (existing == null) {
            throw new RuntimeException("Ticket non trouvé");
        }

        ticket.setIdTicket(id);

        return ticketDao.update(ticket);
    }

    // 🔹 DELETE
    public void deleteTicket(Long id) {

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID invalide");
        }

        Ticket ticket = ticketDao.findOne(id);

        if (ticket == null) {
            throw new RuntimeException("Ticket non trouvé");
        }

        ticketDao.delete(ticket);
    }

    // 🔹 MÉTIER

    public List<Ticket> getByStatut(StatutTicketEnum statut) {
        return ticketDao.findByStatut(statut);
    }

    public List<Ticket> getByUtilisateur(Long utilisateurId) {
        return ticketDao.findByUtilisateur(utilisateurId);
    }

    public List<Ticket> getByEvenement(Long evenementId) {
        return ticketDao.findByEvenement(evenementId);
    }

    public Double getChiffreAffaires(Long evenementId) {
        return ticketDao.calculerChiffreAffaires(evenementId);
    }

    public Long getPlacesRestantes(Long evenementId) {
        return ticketDao.countPlacesRestantes(evenementId);
    }
    public Ticket findOne(Long id) {
        return ticketDao.findOne(id);
    }

    public List<Ticket> findAll() {
        return ticketDao.findAll();
    }
    public void delete(Ticket ticket) {
        ticketDao.delete(ticket);
    }
    public List<Ticket> getTicketsByStatut(StatutTicketEnum statut) {
        return ticketDao.findByStatut(statut);
    }
    /**
     * Récupère les tickets d'un utilisateur
     */
    public List<Ticket> getTicketsByUtilisateur(Long utilisateurId) {
        return ticketDao.findByUtilisateur(utilisateurId);
    }
    /**
     * Récupère les tickets d'un événement
     */
    public List<Ticket> getTicketsByEvenement(Long evenementId) {
        return ticketDao.findByEvenement(evenementId);
    }
}