package Empleate.domain;
// Generated 12/03/2018 12:06:18 AM by Hibernate Tools 4.3.1

import com.google.gson.annotations.Expose;
import java.util.HashSet;
import java.util.Set;

/**
 * Category generated by hbm2java
 */
public class Category implements java.io.Serializable {

    @Expose
    int idCategory;
    Category category;
    @Expose
    String nameCategory;
    Integer isRoot;
    Integer isDad;
    Set<Category> categories = new HashSet<>(0);
    Set<Jobcategory> jobcategories = new HashSet<>(0);
    Set<Offercategory> offercategories = new HashSet<>(0);

    public Category() {
    }

    public Category(int idCategory) {
        this.idCategory = idCategory;

    }

    public Category(int idCategory, Category category, String nameCategory, Integer isRoot, Integer isDad, Set<Category> categories, Set<Jobcategory> jobcategories, Set<Offercategory> offercategories) {
        this.idCategory = idCategory;
        this.category = category;
        this.nameCategory = nameCategory;
        this.categories = categories;
        this.isRoot = isRoot;
        this.isDad = isDad;
        this.jobcategories = jobcategories;
        this.offercategories = offercategories;
    }

    public Category(int idCategory, Category category, String nameCategory) {
        this.idCategory = idCategory;
        this.category = category;
        this.nameCategory = nameCategory;
    }

    public int getIdCategory() {
        return this.idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getNameCategory() {
        return this.nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public Integer getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(Integer isRoot) {
        this.isRoot = isRoot;
    }

    public Integer getIsDad() {
        return this.isDad;
    }

    public void setIsDad(Integer isDad) {
        this.isDad = isDad;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Jobcategory> getJobcategories() {
        return this.jobcategories;
    }

    public void setJobcategories(Set<Jobcategory> jobcategories) {
        this.jobcategories = jobcategories;
    }

    public Set<Offercategory> getOffercategories() {
        return this.offercategories;
    }

    public void setOffercategories(Set<Offercategory> offercategories) {
        this.offercategories = offercategories;
    }

}
