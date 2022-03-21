package com.exam.practice.models;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
@Table (name = "project")
public class Project {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private String deadline;
	
	@Column(updatable=false)
	private Date createdAt;
	
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
	
	public Project() {}
	
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
    public String getTitle() {
    	return this.title;
    }
    public String getDescription() {
    	return this.description;
    }
    public String getDeadline() {
    	return this.deadline;
    }
    public Date getCreatedAt() {
    	return this.createdAt;
    }
    public Date getUpdatedAt() {
    	return this.updatedAt;
    }
    public User getUser() {
    	return this.user;
    }
    public void setId(Long id) {
    	this.id = id;
    }
    public void setTitle(String title) {
    	this.title = title;
    }
    public void setDescription (String desc) {
    	this.description = desc;
    }
    public void setDeadline(String deadline) {
    	this.deadline = deadline;
    }
    public void setCreatedAt(Date CA) {
    	this.createdAt = CA;
    }
    public void setUpdatedAt(Date UA) {
    	this.updatedAt = UA;
    }
    public void setUser(User user) {
    	this.user = user;
    }
}
