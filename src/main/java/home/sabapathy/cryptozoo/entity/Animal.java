package home.sabapathy.cryptozoo.entity;

import home.sabapathy.cryptozoo.model.AnimalMood;
import home.sabapathy.cryptozoo.model.AnimalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private AnimalType type;
    private AnimalMood mood;
}

