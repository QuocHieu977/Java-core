public class SinhVienIT extends SinhVienTechMaster{
    private double javaSocers;
    private double htmlSocers;
    private double cssSocers;

    public SinhVienIT() {
    }

    public SinhVienIT(String name, String majors, double javaSocers, double htmlSocers, double cssSocers) {
        super(name, majors);
        this.javaSocers = javaSocers;
        this.htmlSocers = htmlSocers;
        this.cssSocers = cssSocers;
    }

    @Override
    public double getDiem() {
        return ((2*javaSocers)+htmlSocers+cssSocers)/4;
    }
}
