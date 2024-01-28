public class Air extends Vehicle {
    private final double s;
    private final double vAir = Constant.V_AIR;

    public Air(double s) {
        this.s = s;
    }

    @Override
    public double caculatorTime() {
        return s/vAir;
    };
    @Override
    public void printf() {
        System.out.println("S_air= " + caculatorTime());
    }
}
