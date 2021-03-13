package home.sabapathy.cryptozoo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDto {
    private UUID id;
    private String name;
    private AnimalType type;
    private AnimalMood mood;
}
