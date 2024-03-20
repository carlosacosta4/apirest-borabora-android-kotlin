package pe.borabora.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.borabora.entity.*;
import pe.borabora.repository.DeliveryRepository;
import pe.borabora.repository.PickUpRepository;
import pe.borabora.repository.TypeOrderRepository;
import pe.borabora.service.TypeOrderService;

@Service
public class TypeOrderServiceImpl implements TypeOrderService {
    @Autowired
    private PickUpRepository pickUpRepository;
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private TypeOrderRepository typeOrderRepository;

    @Override
    public void createPickUpOrder(String date, Headquarter headquarter) {
        PickUp pickUp = new PickUp(date, headquarter);
        pickUpRepository.save(pickUp);
    }

    @Override
    public void createDeliveryOrder(String address, String date, String department, District district, String province, Integer ubigeo) {
        Delivery delivery = new Delivery(address, date, department, district, province, ubigeo);
        deliveryRepository.save(delivery);
    }

    @Override
    public TypeOrder getTypeOrderById(Integer typeOrderId) {
        return typeOrderRepository.findById(typeOrderId).orElse(null);
    }
}
