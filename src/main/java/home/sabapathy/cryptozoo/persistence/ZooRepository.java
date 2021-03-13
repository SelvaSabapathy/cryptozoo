package home.sabapathy.cryptozoo.persistence;

import home.sabapathy.cryptozoo.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZooRepository extends JpaRepository<Animal, Long> {
}
