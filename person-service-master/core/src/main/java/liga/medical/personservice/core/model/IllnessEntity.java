package liga.medical.personservice.core.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class IllnessEntity {
    private Long id;

    private Long medicalCardId;

    private Long typeId;

    private Character hearviness;

    private LocalDateTime appearanceDateTime;

    private LocalDate recoveryDate;

}
