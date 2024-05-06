package com.simulation.entity;

public class Software {
    private CategoryProductivity categoryProductivity;
    private int productivityID;
    private int categoryID;
    private String name;

    public CategoryProductivity getCategoryProductivity() {
        return categoryProductivity;
    }

    public void setCategoryProductivity(CategoryProductivity categoryProductivity) {
        this.categoryProductivity = categoryProductivity;
    }

    public int getProductivityID() {
        return productivityID;
    }

    public void setProductivityID(int productivityID) {
        this.productivityID = productivityID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
