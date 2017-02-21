package com.gauravbytes.gkart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 */
@Entity
@Table(name = "product_ratings", schema = "product")
public class Rating {
	@Id
	@GeneratedValue
	@Column(name="rating_id")
	private Long ratingId;
	
	private double rating;
	
	@Column(name="product_id")
	private String productId;
	
	@Column(name="user_id")
	private String userId;
	
	public Rating() {
		
	}
	
	public Rating(Long ratingId, double rating, String productId, String userId) {
		super();
		this.ratingId = ratingId;
		this.rating = rating;
		this.productId = productId;
		this.userId = userId;
	}

	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((ratingId == null) ? 0 : ratingId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rating other = (Rating) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		if (ratingId == null) {
			if (other.ratingId != null)
				return false;
		} else if (!ratingId.equals(other.ratingId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rating [ratingId=").append(ratingId).append(", rating=").append(rating).append(", productId=")
				.append(productId).append(", user=").append(userId).append("]");
		return builder.toString();
	}
}
