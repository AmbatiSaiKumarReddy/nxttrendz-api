/*
 *
 * You can use the following import statements
 * 
 * import javax.persistence.*;
 * 
 */

// Write your code here

package com.example.nxttrendz1.model;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewid")
    private int reviewId;

    @Column(name = "reviewcontent")
    private String reviewContent;

    @Column(name = "rating")
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;

    public Review() {

    }

    public Review(int reviewId, String reviewContent, Integer rating, Product product) {
        this.reviewId = reviewId;
        this.reviewContent = reviewContent;
        this.rating = rating;
        this.product = product;

    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getReviewId() {
        return reviewId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public Integer getRating() {
        return rating;
    }

    public Product getProduct() {
        return product;
    }

}