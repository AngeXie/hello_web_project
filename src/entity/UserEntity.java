package entity;

public class UserEntity {
    private String id;
    private String name;;
    private String pwd;
    private String status;
    private String email;
    private String head;
    private int reported_count;
    private String usr_intro;
    public static final String DEFAULT_HEAD = "image/usr-head/head-001.jpg";
    public static final String STATUS_NORMAL = "正常";
    public static final String STATUS_BANNED=  "禁言";

    public int getReported_count() {
        return reported_count;
    }

    public void setReported_count(int reported_count) {
        this.reported_count = reported_count;
    }

    public String getUsr_intro() {
        return usr_intro;
    }

    public void setUsr_intro(String usr_intro) {
        this.usr_intro = usr_intro;
    }

    public UserEntity() {
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
