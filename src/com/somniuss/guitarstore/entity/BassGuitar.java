package com.somniuss.guitarstore.entity;

import java.util.Objects;

public class BassGuitar extends MusicalInstrument {

	private String electronics;

	public BassGuitar() {
	}

	 public BassGuitar(int id, String type, String brand, String model, double price, String electronics) {
	        super(id, type, brand, model, price);
	        this.electronics = electronics;
	    }

	    public BassGuitar(String type, String brand, String model, double price, String electronics) {
	        super(type, brand, model, price);
	        this.electronics = electronics;
	    }

	public String getElectronics() {
		return electronics;
	}

	public void setElectronics(String electronics) {
		this.electronics = electronics;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(electronics);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BassGuitar other = (BassGuitar) obj;
		return Objects.equals(electronics, other.electronics);
	}

	@Override
	public String toString() {
		return "BassGuitar [electronics=" + electronics + "]";
	}

}
