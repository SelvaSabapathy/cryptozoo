package home.sabapathy.cryptozoo.service;

import home.sabapathy.cryptozoo.entity.Animal;
import home.sabapathy.cryptozoo.persistence.ZooRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    public void viewAllAnimals()
    {
        Animal animal = new Animal();
        when(zooRepository.findAll()).thenReturn(
                Arrays.asList(animal, new Animal()));

        List<Animal> animals = zooService.viewAll();

        assertThat(animals).isEqualTo(
                Arrays.asList(
                        new Animal(),
                        new Animal()
                )
        );

    }
}
