
package com.lexori.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String imageUrl;
    private Long views = 0L;
    private Long likes = 0L;
    private boolean isMonetized = false;

    private LocalDateTime publicationDate = LocalDateTime.now();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Comment> comments;

    // Getters, Setters, Constructors
}
