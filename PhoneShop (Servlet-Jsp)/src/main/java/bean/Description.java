package bean;

public class Description {
	private int descriptionId;
	private String description;

	public Description() {
		super();
	}

	public Description(String description) {
		super();
		this.description = description;
	}

	public int getDescriptionId() {
		return descriptionId;
	}

	public void setDescriptionId(int descriptionId) {
		this.descriptionId = descriptionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Description [descriptionId=" + descriptionId + ", description="
				+ description + "]";
	}
}
