public class Vuong extends HinhHoc{
    private double side;

    public Vuong(double side) {
        this.side = side;
    }


    @Override
    public double getDienTich() {
        return side*side;
    }

    @Override
    public double getChuVi() {
        return side*4;
    }

    @Override
    public double getAB() {
        return 0;
    }

    public double getab() {
        return side+side;
    }

    @Override
    public void print() {
        System.out.println("diện tích hv: "+getDienTich());
        System.out.println("chu vi hv: " +getChuVi());
    }
}
