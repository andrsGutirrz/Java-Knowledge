package Empleate.domain;
// Generated 12/03/2018 12:06:18 AM by Hibernate Tools 4.3.1



/**
 * Jobcategory generated by hbm2java
 */
public class Jobcategory  implements java.io.Serializable {
     private JobcategoryId id;
     private Category category;
     private Job job;
     private Integer percentage;

    public Jobcategory() {
    }
    public Jobcategory(Job j,Category cat) {//Constructor util
        this.category = cat;
        this.job = j;
        this.id = new JobcategoryId(j.getIdJob(),cat.getIdCategory());//job,category
    }
    public Jobcategory(Job j,Category cat,Integer per) {//Constructor util
        this.category = cat;
        this.job = j;
        this.percentage = per;
        this.id = new JobcategoryId(j.getIdJob(),cat.getIdCategory());//job,category
    }
    public JobcategoryId getId() {
        return this.id;
    }
    
    public void setId(JobcategoryId id) {
        this.id = id;
    }
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    public Job getJob() {
        return this.job;
    }
    
    public void setJob(Job job) {
        this.job = job;
    }
    public Integer getPercentage() {
        return this.percentage;
    }
    
    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }




}


