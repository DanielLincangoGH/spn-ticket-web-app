package com.spn.ec.spnticketwebapp.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spn.ec.spnticketwebapp.dao.ITicketDAO;
import com.spn.ec.spnticketwebapp.dto.TicketCatalogueDTO;
import com.spn.ec.spnticketwebapp.dto.TicketDTO;

/**
 * Ticket business Layer.
 * 
 * @author SC Daniel Lincango on 15 nov. 2020
 */
@Component("ticketCore")
public class TicketCore implements ITicketCore {

	@Autowired
	private ITicketDAO ticketDAO;

	/**
	 * @{inheritDoc}
	 */
	@Override
	public List<TicketDTO> findByState(String state) {
		return this.ticketDAO.findByState(state);
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public void saveTicket(TicketDTO ticketDTO) {
		this.ticketDAO.saveTicket(ticketDTO);
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public void deleteTicketById(Integer id) {
		this.ticketDAO.deleteTicketById(id);
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public void updateTicket(TicketDTO ticketDTO) {
		this.ticketDAO.updateTicket(ticketDTO);
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public List<TicketCatalogueDTO> findTicketCatalogueByType(String type) {
		return this.ticketDAO.findTicketCatalogueByType(type);
	}

}
