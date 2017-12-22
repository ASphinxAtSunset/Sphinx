package privt.gene.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import privt.gene.dao.ArticleDao;
import privt.gene.model.Article;
import privt.gene.service.ArticleService;

import java.util.List;

/**
 * Created by Gene on 2017/12/22.
 */
@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    ArticleDao articleDao;

    @Override
    public void insertArticle(Article article) {

    }

    @Override
    public void deleteArticle(Article article) {

    }

    @Override
    public List<Article> search(String str) {
        return null;
    }
}
