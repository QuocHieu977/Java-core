public abstract class SinhVienTechMaster {
    private String name;
    private String majos;

    public SinhVienTechMaster() {
    }

    public SinhVienTechMaster(String name, String majos) {
        this.name = name;
        this.majos = majos;
    }

    public abstract double getDiem();

    public String getHocLuc() {
        String hl = null;
        if(getDiem()<=5){
            hl="Yếu";
        } else if (getDiem()>=5 && getDiem()<6.5) {
            hl="Trung Bình";

        } else if (getDiem()>=6.5 && getDiem()<7.5) {
            hl="Khá";
        } else if(getDiem()>=7.6 && getDiem()<=10) {
            hl="Giỏi";
        }
        return hl;
    }

    public void printf() {
        System.out.println("ho va ten: " +name);
        System.out.println("nganh: " +majos);
        System.out.println("diem: " +getDiem());
        System.out.println("hoc luc: " +getHocLuc());
    }

}
