public class SInhVienBiz extends SinhVienTechMaster{
    private double marketingSocers;
    private double saleSocers;

    public SInhVienBiz() {
    }

    public SInhVienBiz(String name, String majors, double marketingSocers, double saleSocers) {
        super(name, majors);
        this.marketingSocers = marketingSocers;
        this.saleSocers = saleSocers;
    }

    @Override
    public double getDiem() {
        return ((2*marketingSocers)+saleSocers)/3;
    }
}
