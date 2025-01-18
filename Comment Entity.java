
package com.lexori.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private LocalDateTime timestamp = LocalDateTime.now();

    @ManyToOne
    private Article article;

    @ManyToOne
    private User user;

    // Getters, Setters, Constructors
}
