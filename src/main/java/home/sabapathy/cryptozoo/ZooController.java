package home.sabapathy.cryptozoo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zoo")
public class ZooController {

    @PostMapping("/animals")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnimals(@RequestBody AnimalDto animalDto) {
    }

}
