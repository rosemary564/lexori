
package com.lexori.controller;

import com.lexori.entity.User;
import com.lexori.repository.ArticleRepository;
import com.lexori.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/{id}/earnings")
    public double getUserEarnings(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        List<Article> articles = user.getArticles();

        double earnings = 0.0;
        for (Article article : articles) {
            if (article.isMonetized()) {
                earnings += 0.01 * article.getViews(); // Example: $0.01 per view
            }
        }
        return earnings;
    }
}
