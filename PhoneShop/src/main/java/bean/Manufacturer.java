package bean;

import bean.enams.ManufacturerEnam;

public class Manufacturer {
	private int manufacturerId;
	private ManufacturerEnam nameManufacturer;

	public Manufacturer() {
		super();
	}

	public Manufacturer(ManufacturerEnam nameManufacturer) {
		super();
		this.nameManufacturer = nameManufacturer;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public ManufacturerEnam getNameManufacturer() {
		return nameManufacturer;
	}

	public void setNameManufacturer(ManufacturerEnam nameManufacturer) {
		this.nameManufacturer = nameManufacturer;
	}

	@Override
	public String toString() {
		return "Manufacturer [manufacturerId=" + manufacturerId
				+ ", nameManufacturer=" + nameManufacturer + "]";
	}
}
