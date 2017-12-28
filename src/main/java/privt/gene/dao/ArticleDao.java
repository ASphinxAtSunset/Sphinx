package privt.gene.dao;

import org.springframework.stereotype.Repository;
import privt.gene.model.Article;

import java.util.List;

/**
 * Created by Gene on 2017/12/22.
 */
public interface ArticleDao {
    public void insertArticle(Article article);

    public void deleteArticle(Article article);

    public List<Article> search(String str);

    public Article queryById(String articleId);
}
