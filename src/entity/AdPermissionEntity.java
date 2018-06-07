package entity;

public class AdPermissionEntity {
    private String admin_id;
    private String permits_id;

    public AdPermissionEntity(){}

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getPermits_id() {
        return permits_id;
    }

    public void setPermits_id(String permits_id) {
        this.permits_id = permits_id;
    }
}
