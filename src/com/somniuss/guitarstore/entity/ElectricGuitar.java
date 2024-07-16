package com.somniuss.guitarstore.entity;

import java.util.Objects;

public class ElectricGuitar extends MusicalInstrument {

	private String bodyShape;
	private String tremoloSystem;

	public ElectricGuitar() {
	}

	public ElectricGuitar(int id, String type, String brand, String model, double price, String bodyShape, String tremoloSystem) {
        super(id, type, brand, model, price);
        this.bodyShape = bodyShape;
        this.tremoloSystem = tremoloSystem;
    }

    public ElectricGuitar(String type, String brand, String model, double price, String bodyShape, String tremoloSystem) {
        super(type, brand, model, price);
        this.bodyShape = bodyShape;
        this.tremoloSystem = tremoloSystem;
    }

	public String getBodyShape() {
		return bodyShape;
	}

	public void setBodyShape(String bodyShape) {
		this.bodyShape = bodyShape;
	}

	public String getTremoloSystem() {
		return tremoloSystem;
	}

	public void setTremoloSystem(String tremoloSystem) {
		this.tremoloSystem = tremoloSystem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bodyShape, tremoloSystem);
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
		ElectricGuitar other = (ElectricGuitar) obj;
		return Objects.equals(bodyShape, other.bodyShape) && Objects.equals(tremoloSystem, other.tremoloSystem);
	}

	@Override
	public String toString() {
		return "ElectricGuitar [bodyShape=" + bodyShape + ", tremoloSystem=" + tremoloSystem + "]";
	}

}
