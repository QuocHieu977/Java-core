package view;

import service.CustomerService;
import service.InvoiceService;
import service.ServiceService;
import utils.IOUtil;

public class View {
    final CustomerService customerService = new CustomerService();
    final ServiceService serviceService = new ServiceService();
    final InvoiceService invoiceService = new InvoiceService(serviceService, customerService);
    public void display() {
        int choose;
        do {
            showMenu();
            choose = IOUtil.integerNumber(1, 10, "Vui lòng hãy chọn lại: ");

            switch (choose) {
                case 1:
                    customerService.inputCustomer();
                    break;
                case 2:
                    customerService.showCustomer();
                    break;
                case 3:
                    serviceService.inputServices();
                    break;
                case 4:
                    serviceService.showService();
                    break;
                case 5:
                    invoiceService.inputInvoice();
                    break;
                case 6:
                    invoiceService.showInvoice();
                    break;
                case 7:
                    invoiceService.sortByName();
                    break;
                case 8:
                    invoiceService.sortByCapacity();
                    break;
                case 9:
                    invoiceService.billingTable();
                    break;
            }
        } while (choose !=10);
    }

    public void showMenu() {
        System.out.println("1. Nhập danh sách khách hàng");
        System.out.println("2. In danh sách khách hàng");
        System.out.println("3. Nhập danh sách dịch vụ");
        System.out.println("4. In danh sách dịch vụ");
        System.out.println("5. Nhập danh sách hoá đơn");
        System.out.println("6. In danh sách hoá đơn");
        System.out.println("7. Sắp xếp danh sách hoá đơn theo họ tên");
        System.out.println("8. Sắp xếp danh sách hoá đơn số lượng sử dung(giảm dần)");
        System.out.println("9. Lập bảng tính tổng số tiền theo số lượng khách hàng sử dụng");
        System.out.println("10. Thoát");
        System.out.println("Chọn:");
    }
}
