package com.spn.ec.spnticketwebapp;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spn.ec.spnticketwebapp.dto.TicketDTO;
import com.spn.ec.spnticketwebapp.service.ITicketService;

@SpringBootTest
class SpnTicketWebAppApplicationTests {

	private final Logger logger = LoggerFactory.getLogger(SpnTicketWebAppApplicationTests.class);

	@Autowired
	private ITicketService ticketService;

	@Test
	void findTickets() {

		try {

			List<TicketDTO> tickets = this.ticketService.findByState("OPN");

			if (tickets != null) {
				tickets.forEach(tic -> this.logger.info("{}", tic));
			}

		} catch (Exception e) {
			this.logger.error("Error {}", e);
		}
	}

}
