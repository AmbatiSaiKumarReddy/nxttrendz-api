package com.example.nxttrendz1.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.nxttrendz1.repository.ProductJpaRepository;
import com.example.nxttrendz1.repository.ReviewJpaRepository;
import com.example.nxttrendz1.repository.ReviewRepository;

/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here

@Service

public class ReviewJpaService implements ReviewRepository {

	@Autowired
	private ReviewJpaRepository reviewJpaRepository;
	@Autowired
	private ProductJpaRepository productJpaRepository;

	@Override
	public ArrayList<Review> getReviews() {

		List<Review> reviewsList = reviewJpaRepository.findAll();
		ArrayList<Review> reviews = new ArrayList<Review>(reviewsList);

		return reviews;
	}

	@Override
	public Review getReviewById(int reviewId) {
		try {
			Review review = reviewJpaRepository.findById(reviewId).get();
			return review;

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public Review addReview(Review review) {

		int productId = review.getProduct().getProductId();
		Product product = productJpaRepository.findById(productId).get();
		review.setProduct(product);

		reviewJpaRepository.save(review);

		return review;
	}

	@Override
	public Review updateReview(int reviewId, Review review) {

		try {

			int productId = review.getProduct().getProductId();
			Product product = productJpaRepository.findById(productId).get();
			review.setProduct(product);

			Review existingReview = reviewJpaRepository.findById(reviewId).get();
			if (review.getReviewContent() != null) {
				existingReview.setReviewContent(existingReview.getReviewContent());
			}
			if (review.getRating() != null) {
				existingReview.setRating(existingReview.getRating());
			}

			reviewJpaRepository.save(existingReview);

			return existingReview;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteReview(int reviewId) {
		try {
			reviewJpaRepository.deleteById(reviewId);
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No Review Content");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public Product getProductByReview(int reviewId) {
		try {
			Review review = reviewJpaRepository.findById(reviewId).get();
			Product product = review.getProduct();
			return product;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

}