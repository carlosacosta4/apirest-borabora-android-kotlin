package pe.borabora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.borabora.entity.Delivery;
import pe.borabora.entity.District;
import pe.borabora.entity.PickUp;
import pe.borabora.repository.DeliveryRepository;
import pe.borabora.repository.PickUpRepository;
@Service
public class OrderService{
    @Autowired
    private PickUpRepository pickUpRepository;
    @Autowired
    private DeliveryRepository deliveryRepository;

    public void createPickUpOrder(String date) {
        PickUp pickUp = new PickUp(date);
        pickUpRepository.save(pickUp);
    }

    public void createDeliveryOrder(String address, String date, String department, District district, String province, Integer ubigeo) {
        Delivery delivery = new Delivery(address, date, department, district, province, ubigeo);
        deliveryRepository.save(delivery);
    }
}
