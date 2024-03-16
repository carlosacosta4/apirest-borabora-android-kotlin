package pe.borabora.service;

import pe.borabora.dto.PickupDTO;
import pe.borabora.entity.PickUp;

public interface PickUpService {
    PickUp createPickUpOrder(PickupDTO pickUpDTO);
}
