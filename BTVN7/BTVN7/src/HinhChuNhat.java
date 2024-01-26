public class HinhChuNhat extends HinhHoc{
    private int length;
    private int width;

    public HinhChuNhat() {

    }

    public HinhChuNhat(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public int dienTichHCN(int length, int width) {
        return super.dienTichHCN(length, width);
    }

    @Override
    public double chuViHCN(int length, int width) {
        return super.chuViHCN(length, width);
    }

    @Override
    public String toString() {
        return "HinhChuNhat{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
