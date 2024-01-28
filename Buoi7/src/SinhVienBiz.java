public class SinhVienBiz extends SinhVienTechMaster{
    private double marketing;
    private double sales;

    public SinhVienBiz() {
    }

    public SinhVienBiz(String name, String majos, double marketing, double sales) {
        super(name, majos);
        this.marketing = marketing;
        this.sales = sales;
    }

    @Override
    public double getDiem() {
        return ((2*marketing)+sales)/3;
    }
}
