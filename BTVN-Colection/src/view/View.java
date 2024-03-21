package view;

import service.CustomerService;
import service.InvoiceService;
import service.ServiceService;

import java.util.Scanner;

public class View {
    final CustomerService customerService = new CustomerService();
    final ServiceService serviceService = new ServiceService();
    final InvoiceService invoiceService = new InvoiceService(customerService, serviceService);

    public void display(Scanner scanner) {
        int choose;
        do {
            while (true){
                showMenu();
                try {
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose <1 || choose >6)
                        throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập lại...");
                }
            }

            switch (choose) {
                case 1:
                    customerService.inputCustomer(scanner);
                    break;
                case 2:
                    serviceService.inputService(scanner);
                    break;
                case 3:
                    invoiceService.createInvoice(scanner);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        } while (choose !=6);
    }

    public void showMenu() {
        System.out.println("1. Nhập danh sách khách hàng và in ra");
        System.out.println("2. Nhập danh sách dịch vụ và in ra");
        System.out.println("3. Nhập hoá đơn cho mỗi khách hàng đã");
        System.out.println("4. Sắp xếp danh sách hoá đơn theo tên");
        System.out.println("5. Sắp xếp danh sách hoá đơn theo số lượng sử dụng");
        System.out.println("6. Lập thông kê số tiền phải trả cho mỗi khách hàng");
        System.out.println("Chọn:");
    }
}
