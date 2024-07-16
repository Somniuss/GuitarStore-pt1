package com.somniuss.guitarstore.entity;

import java.util.Objects;

import com.somniuss.guitarstore.util.*;

public class MusicalInstrument {

	private int id;
	private String type;
	private String brand;
	private String model;
	private double price;

	public MusicalInstrument() {
	}

	public MusicalInstrument(int id, String type, String brand, String model, double price) {

		this.id = id;
		this.type = type;
		this.price = price;

	}

	public MusicalInstrument(String type, String brand, String model, double price) {
		this.id = GenerateId.nextId();
		this.type = type;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, id, model, price, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MusicalInstrument other = (MusicalInstrument) obj;
		return Objects.equals(brand, other.brand) && id == other.id && Objects.equals(model, other.model)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "MusicalInstrument [id=" + id + ", type=" + type + ", brand=" + brand + ", model=" + model + ", price="
				+ price + "]";
	}

}
