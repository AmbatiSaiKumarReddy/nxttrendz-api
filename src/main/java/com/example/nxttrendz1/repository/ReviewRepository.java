/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.nxttrendz1.repository;

import com.example.nxttrendz1.model.*;
import java.util.ArrayList;

public interface ReviewRepository {

    public ArrayList<Review> getReviews();

    public Review getReviewById(int reviewId);

    public Review addReview(Review review);

    public Review updateReview(int ReviewId, Review review);

    public void deleteReview(int reviewId);

    public Product getProductByReview(int reviewId);

}