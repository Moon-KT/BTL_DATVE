package com.example.SB_Week9.entity;

import com.example.SB_Week9.entity.key.MovieGiftKey;
import jakarta.persistence.*;

@Entity
@Table(name = "movie_gift", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"movie_id", "gift_id"})
})
public class Movie_Gift {
    @EmbeddedId
    private MovieGiftKey id;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "gift_id", insertable = false, updatable = false)
    private Gift gift;
}
