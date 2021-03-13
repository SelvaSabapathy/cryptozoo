package home.sabapathy.cryptozoo.service;

import home.sabapathy.cryptozoo.entity.Animal;
import home.sabapathy.cryptozoo.model.AnimalDto;
import home.sabapathy.cryptozoo.persistence.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ZooService {
    @Autowired
    private ZooRepository zooRepository;

    public Object create(Animal animal) {
        return zooRepository.save(animal);
    }

    public List<Animal> viewAll() {
        return zooRepository.findAll();
    }
}
