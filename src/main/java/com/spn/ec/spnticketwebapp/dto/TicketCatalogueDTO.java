package com.spn.ec.spnticketwebapp.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Ticket catalogue entity.
 * 
 * @author SC Daniel Lincango on 15 nov. 2020
 */
@Data
@Entity
@Table(name = "SPNT_TICKETCATALOGUE")
public class TicketCatalogueDTO implements Serializable {

	@JsonIgnore
	private static final long serialVersionUID = 4531983396169510992L;

	@Id
	private String referenceCode;

	private String name;

	private String status;

	private String type;

}
