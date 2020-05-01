package lakomika.matiibal.webservicestudent.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private Long index;
    private String city;
    private String numberOfFlat;
    private String postalCode;
    private String town;
    private String phoneNumber;

}
