package br.com.api.dvdrental.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pay_cd_id")
	private Long id;
	
	@NotNull
	@Column(name="pay_nm_amount")
	private Double amount;
	
	@Column(name="pay_dt_paymentDate")
	private LocalDate paymentDate;

	//fk STAFF CUSTOMER, STAFF, RENTAL

	public Payment(Long id, @NotNull Double amount, LocalDate paymentDate) {
		super();
		this.id = id;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
	

}
