package com.spn.ec.spnticketwebapp.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * User entity.
 * 
 * @author SC Daniel Lincango on 15 nov. 2020
 */
@Data
@Entity
@Table(name = "SPNT_USER")
public class UserDTO implements Serializable {

	private static final long serialVersionUID = -4172019954770333868L;

	@Id
	private String userId;

	private String userName;

	private String mail;

}
