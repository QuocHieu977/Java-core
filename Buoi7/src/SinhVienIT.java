public class SinhVienIT extends SinhVienTechMaster{
    private double java;
    private double html;
    private double css;

    public SinhVienIT() {

    }

    public SinhVienIT(String name, String majos, double java, double html, double css) {
        super(name, majos);
        this.java = java;
        this.html = html;
        this.css = css;
    }

    @Override
    public double getDiem() {
        return ((2*java)+html+css)/4;
    }
}
