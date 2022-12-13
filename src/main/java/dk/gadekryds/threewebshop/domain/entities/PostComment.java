package dk.gadekryds.threewebshop.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "post_comment")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String review;

    // getters & setters

    public PostComment() { }
    public PostComment(String review){
        this.review = review;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}