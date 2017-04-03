package bean;

public class Characteristic {
	private int characteristicId;
	private String color;
	private int memory;
	private double screenSize;
	private String processor;
	private double ram;
	private double frontCamera;
	private double mainCamera;

	public Characteristic() {
		super();
	}

	public Characteristic(String color, int memory, double screenSize,
			String processor, double ram, double frontCamera, double mainCamera) {
		super();
		this.color = color;
		this.memory = memory;
		this.screenSize = screenSize;
		this.processor = processor;
		this.ram = ram;
		this.frontCamera = frontCamera;
		this.mainCamera = mainCamera;
	}

	public int getCharacteristicId() {
		return characteristicId;
	}

	public void setCharacteristicId(int characteristicId) {
		this.characteristicId = characteristicId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public double getRam() {
		return ram;
	}

	public void setRam(double ram) {
		this.ram = ram;
	}

	public double getFrontCamera() {
		return frontCamera;
	}

	public void setFrontCamera(double frontCamera) {
		this.frontCamera = frontCamera;
	}

	public double getMainCamera() {
		return mainCamera;
	}

	public void setMainCamera(double mainCamera) {
		this.mainCamera = mainCamera;
	}

	@Override
	public String toString() {
		return "Characteristic [characteristicId=" + characteristicId
				+ ", color=" + color + ", memory=" + memory + ", screenSize="
				+ screenSize + ", processor=" + processor + ", ram=" + ram
				+ ", frontCamera=" + frontCamera + ", mainCamera=" + mainCamera
				+ "]";
	}
}
