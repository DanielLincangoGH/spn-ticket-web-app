package com.spn.ec.spnticketwebapp.service;

import java.util.List;

import com.spn.ec.spnticketwebapp.dto.TicketCatalogueDTO;
import com.spn.ec.spnticketwebapp.dto.TicketDTO;

/**
 * Ticket service Layer.
 * 
 * @author SC Daniel Lincango on 15 nov. 2020
 */
public interface ITicketService {

	/**
	 * Find all registered tickets.
	 * 
	 * @author SC Daniel Lincango on 15 nov. 2020
	 * @param state Ticket state
	 * @return List all tickets
	 */
	List<TicketDTO> findByState(String state);

	/**
	 * Save ticket.
	 * 
	 * @author SC Daniel Lincango on 15 nov. 2020
	 * @param ticketDTO Ticket to save
	 */
	void saveTicket(TicketDTO ticketDTO);

	/**
	 * Delete ticket by id.
	 * 
	 * @author SC Daniel Lincango on 15 nov. 2020
	 * @param id Ticket identifier
	 */
	void deleteTicketById(Integer id);

	/**
	 * Update ticket.
	 * 
	 * @author SC Daniel Lincango on 15 nov. 2020
	 * @param ticketDTO Ticket instance
	 */
	void updateTicket(TicketDTO ticketDTO);

	/**
	 * Find ticket catalogue by type.
	 * 
	 * @author SC Daniel Lincango on 15 nov. 2020
	 * @param type Type catalogue
	 * @return List tickets catalogue
	 */
	List<TicketCatalogueDTO> findTicketCatalogueByType(String type);

}
