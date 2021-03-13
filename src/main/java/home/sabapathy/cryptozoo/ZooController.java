package home.sabapathy.cryptozoo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zoo")
public class ZooController {

    List<AnimalDto> animalDtos = new ArrayList<>();

    @PostMapping("/animals")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnimals(@RequestBody AnimalDto animalDto) {
        this.animalDtos.add(animalDto);
    }

    @GetMapping("/animals")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDto> viewAnimals() {
        return this.animalDtos;
    }

    @PatchMapping("/animals")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<AnimalDto> feedAnimals(@RequestBody AnimalTreatDto animalTreatDto) {
        List<AnimalDto> animalDtoList = this.animalDtos.stream().filter(a -> a.getId().equals(animalTreatDto.getId())).collect(Collectors.toList());
        if (animalDtoList.size() > 0) {
            animalDtoList.get(0).setMood(animalTreatDto.getAnimalTreat() == AnimalTreat.YES ? AnimalMood.HAPPY : AnimalMood.SAD);
        }
        return this.animalDtos;
    }
}
