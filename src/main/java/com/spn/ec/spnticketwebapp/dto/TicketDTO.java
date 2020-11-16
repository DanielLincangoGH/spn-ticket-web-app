package com.spn.ec.spnticketwebapp.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "SPNT_TICKETS")
public class TicketDTO implements Serializable {

	@JsonIgnore
	private static final long serialVersionUID = 1183957164775182323L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "SPNS_TICKET", allocationSize = 1)
	private Integer ticketId;

	private String referenceCode;

	private String description;

	private String ticketState;

	private String userId;

	private String ticketPriority;

	private String ticketDealType;

	private Date dueDate;

	private String status;

	@ManyToOne
	@JoinColumn(name = "TICKETSTATE", referencedColumnName = "REFERENCECODE", insertable = false, updatable = false)
	private TicketCatalogueDTO ticketStateDTO;

	@ManyToOne
	@JoinColumn(name = "TICKETPRIORITY", referencedColumnName = "REFERENCECODE", insertable = false, updatable = false)
	private TicketCatalogueDTO ticketPriorityDTO;

	@ManyToOne
	@JoinColumn(name = "TICKETDEALTYPE", referencedColumnName = "REFERENCECODE", insertable = false, updatable = false)
	private TicketCatalogueDTO ticketDealDTO;
	
	@ManyToOne
	@JoinColumn(name = "USERID", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDTO userDTO;

}
