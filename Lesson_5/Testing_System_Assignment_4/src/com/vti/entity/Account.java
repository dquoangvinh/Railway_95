package com.vti.entity;

import java.time.LocalDate;

public class Account {
	private int id;
	private String email;
	private String username;
	private String fullName;
	private Department department;
	private Position position;
	private LocalDate createDate;
	private Group[] groups;

	// Constructor không có parameters
	public Account() {
	}

	// Constructor với id, email, username, firstName, lastName
	public Account(int id, String email, String username, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = firstName + " " + lastName;
	}

	// Constructor với thêm Position, default createDate = now
	public Account(int id, String email, String username, String firstName, String lastName, Position position) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = LocalDate.now();
	}

	// Constructor với thêm Position và createDate
	public Account(int id, String email, String username, String firstName, String lastName, Position position, LocalDate createDate) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = createDate;
	}

	// Constructor gốc
	public Account(int id, String email, String username, String fullName, Department department, Position position,
			LocalDate createDate) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = fullName;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Group[] getGroups() {
		return groups;
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "Account{id=" + id + ", email='" + email + "', userName='" + username + "', fullName='" + fullName
				+ "', department=" + department.getName() + ", position=" + position.getName() + ", createDate="
				+ createDate + "}";
	}

}
