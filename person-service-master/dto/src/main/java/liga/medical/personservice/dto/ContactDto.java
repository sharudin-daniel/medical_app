package liga.medical.personservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {
    private  String phoneNumber;

    private String email;

    private String profileLink;
}
