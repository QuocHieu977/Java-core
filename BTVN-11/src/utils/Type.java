package utils;

public enum Type {
    PERSONAL ("cá nhân"),
    GROUPS ("tập thể"),
    BUSINESSES ("doanh nghiệp");

    public String value;

    Type(String value) {
        this.value = value;
    }
}
