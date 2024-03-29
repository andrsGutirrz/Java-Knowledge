package Empleate.domain;
// Generated 12/03/2018 12:06:18 AM by Hibernate Tools 4.3.1



/**
 * Offercategory generated by hbm2java
 */
public class Offercategory  implements java.io.Serializable {


     private OffercategoryId id;
     private Category category;
     private Offerer offerer;
     private Integer percentage;

    public Offercategory() {
    }
      public Offercategory(Category cat, Offerer off) {//Constructor util
        this.category = cat;
        this.offerer = off;
        this.id = new OffercategoryId(off.getIdOfferer(),cat.getIdCategory());//oferente,category
    }
    public Offercategory(Category cat, Offerer off, Integer per) {//Constructor util
        this.category = cat;
        this.offerer = off;
        this.percentage = per;
        this.id = new OffercategoryId(off.getIdOfferer(),cat.getIdCategory());//oferente,category
    }
    public OffercategoryId getId() {
        return this.id;
    }
    
    public void setId(OffercategoryId id) {
        this.id = id;
    }
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    public Offerer getOfferer() {
        return this.offerer;
    }
    
    public void setOfferer(Offerer offerer) {
        this.offerer = offerer;
    }
    public Integer getPercentage() {
        return this.percentage;
    }
    
    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }




}


