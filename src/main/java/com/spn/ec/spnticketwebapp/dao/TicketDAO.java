package com.spn.ec.spnticketwebapp.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spn.ec.spnticketwebapp.dto.TicketCatalogueDTO;
import com.spn.ec.spnticketwebapp.dto.TicketDTO;

/**
 * Ticket data access Layer.
 * 
 * @author SC Daniel Lincango on 15 nov. 2020
 */
@Repository("ticketDAO")
public class TicketDAO implements ITicketDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @{inheritDoc}
	 */
	@Override
	public List<TicketDTO> findByState(String state) {
		Session session = this.sessionFactory.getCurrentSession();
		session.clear();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<TicketDTO> query = builder.createQuery(TicketDTO.class);
		Root<TicketDTO> root = query.from(TicketDTO.class);
		if (state == null) {
			query.select(root);
		} else {
			query.select(root).where(builder.equal(root.get("ticketState"), state));
		}
		return session.createQuery(query).getResultList();
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public void saveTicket(TicketDTO ticketDTO) {
		this.sessionFactory.getCurrentSession().save(ticketDTO);
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public void deleteTicketById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(session.load(TicketDTO.class, id));
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public void updateTicket(TicketDTO ticketDTO) {
		this.sessionFactory.getCurrentSession().update(ticketDTO);
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public List<TicketCatalogueDTO> findTicketCatalogueByType(String type) {
		Session session = this.sessionFactory.getCurrentSession();
		session.clear();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<TicketCatalogueDTO> query = builder.createQuery(TicketCatalogueDTO.class);
		Root<TicketCatalogueDTO> root = query.from(TicketCatalogueDTO.class);
		if (type == null) {
			query.select(root);
		} else {
			query.select(root).where(builder.equal(root.get("type"), type));
		}
		return session.createQuery(query).getResultList();
	}

}
