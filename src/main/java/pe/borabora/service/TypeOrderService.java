package pe.borabora.service;

import pe.borabora.entity.District;
import pe.borabora.entity.Headquarter;
import pe.borabora.entity.TypeOrder;

public interface TypeOrderService {
    void createPickUpOrder(String date, Headquarter headquarter);
    void createDeliveryOrder(String address, String date, String department, District district, String province, Integer ubigeo);
    TypeOrder getTypeOrderById(Integer typeOrderId);
}
