package home.sabapathy.cryptozoo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalTreatDto {
    private UUID id;
    private AnimalTreat animalTreat;
}
