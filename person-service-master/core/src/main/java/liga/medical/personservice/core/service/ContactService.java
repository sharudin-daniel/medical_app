package liga.medical.personservice.core.service;


import liga.medical.personservice.core.model.ContactEntity;
import liga.medical.personservice.core.model.ContactEntity;
import liga.medical.personservice.core.repository.ContactRepository;
import liga.medical.personservice.core.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public void insert( ContactEntity contact) {
        contactRepository.insert(contact);
    }

    public void insertAll(List<ContactEntity> contactEntityList) {
        contactRepository.insertAll(contactEntityList);
    }

    public ContactEntity getContactById( Long id) {
        return contactRepository.findById(id);
    }

    public List<ContactEntity> getContactByIds(@RequestParam List<Long> ids) {
        return contactRepository.findByIds(ids);
    }
}