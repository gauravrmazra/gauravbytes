package com.gauravbytes.gkart.jpa;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gauravbytes.gkart.entity.Rating;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 */
@Transactional
public interface RatingRepository extends JpaRepository<Rating, Long> {
	public Iterable<Rating> getRatingsByProductId(final String productId);
}
