package HomeTaskObjects5;

public class House {
	private int id;
	private int flatNumber;
	private int square;
	private int floar;
	private int roomCounter;
	private String street;
	private String typeBuild;
	private int lifetimeBuild;

	public House(int id, int flatNumber, int square, int floar,
			int roomCounter, String street, String typeBuild, int lifetimeBuild) {
		super();
		this.id = id;
		this.flatNumber = flatNumber;
		this.square = square;
		this.floar = floar;
		this.roomCounter = roomCounter;
		this.street = street;
		this.typeBuild = typeBuild;
		this.lifetimeBuild = lifetimeBuild;
	}

	public House() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}

	public int getSquare() {
		return square;
	}

	public void setSquare(int square) {
		this.square = square;
	}

	public int getFloar() {
		return floar;
	}

	public void setFloar(int floar) {
		this.floar = floar;
	}

	public int getRoomCounter() {
		return roomCounter;
	}

	public void setRoomCounter(int roomCounter) {
		this.roomCounter = roomCounter;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTypeBuild() {
		return typeBuild;
	}

	public void setTypeBuild(String typeBuild) {
		this.typeBuild = typeBuild;
	}

	public int getLifetimeBuild() {
		return lifetimeBuild;
	}

	public void setLifetimeBuild(int lifetimeBuild) {
		this.lifetimeBuild = lifetimeBuild;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", flatNumber=" + flatNumber + ", square="
				+ square + ", floar=" + floar + ", roomCounter=" + roomCounter
				+ ", street=" + street + ", typeBuild=" + typeBuild
				+ ", lifetimeBuild=" + lifetimeBuild + "]";
	}
}
