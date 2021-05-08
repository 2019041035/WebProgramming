package kr.mjc.dowon.java.jdbc.article;

public class AddArticleEx {
    public static void main(String[] args) {
        ArticleDao articleDao = new ArticleDaoImpl();
        Article article = new Article();
        article.setTitle("네번째 게시물");
        article.setContent("끝!");
        article.setUserId(348);
        article.setName("끝!");
        articleDao.addArticle(article);
        System.out.println("게시글을 추가했습니다.");
    }
}