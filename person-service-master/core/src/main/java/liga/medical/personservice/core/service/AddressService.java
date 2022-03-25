package liga.medical.personservice.core.service;


import liga.medical.personservice.core.model.AddressEntity;
import liga.medical.personservice.core.model.AddressEntity;
import liga.medical.personservice.core.repository.AddressRepository;
import liga.medical.personservice.core.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public void insert( AddressEntity address) {
        addressRepository.insert(address);
    }

    public void insertAll(List<AddressEntity> addressEntityList) {
        addressRepository.insertAll(addressEntityList);
    }

    public AddressEntity getAddressById( Long id) {
        return addressRepository.findById(id);
    }

    public List<AddressEntity> getAddressByIds(@RequestParam List<Long> ids) {
        return addressRepository.findByIds(ids);
    }
}