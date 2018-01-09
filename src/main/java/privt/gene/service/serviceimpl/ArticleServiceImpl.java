package privt.gene.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import privt.gene.dao.ArticleDao;
import privt.gene.model.Article;
import privt.gene.service.ArticleService;

import java.util.List;

/**
 * Created by Gene on 2017/12/22.
 */
@Service("articleServiceImpl")
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
    @Override
    public Article queryById(String articleId){
        //TODO 校验
        //TODO 每详细查看一次。热度加1,用户第一次查看不加热度
        //TODO 用户重复查看，本文章索引适度增加hot，本文章该用户感兴趣度增加
        Article article = articleDao.queryById(articleId);
        return article;
    }
}
