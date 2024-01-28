public abstract class SinhVienTechMaster {
    private String name;
    private String majors;

    public SinhVienTechMaster() {

    }

    public SinhVienTechMaster(String name, String majors) {
        this.name = name;
        this.majors = majors;
    }

    public abstract double getDiem();

    public String getHocLuc() {
        String result = null;

        if(getDiem() <5) {
            result = "Yếu";
        } else if(getDiem()>=5 && getDiem()<6.5) {
            result = "Trung Bình";
        } else if (getDiem()>=6.5 && getDiem()<7.5 ) {
            result = "Khá";
        } else if(getDiem()>=7.5 && getDiem()<=10) {
            result = "Giỏi";
        }
        return result;
    }

    public void xuat() {
        System.out.println("Họ và tên: "+name);
        System.out.println("Ngành học: "+majors);
        System.out.println("Điểm: "+getDiem());
        System.out.println("Xếp loại: "+getHocLuc());
        System.out.println("========================");
    }
}
