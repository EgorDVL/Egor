package bean;

import bean.enams.CategoryEnam;

public class Category {
    private int categoryId;
    private CategoryEnam nameCategory;
    private int subcatId;

    public Category() {
        super();
    }

    public Category(CategoryEnam nameCategory, int subcatId) {
        super();
        this.nameCategory = nameCategory;
        this.subcatId = subcatId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public CategoryEnam getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(CategoryEnam nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getSubcatId() {
        return subcatId;
    }

    public void setSubcatId(int subcatId) {
        this.subcatId = subcatId;
    }

    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", nameCategory="
                + nameCategory + ", subcatId=" + subcatId + "]";
    }

}
