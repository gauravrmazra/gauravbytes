package com.gauravbytes.gkart.controller;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gauravbytes.gkart.entity.Product;
import com.gauravbytes.gkart.entity.Rating;
import com.gauravbytes.gkart.service.ProductService;
import com.gauravbytes.gkart.service.RatingService;
import com.gauravbytes.gkart.vo.ResponseVO;

/**
 * 
 * @author Gaurav Rai Mazra <a href="http://www.gauravbytes.com">Catch me</a>
 */
@RestController
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;
	private final RatingService ratingService;

	public ProductController(final ProductService productService, final RatingService ratingService) {
		this.productService = productService;
		this.ratingService = ratingService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Iterable<Product>>> findAll() {
		return ResponseEntity.ok(new ResponseVO<>(productService.findAll()));
	}

	@GetMapping(value = "/{product_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Product>> get(@PathVariable("product_id") String productId) {
		return ResponseEntity.ok(new ResponseVO<>(productService.get(productId)));
	}

	@DeleteMapping(value = "/{product_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<String>> delete(@PathVariable("product_id") String productId) {
		productService.delete(productId);
		return ResponseEntity.ok(new ResponseVO<>(productId));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Product>> create(@RequestBody Product product) {
		Product savedProduct = productService.save(product);
		return ResponseEntity.created(URI.create("/" + product.getId())).body(new ResponseVO<>(savedProduct));
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody Product product) {
		productService.update(product);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/{product_id}/ratings", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Iterable<Rating>>> getRatings(@PathVariable("product_id") String productId) {
		return ResponseEntity.ok(new ResponseVO<>(ratingService.getRatingsByProductId(productId)));
	}

	@GetMapping(value = "/{product_id}/ratings/{rating_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Rating>> getRating(@PathVariable("product_id") String productId,
			@PathVariable("rating_id") Long ratingId) {
		return ResponseEntity.ok(new ResponseVO<>(ratingService.get(ratingId)));
	}

	@PostMapping(value = "/{product_id}/ratings", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Rating>> saveRating(@PathVariable("product_id") String productId,
			@RequestBody Rating rating) {
		if (!productId.equals(rating.getProductId()))
			throw new RuntimeException("Ids doesn't match");
		
		Rating savedRating = ratingService.save(rating);
		return ResponseEntity
				.created(URI.create("/" + savedRating.getProductId() + "/ratings/" + savedRating.getRatingId()))
				.body(new ResponseVO<>(savedRating));
	}

	@PutMapping(value = "/{product_id}/ratings/{rating_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateRating(@PathVariable("product_id") String productId,
			@PathVariable("rating_id") Long ratingId, @RequestBody Rating rating) {
		ratingService.update(rating);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{product_id}/ratings/{rating_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Long>> deleteRating(@PathVariable("product_id") String productId,
			@PathVariable("rating_id") Long ratingId) {
		ratingService.delete(ratingId);
		return ResponseEntity.ok(new ResponseVO<>(ratingId));
	}

}
