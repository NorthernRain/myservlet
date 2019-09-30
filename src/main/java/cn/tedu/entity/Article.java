package cn.tedu.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author LeafDust
 * @create 2019-09-17 15:12
 */
public class Article {
    private int oId;//主键
    private String title;//标题
    private String abs;//标题
    private int commentCount;//评论数量
    private int viewCount;//浏览数量
    private int putTop;//是否置顶
    private long created;//创建时间戳
    private long updated;//修改时间戳
    private String imgName;//图片名字
    private String userName;
    private String content;

    private String createdStr;
    private String updatedStr;
    private List<Tag> tags;

    public Article() {
    }

    public Article(int oId, String title, String abs, int commentCount, int viewCount, int putTop, long created, long updated, String imgName, String userName) {
        this.oId = oId;
        this.title = title;
        this.abs = abs;
        this.commentCount = commentCount;
        this.viewCount = viewCount;
        this.putTop = putTop;
        this.created = created;
        this.updated = updated;
        this.imgName = imgName;
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public Article(int oId, String title, String abs, int commentCount, int viewCount, int putTop, long created, long updated, String imgName, String userName, String content) {
        this.oId = oId;
        this.title = title;
        this.abs = abs;
        this.commentCount = commentCount;

        this.viewCount = viewCount;
        this.putTop = putTop;
        this.created = created;
        this.updated = updated;
        this.imgName = imgName;
        this.userName = userName;
        this.content=content;
    }


    public String getUpdatedStr() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date(this.updated);
        return " " + simpleDateFormat.format(date);
    }

    public void setUpdatedStr(String updatedStr) {
        this.updatedStr = updatedStr;
    }

    public String getCreatedStr() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date(this.created);
        return " " + format.format(date);
    }

    public void setCreatedStr(String createdStr) {
        this.createdStr = createdStr;
    }

    public String getUserName() {
        return userName;
    }

    public int getoId() {
        return oId;
    }

    public String getTitle() {
        return title;
    }

    public String getAbs() {
        return abs;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getPutTop() {
        return putTop;
    }

    public long getCreated() {
        return created;
    }

    public long getUpdated() {
        return updated;
    }

    public String getImgName() {
        return imgName;
    }

    @Override
    public String toString() {
        return "Article{" +
                "oId=" + oId +
                ", title='" + title + '\'' +
                ", abs='" + abs + '\'' +
                ", commentCount=" + commentCount +
                ", viewCount=" + viewCount +
                ", putTop=" + putTop +
                ", created=" + created +
                ", updated=" + updated +
                ", imgName='" + imgName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
