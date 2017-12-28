package privt.gene.dto;

import java.util.Date;
import java.util.List;

/**
 * Created by Gene on 2017/12/27.
 */
public class Article {
    String articleId;
    String title;
    String content;
    String userId;
    String userName;
    List<String> indexList;
    int dupcount;
    Date date;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getIndexList() {
        return indexList;
    }

    public void setIndexList(List<String> indexList) {
        this.indexList = indexList;
    }

    public int getDupcount() {
        return dupcount;
    }

    public void setDupcount(int dupcount) {
        this.dupcount = dupcount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
