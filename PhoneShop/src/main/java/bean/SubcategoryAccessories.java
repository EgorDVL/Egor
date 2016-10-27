package bean;

import bean.enams.SubCategoryAccessory;

public class SubcategoryAccessories {
	private int subcatId;
	private SubCategoryAccessory nameSubCategoryAccessory;

	public SubcategoryAccessories() {
		super();
	}

	public SubcategoryAccessories(SubCategoryAccessory nameSubCategoryAccessory) {
		super();
		this.nameSubCategoryAccessory = nameSubCategoryAccessory;
	}

	public int getSubcatId() {
		return subcatId;
	}

	public void setSubcatId(int subcatId) {
		this.subcatId = subcatId;
	}

	public SubCategoryAccessory getNameSubCategoryAccessory() {
		return nameSubCategoryAccessory;
	}

	public void setNameSubCategoryAccessory(
			SubCategoryAccessory nameSubCategoryAccessory) {
		this.nameSubCategoryAccessory = nameSubCategoryAccessory;
	}

	@Override
	public String toString() {
		return "SubcategoryAccessories [subcatId=" + subcatId
				+ ", nameSubCategoryAccessory=" + nameSubCategoryAccessory
				+ "]";
	}
}
