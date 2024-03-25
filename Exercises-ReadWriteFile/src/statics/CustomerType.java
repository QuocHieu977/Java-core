package statics;

public enum CustomerType {
    PERSONAL("cá nhân"),
    ADMINISTRATIVE("đơn vị hành chính"),
    BUSINESS("đơn vị kinh doanh");

    public String value;

    CustomerType(String value) {
        this.value = value;
    }
}
