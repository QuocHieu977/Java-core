public class HinhVuong extends HinhHoc{
    private int side;

    public HinhVuong() {

    }
    public HinhVuong(int side) {
        this.side = side;
    }

    @Override
    public int dienTichHV(int a) {
        return super.dienTichHV(a);
    }

    @Override
    public int chuViHV(int a) {
        return super.chuViHV(a);
    }

    @Override
    public String toString() {
        return "HinhVuong{" +
                "side=" + side +
                '}';
    }
}
