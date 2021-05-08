package kr.mjc.dowon.spring.midterm;

import kr.mjc.dowon.java.jdbc.article.Article;
import kr.mjc.dowon.java.jdbc.article.ArticleDao;
import kr.mjc.dowon.java.jdbc.article.ArticleDaoImpl;
import kr.mjc.dowon.java.jdbc.user.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ListArticlesEx {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext-user.xml");
        ArticleDao articleDao = context.getBean("articleDao", ArticleDao.class);
        List<Article> articleList = articleDao.listArticles(0, 10);
        for (Article article : articleList) {
            System.out.println(article);
        }
    }
}
