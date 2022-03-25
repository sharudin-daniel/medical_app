package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.IllnessEntity;
import liga.medical.personservice.core.repository.IllnessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IllnessService {
    private final IllnessRepository illnessRepository;

    public void insert( IllnessEntity illness) {
        illnessRepository.insert(illness);
    }
     public void insertAll(List<IllnessEntity> illnessEntityList) {
        illnessRepository.insertAll(illnessEntityList);
    }

    public IllnessEntity getIllnessById( Long id) {
        return illnessRepository.findById(id);
    }

    public List<IllnessEntity> getIllnessByIds(@RequestParam List<Long> ids) {
        return illnessRepository.findByIds(ids);
    }
}
