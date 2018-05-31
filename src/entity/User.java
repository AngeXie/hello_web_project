package entity;

public class User {
    private String id;
    private String name;;
    private String pwd;
    private String status;
    private String email;
    private String head;
    public static final String DEFAULT_HEAD = "image/usr-head/head-001.jpg";
    public static final String STATUS_NORMAL = "正常";
    public static final String STATUS_BANNED=  "禁言";

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}
