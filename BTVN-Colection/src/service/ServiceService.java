package service;

import entities.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceService {
    private final ArrayList<Service> services = new ArrayList<>();

    public ArrayList<Service> getServices() {
        return services;
    }

    public void inputService(Scanner scanner) {
        System.out.println("Nhập số lượng dịch vụ: ");
        int serviceNumber;

        while (true) {
            try {
                serviceNumber = Integer.parseInt(scanner.nextLine());
                if (serviceNumber < 0)
                    throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập lại...");
            }
        }

        for(int i=0; i<serviceNumber; i++) {
            Service service = new Service();
            System.out.println("Mời bạn nhập vào dịch vụ thứ " +(i+1));
            service.inputNewService(scanner);
            services.add(service);
        }
        System.out.println(services);
    }

    public Service findById(int id, ArrayList<Service> services) {
        for(Service e: services) {
            if (e.getId() == id)
                return e;
        }
        return null;
    }
}
