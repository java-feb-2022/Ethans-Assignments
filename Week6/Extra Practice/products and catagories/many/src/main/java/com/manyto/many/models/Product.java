package com.manyto.many.models;

import java.util.Date;
import java.util.List;
import java.util.Locale.Category;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private float price;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products", 
        joinColumns = @JoinColumn(name = "product_id"), 
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
    
    public Product() {}
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    public Long getId() {
    	return this.id;
    }
    public String getName() {
    	return this.name;
    }
    public String getDescription() {
    	return this.description;
    }
    public float getPrice() {
    	return this.price;
    }
    public void setId(Long id) {
    	this.id = id;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public void setDescription(String desc) {
    	this.description = desc;
    }
    public void setPrice(float price) {
    	this.price = price;
    }
}