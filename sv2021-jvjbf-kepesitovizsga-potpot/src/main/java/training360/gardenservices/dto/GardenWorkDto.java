package training360.gardenservices.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GardenWorkDto {


    private Long id;
    private boolean done;
    private String description;
    private String answer;



}
