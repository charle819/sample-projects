package com.exampleZone.SpringMVCJavaBased.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "emp_dump")
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long e_id;

	@NotNull
	@NotEmpty(message="*Name of employee is missing")
	@Column(nullable = false)
	private String e_name;

	@NotNull
	@NotEmpty(message="*Role of Employee is missing")
	@Column(nullable = false)
	private String e_role;

	@NotNull
	@NotEmpty(message="* EmailId of Employee is missing")
	@Email(message="*Invalid EmailId")
	@Column(nullable = false)
	private String e_emailId;

	private long e_contactNo;

	private String e_address;

	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "e_joinDate", nullable = false,updatable=false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate joiningDate;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public long getE_id() {
		return e_id;
	}

	public void setE_id(long e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getE_role() {
		return e_role;
	}

	public void setE_role(String e_role) {
		this.e_role = e_role;
	}

	public String getE_emailId() {
		return e_emailId;
	}

	public void setE_emailId(String e_emailId) {
		this.e_emailId = e_emailId;
	}

	public long getE_contactNo() {
		return e_contactNo;
	}

	public void setE_contactNo(long e_contactNo) {
		this.e_contactNo = e_contactNo;
	}

	public String getE_address() {
		return e_address;
	}

	public void setE_address(String e_address) {
		this.e_address = e_address;
	}

	@PrePersist
	protected void onJoiningDate()
	{
		joiningDate = new LocalDate();
	}
}
