package kr.mjc.dowon.java.jdbc.article;


public class GetArticleEx {
    public static void main(String[] args) {
        ArticleDao articleDao = new ArticleDaoImpl();
        Article article = articleDao.getArticle(157);
        System.out.println(article);
    }
}
