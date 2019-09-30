package cn.tedu.entity;

/**
 * @author LeafDust
 * @create 2019-09-18 17:22
 */
public class Link {
    private String title;
    private String address;

    public Link(String title, String address) {
        this.title = title;
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
