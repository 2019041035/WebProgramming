package kr.mjc.dowon.java.jdbc.article;

public class DeleteArticleEx {
    public static void main(String[] args) {
        ArticleDao articleDao = new ArticleDaoImpl();
        if (articleDao.deleteArticle(164, 348) > 0) {
            System.out.println("글을 삭제했습니다.");
        } else {
            System.out.println("글을 삭제하지 못했습니다.");
        }
    }
}

