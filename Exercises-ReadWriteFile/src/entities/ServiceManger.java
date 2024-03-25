package entities;

import java.io.Serializable;

public class ServiceManger implements Serializable {
    private int capacity;
    private Service service;

    public ServiceManger(int capacity, Service service) {
        this.capacity = capacity;
        this.service = service;
    }

    public int getCapacity() {
        return capacity;
    }

    public Service getService() {
        return service;
    }

    @Override
    public String toString() {
        return "ServiceManager{" +
                "capacity=" + capacity +
                ", service=" + service +
                '}';
    }
}
