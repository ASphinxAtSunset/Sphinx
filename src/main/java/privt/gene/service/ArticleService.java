package privt.gene.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import privt.gene.model.Article;

import java.util.List;

/**
 * Created by Gene on 2017/12/22.
 */
public interface ArticleService {
    public void insertArticle(Article article);

    public void deleteArticle(Article article);

    public List<Article> search(String str);
}
