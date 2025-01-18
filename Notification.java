
package com.lexori.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private LocalDateTime timestamp = LocalDateTime.now();

    @ManyToOne
    private User user;

    // Getters, Setters, Constructors
}
