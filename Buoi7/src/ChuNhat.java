public class ChuNhat extends HinhHoc{
    private double length;
    private double width;

    public ChuNhat(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getDienTich() {
        return length*width;
    }

    @Override
    public double getChuVi() {
        return (length+width)*2;
    }

    @Override
    public double getAB() {
        return 0;
    }


    @Override
    public void print() {
        System.out.println("diện tích hcn: "+getDienTich());
        System.out.println("chu vi hcn: "+getChuVi());
    }
}
