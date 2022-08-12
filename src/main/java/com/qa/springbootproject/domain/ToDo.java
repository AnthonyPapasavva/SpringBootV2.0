package com.qa.springbootproject.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table
public class ToDo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long toDoId;

	@Column(nullable = false)
	@Size(min = 1, max = 40)
	private String toDoTitle;

	@Column(nullable = false)
	@Size(min = 1, max = 140)
	private String toDoItem;

	@Column(nullable = false)
	private Boolean toDoComplete;

	public ToDo() {
	}

	public ToDo(String toDoTitle, String toDoItem, Boolean toDoComplete) {
		this.toDoTitle = toDoTitle;
		this.toDoItem = toDoItem;
		this.toDoComplete = toDoComplete;
	}

	public ToDo(Long toDoId, String toDoTitle, String toDoItem, Boolean toDoComplete) {
		this.toDoId = toDoId;
		this.toDoTitle = toDoTitle;
		this.toDoItem = toDoItem;
		this.toDoComplete = toDoComplete;
	}

	public Long getToDoId() {
		return toDoId;
	}

	public void setToDoId(Long toDoId) {
		this.toDoId = toDoId;
	}

	public String getToDoTitle() {
		return toDoTitle;
	}

	public void setToDoTitle(String toDoTitle) {
		this.toDoTitle = toDoTitle;
	}

	public String getToDoItem() {
		return toDoItem;
	}

	public void setToDoItem(String toDoItem) {
		this.toDoItem = toDoItem;
	}

	public Boolean getToDoComplete() {
		return toDoComplete;
	}

	public void setToDoComplete(Boolean toDoComplete) {
		this.toDoComplete = toDoComplete;
	}

	@Override
	public int hashCode() {
		return Objects.hash(toDoComplete, toDoItem, toDoTitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDo other = (ToDo) obj;
		return Objects.equals(toDoComplete, other.toDoComplete) && Objects.equals(toDoItem, other.toDoItem)
				&& Objects.equals(toDoTitle, other.toDoTitle);
	}

	@Override
	public String toString() {
		return "ToDo [toDoId=" + toDoId + ", toDoTitle=" + toDoTitle + ", toDoItem=" + toDoItem + ", toDoComplete="
				+ toDoComplete + "]";
	}

}
