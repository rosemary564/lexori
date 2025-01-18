public Article getArticleById(Long id) {
    Article article = articleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Article not found"));
    article.incrementViews();
    
    if (article.isMonetized()) {
        notificationService.sendNotification(article.getUser().getId(), 
            "Your article \"" + article.getTitle() + "\" has been monetized!");
    }
    
    articleRepository.save(article);
    return article;
}
