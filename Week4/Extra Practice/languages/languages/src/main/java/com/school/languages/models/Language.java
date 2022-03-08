package com.school.languages.models;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="language")
public class Language {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 200, message="name of language is missing or incorrect")
	private String name;
	
	@NotNull
	@Size(min = 2, max = 200, message="creator is missing or incorrect")
	private String creator;
	
	@NotNull(message = "Please enter a version.")
	@Min(value = 2, message = "Not a valid version")
	private String version;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Language() {
	}
	public Language(Language E) {
		this.name = E.name;
		this.creator = E.creator;
		this.version = E.version;
	}
	public void update(Language E) {
		this.name = E.getName();
		this.creator = E.getCreator();
		this.version = E.getVersion();
	}
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	public Long getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getCreator() {
		return this.creator;
	}
	public String getVersion() {
		return this.version;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public void setVersion(String version) {
		this.version = version;
	}
}
