package com.spn.ec.spnticketwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spn.ec.spnticketwebapp.core.ITicketCore;
import com.spn.ec.spnticketwebapp.dto.TicketCatalogueDTO;
import com.spn.ec.spnticketwebapp.dto.TicketDTO;

/**
 * Ticket service Layer.
 * 
 * @author SC Daniel Lincango on 15 nov. 2020
 */
@Service("ticketService")
@Transactional(readOnly = true)
public class TicketService implements ITicketService {

	@Autowired
	private ITicketCore ticketCore;

	/**
	 * @{inheritDoc}
	 */
	@Override
	public List<TicketDTO> findByState(String state) {
		return this.ticketCore.findByState(state);
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	@Transactional
	public void saveTicket(TicketDTO ticketDTO) {
		this.ticketCore.saveTicket(ticketDTO);
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	@Transactional
	public void deleteTicketById(Integer id) {
		this.ticketCore.deleteTicketById(id);
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	@Transactional
	public void updateTicket(TicketDTO ticketDTO) {
		this.ticketCore.updateTicket(ticketDTO);
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public List<TicketCatalogueDTO> findTicketCatalogueByType(String type) {
		return this.ticketCore.findTicketCatalogueByType(type);
	}

}
