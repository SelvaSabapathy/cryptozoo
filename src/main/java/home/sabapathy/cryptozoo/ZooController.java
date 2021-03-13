package home.sabapathy.cryptozoo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
}
