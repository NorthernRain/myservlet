package cn.tedu.entity;

/**
 * @author LeafDust
 * @create 2019-09-17 16:24
 */
public class Tag {
    private int oId;
    private int referenceCount;//关联文章数量
    private String title;//标签标题

    public Tag(int oId, int referenceCount, String title) {
        this.oId = oId;
        this.referenceCount = referenceCount;
        this.title = title;
    }

    public int getoId() {
        return oId;
    }

    public int getReferenceCount() {
        return referenceCount;
    }

    public String getTitle() {
        return title;
    }
}
