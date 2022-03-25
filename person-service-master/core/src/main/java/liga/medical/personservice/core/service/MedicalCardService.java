package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.MedicalCardEntity;
import liga.medical.personservice.core.repository.MedicalCardRepository;
import liga.medical.personservice.dto.MedicalCardDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicalCardService {

    private final MedicalCardRepository medicalCardRepository;

    public void insert( MedicalCardEntity medicalCard) {
        medicalCardRepository.insert(medicalCard);
    }

    public void insertAll(List<MedicalCardEntity> cardEntityList) {
        medicalCardRepository.insertAll(cardEntityList);
    }

    public MedicalCardEntity getCardById( Long id) {
        return medicalCardRepository.findById(id);
    }

    public List<MedicalCardEntity> getCardByIds(@RequestParam List<Long> ids) {
        return medicalCardRepository.findByIds(ids);
    }
}
