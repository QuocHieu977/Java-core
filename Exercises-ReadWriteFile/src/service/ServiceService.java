package service;

import entities.Service;
import entities.ServiceManger;
import utils.IOUtil;
import utils.file.DataUtil;
import utils.file.FileUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiceService {
    public final static String SERVICE_DATA_FILE = "src/data/service.dat";
    private ArrayList<Service> services = new ArrayList<>();

    public ArrayList<Service> getServices() {
        Object serviceFile = FileUtil.readDataFormFile(SERVICE_DATA_FILE);
        if (!DataUtil.isNullObject(serviceFile)){
            return (ArrayList<Service>) serviceFile;
        }
        return new ArrayList<>();
    }

    public void inputServices() {
        System.out.print("Mời bạn nhập số lượng dịch vụ: ");
        int serviceNumber = IOUtil.integerNumber(1, "Vui lòng nhập lại: ");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < serviceNumber; i++) {
            Service service = new Service();
            System.out.println("Mời bạn nhập dịch vụ thứ " + (i + 1));
            service.inputNewService();
            services.add(service);
        }
        FileUtil.writeDatToFile(services, SERVICE_DATA_FILE);
    }

    public void showService(){
        System.out.println(getServices());
    }

    public ArrayList<ServiceManger> insertService() {
        ArrayList<ServiceManger> newServices = new ArrayList<>();

        String check;
        do {
            System.out.print("Mời bạn tìm id dịch vụ cần thêm cho khách hàng: ");

            int count;
            Service service;
            do {
                count = 0;
                int fId = IOUtil.integerNumber(1, "Vui lòng hãy nhập lại: ");
                service = findById(fId);

                if (service != null) {
                    if (findById(fId, newServices) == null) {
                        if (newServices.size() <3) {
                            System.out.print("Mời bạn nhập số lượng đã sử dụng dịch vụ: ");
                            int capacity = IOUtil.integerNumber(1, "Vui lòng hãy nhập lại: ");
                            newServices.add(new ServiceManger(capacity, service));
                            System.out.println("Bạn đã thêm dịch vụ thành công...");
                        } else  {
                            System.out.println("Khách hàng này đã sử dụng tối đa 3 dịch vu");
                        }

                    } else {
                        count++;
                        System.out.print("Khách hàng này đã sử dụng dịch vụ này rồi. Vui lòng tìm dịch vụ khác: ");
                    }
                } else {
                    System.out.print("Dịch vụ không tồn tại. Vui lòng tìm dịch vụ khác: ");
                }

            } while (service == null || count> 0);

            System.out.print("Bạn có muốn thêm dịch vụ cho khách hàng này nữa không(Y/N): ");
            check = new Scanner(System.in).nextLine();

        } while (!check.equalsIgnoreCase("n"));

        return newServices;
    }

    public Service findById(int fId) {
        for (Service e : getServices()) {
            if (e.getId() == fId) {
                return e;
            }
        }
        return null;
    }

    public Service findById(int fId, ArrayList<ServiceManger> serviceMangers) {
        for (ServiceManger e : serviceMangers) {
            if (e.getService().getId() == fId) {
                return e.getService();
            }
        }
        return null;
    }
}
