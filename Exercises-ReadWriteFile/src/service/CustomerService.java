package service;

import entities.Customer;
import utils.IOUtil;
import utils.file.DataUtil;
import utils.file.FileUtil;

import java.util.ArrayList;

public class CustomerService {
    public final static String CUSTOMER_DATA_FILE = "src/data/customer.dat";
    private ArrayList<Customer> customers = new ArrayList<>();

    public ArrayList<Customer> getCustomers() {
        Object customerFile = FileUtil.readDataFormFile(CUSTOMER_DATA_FILE);
        if (!DataUtil.isNullObject(customerFile)) {
            return (ArrayList<Customer>) customerFile;
        }
        return new ArrayList<>();
    }

    public void inputCustomer() {
        System.out.print("MỜi bạn nhập số lượng khách hàng: ");
        int customerNumber = IOUtil.integerNumber(1, "Vui lòng hãy nhập lại: ");
        System.out.println("--------------------------------------------------");
        for(int i=0; i<customerNumber; i++){
            Customer customer = new Customer();
            System.out.println("Mời bạn nhập khách hàng thứ " +(i+1));
            customer.inputNewCustomer();
            customers.add(customer);
        }
        FileUtil.writeDatToFile(customers, CUSTOMER_DATA_FILE);
    }

    public void showCustomer() {
        System.out.println(getCustomers());
    }

    public Customer findById(int fId) {
        for (Customer e:getCustomers()) {
            if (e.getId() == fId){
                return e;
            }
        }
        return null;
    }
}
