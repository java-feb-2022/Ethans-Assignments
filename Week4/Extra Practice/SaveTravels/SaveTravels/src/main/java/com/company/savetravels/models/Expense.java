package com.company.savetravels.models;
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
@Table(name="expenses")
public class Expense {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 200, message="name is missing or incorrect")
	private String name;
	
	@NotNull
	@Size(min = 2, max = 200, message="Vendor is missing or incorrect")
	private String vendor;
	
	@NotNull(message = "Please enter an amount.")
	@Min(value = 1, message="amount is incorrect (must be greater than 1.00)")
	private Double amount;
	
	@NotNull
	@Size(min = 10, message="description is missing or incorrect")
	private String description;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Expense() {
	}
	public Expense(String name, String vendor, Double amount, String desc) {
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = desc;
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
	public String getVendor() {
		return this.vendor;
	}
	public Double getAmount() {
		return this.amount;
	}
	public String getDescription() {
		return this.description;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public void setDescription(String desc) {
		this.description = desc;
	}
}
