package com.inventory.inventoryproject.items;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Items {

	@Id
	@SequenceGenerator(name = "item_sequence", sequenceName = "item_sequence", allocationSize = 1)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "item_sequence")
	private Long id;
	private String name;
	private String location;
	private Integer quantity;

	public Items() {

	}

	public Items(Long id, String name, String location, Integer quantity) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.quantity = quantity;
	}

	public Items(String name, String location, Integer quantity) {
		this.name = name;
		this.location = location;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public Items setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Items setName(String name) {
		this.name = name;
		return this;
	}

	public String getLocation() {
		return location;
	}

	public Items setLocation(String location) {
		this.location = location;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Items setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	@Override
	public String toString() {
		return "Items{" +
				"id=" + id +
				", name='" + name + '\'' +
				", location='" + location + '\'' +
				", quantity=" + quantity +
				'}';
	}
}
