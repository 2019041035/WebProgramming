package kr.mjc.dowon.spring.midterm;

import kr.mjc.dowon.java.jdbc.DbUtils;
import kr.mjc.dowon.java.jdbc.ResultSetHandler;
import kr.mjc.dowon.java.jdbc.article.Article;
import kr.mjc.dowon.java.jdbc.article.ArticleDao;
import kr.mjc.dowon.java.jdbc.user.User;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

@Component("articleDaoImpl")
public class ArticleDaoImpl implements ArticleDao{
    private static final String LIST_ARTICLES
                = " select articleId, title, userId, name, left(cdate,16) cdate from article order by articleId desc limit ?,?";

    private static final String GET_ARTICLE
                = "select articleId, title, content, userId, name, left(cdate,16) cdate, left(udate,16) udate from article where articleId=?";

    private static final String ADD_ARTICLE
                = "insert article(title, content, userId, name) values(?,?,?,?)";

    private static final String UPDATE_ARTICLE
                = "update article set title=?, content=? where articleId=? and userId=?";

    private static final String DELETE_ARTICLE
                = "delete from article where articleId=? and userId=?";

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private DbUtils dbUtils;

    private ResultSetHandler<Article> h = (rs) -> {
        Article article = new Article();
        article.setArticleId(rs.getInt("articleId"));
        article.setTitle(rs.getString("title"));
        article.setUserId(rs.getInt("userId"));
        article.setName(rs.getString("name"));
        article.setCdate(rs.getString("cdate"));
        return article;
    };
    @Autowired
        public ArticleDaoImpl(DbUtils dbUtils) {
            this.dbUtils = dbUtils;
        }

        @Override
        public List<Article> listArticles(int offset, int count) {
            return dbUtils.list(LIST_ARTICLES, h, offset, count);
        }

        @Override
        public Article getArticle(int articleId) {
            return dbUtils.get(GET_ARTICLE, h, articleId);
        }

        @Override
        public void addArticle(Article article) {
            dbUtils.update(ADD_ARTICLE, article.getTitle(), article.getContent(),
                    article.getUserId(), article.getName());
        }

        @Override
        public int updateArticle(Article article) {
            return dbUtils
                    .update(UPDATE_ARTICLE, article.getTitle(), article.getContent(),
                            article.getArticleId(), article.getUserId());
        }

        @Override
        public int deleteArticle(int articleId, int userId) {
            return dbUtils.update(DELETE_ARTICLE, articleId, userId);
        }
    }

