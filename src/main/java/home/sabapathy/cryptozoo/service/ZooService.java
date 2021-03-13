package home.sabapathy.cryptozoo.service;

import home.sabapathy.cryptozoo.entity.Animal;
import home.sabapathy.cryptozoo.persistence.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ZooService {
    @Autowired
    private ZooRepository zooRepository;

    public Object create(Animal animal) {
        return zooRepository.save(animal);
    }
}
