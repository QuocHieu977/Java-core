public class Train extends Vehicle {
    private double s;
    private double vTrain = Constant.V_TRAIN;

    public Train(double s) {
        this.s = s;
    }

    @Override
    public double caculatorTime() {
        return s/vTrain;
    }

    @Override
    public void printf() {
        System.out.println("S_train= " + caculatorTime());
    }
}
