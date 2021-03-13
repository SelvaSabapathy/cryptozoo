package home.sabapathy.cryptozoo.service;

import home.sabapathy.cryptozoo.entity.Animal;
import home.sabapathy.cryptozoo.persistence.ZooRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ZooServiceTest {
    @Mock
    private ZooRepository zooRepository;

    @InjectMocks
    private ZooService zooService;

    @Test
    public void create() {
        Animal animal = new Animal();
        zooService.create(animal);
        verify(zooRepository).save(animal);
    }
}
