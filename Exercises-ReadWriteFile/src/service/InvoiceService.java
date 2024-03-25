package service;

import entities.Customer;
import entities.Invoice;
import entities.ServiceManger;
import utils.IOUtil;
import utils.file.DataUtil;
import utils.file.FileUtil;

import java.util.ArrayList;
import java.util.Comparator;

public class InvoiceService {
    public final static String INVOICE_DATA_FILE = "src/data/invoice.data";
    private ArrayList<Invoice> invoices = new ArrayList<>();
    final ServiceService serviceService;
    final CustomerService customerService;

    public InvoiceService(ServiceService serviceService, CustomerService customerService) {
        this.serviceService = serviceService;
        this.customerService = customerService;
    }

    public ArrayList<Invoice> getInvoices() {
        Object invoiceFile = FileUtil.readDataFormFile(INVOICE_DATA_FILE);
        if (!DataUtil.isNullObject(invoiceFile)) {
            return (ArrayList<Invoice>) invoiceFile;
        }
        return new ArrayList<>();
    }

    public void inputInvoice() {
        System.out.print("Mời bạn nhập số lượng khách hàng sử dụng dịch vụ: ");
        int customerNumber = IOUtil.integerNumber(1, customerService.getCustomers().size(), "Vui lòng hãy nhập lại: ");

        for(int i=0; i<customerNumber; i++) {
            System.out.print("Mời bạn nhập id khách hàng cần sử dụng dịch vu: ");

            Customer customer;
            do {
                int fId = IOUtil.integerNumber(1, "Vui lòng hãy nhập lại: ");
                customer = customerService.findById(fId);

                if (customer != null) {
                    ArrayList<ServiceManger> listService = serviceService.insertService();
                    invoices.add(new Invoice(customer, listService));
                } else {
                    System.out.print("Không tồn tại khách hàng này. Xin vui lòng nhập lại: ");
                }
            } while (customer == null);
        }
        FileUtil.writeDatToFile(invoices, INVOICE_DATA_FILE);
    }

    public void showInvoice() {
        System.out.println(getInvoices());
    }

    public void sortByName() {
        ArrayList<Invoice> invoicesClone = new ArrayList<>(invoices);
        invoicesClone.sort(new Comparator<Invoice>() {
            @Override
            public int compare(Invoice o1, Invoice o2) {
                return o1.getCustomer().getName().compareTo(o2.getCustomer().getName());
            }
        });

        System.out.println(invoicesClone);
    }

    public void sortByCapacity(){
        ArrayList<Invoice> invoicesClone = new ArrayList<>(invoices);

        for (Invoice e: invoicesClone) {
            e.getServiceMangers().sort(new Comparator<ServiceManger>() {
                @Override
                public int compare(ServiceManger o1, ServiceManger o2) {
                    return o2.getCapacity() - o1.getCapacity();
                }
            });
        }
        System.out.println(invoicesClone);
    }

    public void billingTable() {
        for(Invoice e: invoices) {
            double billing = 0;
            for(ServiceManger e1: e.getServiceMangers()) {
                billing += e1.getService().billing(e1.getCapacity());
            }

            System.out.println("Khách hàng: " + e.getCustomer().getName() + " - Tổng số tiền: " + billing);
        }
    }
}
