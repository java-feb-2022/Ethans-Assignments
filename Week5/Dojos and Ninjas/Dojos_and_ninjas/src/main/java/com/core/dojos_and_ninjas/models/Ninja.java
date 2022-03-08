package com.core.dojos_and_ninjas.models;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="ninja")
public class Ninja {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Min(value=2, message = "Enter a name (longer than 2 characters")
	private String first_name;
	@NotNull
	@Min(value=2, message = "Enter a name (longer than 2 characters")
	private String last_name;
	@NotNull
	@Min(value=1, message = "Enter an age (older than 1 year old")
	private Integer age;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dojo_id")
	private Dojo dojo;
	
	public Ninja() {
	}
	public Ninja(Long id, String first_name, String last_name, Integer age) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
	}
	public Long getId() {
		return this.id;
	}
	public String getFrist_name() {
		return this.first_name;
	}
	public String getLast_name() {
		return this.last_name;
	}
	public Integer getAge() {
		return this.age;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name; 
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name; 
	}
	public void setAge(Integer age) {
		this.age = age; 
	}
}