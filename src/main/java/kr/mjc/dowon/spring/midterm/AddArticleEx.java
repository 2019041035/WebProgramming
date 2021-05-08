package kr.mjc.dowon.spring.midterm;

import kr.mjc.dowon.java.jdbc.article.Article;
import kr.mjc.dowon.java.jdbc.article.ArticleDao;
import kr.mjc.dowon.java.jdbc.article.ArticleDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddArticleEx {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext-article.xml");
        ArticleDao articleDao = new ArticleDaoImpl();
        Article article = new Article();
        article.setTitle("중간고사");
        article.setContent("20210420");
        article.setUserId(348);
        article.setName("정도원");
        articleDao.addArticle(article);
        System.out.println("게시글을 추가했습니다.");
    }
}