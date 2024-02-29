package com.sudhir.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name ="user_details")
public class UserDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToMany
	private List<Product> cart;
	private long rewardPoints;
	private Long currentMonthPurchaseAmount;

	public long getRewardPoints() {
		return this.rewardPoints;
	}

	public Long getCurrentMonthPurchaseAmount() {
		return currentMonthPurchaseAmount;
	}

	public void setCurrentMonthPurchaseAmount(Long currentMonthPurchaseAmount) {
		this.currentMonthPurchaseAmount = currentMonthPurchaseAmount;
	}

	public void setRewardPoints(long rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

}
