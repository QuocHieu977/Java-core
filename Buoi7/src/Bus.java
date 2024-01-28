public class Bus extends Vehicle {
    private double s;
    private double vBus = Constant.V_BUS;

    public Bus(double s) {
        this.s = s;
    }

    @Override
    public double caculatorTime() {
        return s/vBus;
    }

    @Override
    public void printf() {
        System.out.println("S_bus= " + caculatorTime());
    }
}
