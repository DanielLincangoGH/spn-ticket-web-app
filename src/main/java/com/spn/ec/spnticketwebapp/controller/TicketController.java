package com.spn.ec.spnticketwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spn.ec.spnticketwebapp.dto.TicketCatalogueDTO;
import com.spn.ec.spnticketwebapp.dto.TicketDTO;
import com.spn.ec.spnticketwebapp.request.TicketsTypeRequest;
import com.spn.ec.spnticketwebapp.service.ITicketService;

/**
 * Ticket Rest services controller.
 * 
 * @author SC Daniel Lincango on 15 nov. 2020
 */
@RestController
@RequestMapping("/ticketWs")
public class TicketController {

	@Autowired
	private ITicketService ticketService;

	/**
	 * Find tickets.
	 * 
	 * @author SC Daniel Lincango on 15 nov. 2020
	 * @return List all tickets
	 */
	@PostMapping(value = "/findByState", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TicketDTO>> findByState(@RequestBody TicketsTypeRequest request) {
		return new ResponseEntity<>(this.ticketService.findByState(request.getState()), HttpStatus.OK);
	}

	/**
	 * Find catalogue tickets by type.
	 * 
	 * @author SC Daniel Lincango on 15 nov. 2020
	 * @return List all ticket catalogues
	 */
	@PostMapping(value = "/findCataloguesByType", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TicketCatalogueDTO>> findCataloguesByType(@RequestBody TicketsTypeRequest request) {
		return new ResponseEntity<>(this.ticketService.findTicketCatalogueByType(request.getType()), HttpStatus.OK);
	}

	/**
	 * Save tickets.
	 * 
	 * @author SC Daniel Lincango on 15 nov. 2020
	 * @param ticketDTO Ticket instance.
	 */
	@PostMapping(value = "/saveTicket", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveTicket(@RequestBody TicketDTO ticketDTO) {
		this.ticketService.saveTicket(ticketDTO);
	}

	/**
	 * Delete ticket by id.
	 * 
	 * @author SC Daniel Lincango on 15 nov. 2020
	 * @param id Ticket identifier
	 */
	@DeleteMapping(value = "/deleteTicketById/{id}")
	public void deleteTicketById(@PathVariable Integer id) {
		this.ticketService.deleteTicketById(id);
	}

	/**
	 * Update ticket by id.
	 * 
	 * @author SC Daniel Lincango on 15 nov. 2020
	 * @param ticketDTO Ticket id
	 */
	@PutMapping(value = "/updateTicket", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateTicket(@RequestBody TicketDTO ticketDTO) {
		this.ticketService.updateTicket(ticketDTO);
	}

}
