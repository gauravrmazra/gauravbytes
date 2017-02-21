package com.gauravbytes.gkart.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.gauravbytes.gkart.entity.Rating;
import com.gauravbytes.gkart.jpa.ProductRepository;
import com.gauravbytes.gkart.jpa.RatingRepository;
import com.gauravbytes.gkart.jpa.UserRepository;
import com.gauravbytes.gkart.service.exception.GenericServiceException;

/**
 * 
 * @author Gaurav Rai Mazra <a href="http://www.gauravbytes.com">Catch me</a>
 */
@Service
public class RatingService implements GenericService<Rating, Long> {
	private final RatingRepository ratingRepository;
	private final ProductRepository productRepository;
	private final UserRepository userRepository;

	public RatingService(final RatingRepository ratingRepository, final ProductRepository productRepository,
			final UserRepository userRepository) {
		this.ratingRepository = ratingRepository;
		this.productRepository = productRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Long getId(Rating entity) {
		return entity.getRatingId();
	}

	@Override
	public CrudRepository<Rating, Long> getRepository() {
		return this.ratingRepository;
	}

	public Iterable<Rating> getRatingsByProductId(final String productId) {
		return this.ratingRepository.getRatingsByProductId(productId);
	}

	@Override
	public Rating save(Rating entity) {
		if (!productRepository.exists(entity.getProductId()) || !userRepository.exists(entity.getUserId())) {
			throw new GenericServiceException("Either product_id or user_id doesn't exists: " + entity);
		}
		return GenericService.super.save(entity);
	}
}
