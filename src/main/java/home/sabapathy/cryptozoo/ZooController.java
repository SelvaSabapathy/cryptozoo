package home.sabapathy.cryptozoo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zoo")
public class ZooController {

    AnimalDto animal;
    @PostMapping("/animals")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnimals(@RequestBody AnimalDto animalDto) {
        this.animal = animalDto;
    }

    @GetMapping("/animals")
    @ResponseStatus(HttpStatus.OK)
    public AnimalDto viewAnimals() {

        return this.animal;
    }

}
