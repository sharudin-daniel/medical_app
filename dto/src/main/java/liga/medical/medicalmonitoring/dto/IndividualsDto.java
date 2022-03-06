package liga.medical.medicalmonitoring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Individuals {

    @Id
    private Long id;

    private String name;

    private Integer age;

    private String address;

    private OffsetDateTime birthdayDt;

    private String birthPlace;

    private String registration;

    private String passportSeries;

    private String passportNumber;

    private String phoneNumber;

    private String anotherDocument;

    private String bankAccount;
}
