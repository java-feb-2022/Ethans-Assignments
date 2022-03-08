package com.core.dojos_and_ninjas.models;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="dojo")
public class Dojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	 @OneToMany(mappedBy="dojo",fetch=FetchType.LAZY)
	 private List<Ninja> ninja;
	 
	public Dojo() {
	}
	public Dojo(Long Id, String name, Date createdAt, Date updatedAt) {
		this.id = Id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
				
	}
	public Long getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public void setName() {
		this.name = name;
	}
}
