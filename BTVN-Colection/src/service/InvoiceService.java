package service;

import entities.Customer;
import entities.Invoice;
import entities.Service;

import java.util.*;

public class InvoiceService {
    private final List<Invoice> invoices = new ArrayList<>();

    CustomerService customerService;

    ServiceService serviceService;

    public InvoiceService(CustomerService customerService, ServiceService serviceService) {
        this.customerService = customerService;
        this.serviceService = serviceService;
    }

    public void createInvoice(Scanner scanner) {
        System.out.println("Có bao nhiêu khách hàng sử dụng dịch vụ: ");
        int customerNumber;

        while (true) {
            try {
                customerNumber = Integer.parseInt(scanner.nextLine());
                if (customerNumber < 0 || customerNumber > customerService.getCustomers().size())
                    throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập lại với số lượng khách hàng sử dụng dịch vụ không vượt quá " +(customerService.getCustomers().size()));
            }
        }

        for (int i=0; i<customerNumber; i++) {
            System.out.println("Nhập thông tin hoá đơn khách thứ " + (i+1));
            System.out.println("Nhập id khách hàng: ");

            Customer customer;
            while (true) {
                try {
                   int id = Integer.parseInt(scanner.nextLine());
                   customer = customerService.findById(id);
                   if (customer == null)
                       throw new NumberFormatException();
                   break;
                } catch (NumberFormatException e) {
                    System.out.println("Mã khách hàng không tồn tại. Xin vui lòng nhập lại");
                }
            }

            ArrayList<Service> newServices = insertService(scanner);
            invoices.add(new Invoice(customer, newServices));
        }

        System.out.println(invoices);
    }

    public ArrayList<Service> insertService(Scanner scanner) {
        ArrayList<Service> newServices = new ArrayList<>();
        String check;
        do {
            System.out.println("Nhập id dịch vụ: ");
            Service service;
            int id;
            while (true) {
                try {
                    id = Integer.parseInt(scanner.nextLine());
                    service = serviceService.findById(id, serviceService.getServices());
                    if (service == null)
                        throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Mã dịch vụ không tồn tại. Xin vui lòng nhập lại");
                }
            }
            if (serviceService.findById(id, newServices) == null) {
                if (newServices.size() <3) {
                    newServices.add(service);
                    System.out.println("Bạn đã thêm dịch vụ thành công...");
                } else
                    System.out.println("Khách hàng này đã sử dụng đến 5 dich vụ. Mời bạn nhập khách hàng khác");
            } else {
                System.out.println("Dịch vụ này đã tồn tại. Xin vui lòng thêm dịch khác");
            }

            System.out.println("Bạn có muốn thêm dịch nữa không(Y/N)?: ");
            check = scanner.nextLine();
        } while (!check.equalsIgnoreCase("n"));

        return newServices;
    }
}
