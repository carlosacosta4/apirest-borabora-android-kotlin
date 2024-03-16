package pe.borabora.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.borabora.dto.PickupDTO;
import pe.borabora.entity.Headquarter;
import pe.borabora.entity.PickUp;
import pe.borabora.repository.PickUpRepository;
import pe.borabora.service.PickUpService;
@Service
public class PickUpServiceImpl implements PickUpService {

    @Autowired
    private PickUpRepository pickUpRepository;
    @Override
    public PickUp createPickUpOrder(PickupDTO pickUpDTO) {
        PickUp pickUp = new PickUp();
        pickUp.setDate(pickUpDTO.getDate());

        // Obtener el headquarter por su código
        Headquarter headquarter = new Headquarter();
        headquarter.setCod_headquarter(pickUpDTO.getCodHeadquarter());
        pickUp.setHeadquarter(headquarter);

        return pickUpRepository.save(pickUp);
    }
}
