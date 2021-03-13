package home.sabapathy.cryptozoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ZooIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    /**
     * As zookeeper, I want to add animals to my zoo.
     *
     * 	Rule: Animal should have a name and a type (flying, swimming, walking)
     *
     * 	When I add an animalDto
     * 	Then it is in my zoo
     */
    @Test
    public void addAnimalsToMyZoo() throws Exception {
        mockMvc.perform(post("/zoo/animals")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(new AnimalDto()))
        ).andExpect(status().isCreated());
    }

    /**
	 * 	As zookeeper, I want to view animals of my zoo.
	 *
             * 	Given I have added animals to my zoo
	 * 	When I check my zoo
	 * 	Then I see all the animals
	 */

    /**
     *
     * 	As a zookeper, I want to feed my animals.
     *
     * 	Rule: Animal moods are unhappy or happy. They are unhappy by default.
     *
     * 	Given an animal is unhappy
     * 	When I give it a treat
     * 	Then the animal is happy
     *
     * 	Given an animal is happy
     * 	When I give it a treat
     * 	Then the animal is still happy
     */

    /**
     *
     * 	As a zookeeper, I want to maintain different types of habitats so that I can put different types of animals in them.
     *
     * 	Given I have an empty <habitat>
     * 	When I put animal of <type> into a compatible habitat
     * 	Then the animal is in the habitat
     *
     * 	Given I have an empty <habitat>
     * 	When I put animal of <type> into an incompatible habitat
     * 	Then the animal habitat should not change
     * 	And the animal becomes unhappy
     *
     * 	Given I have an occuppied habitat
     * 	When I put an animal into the occupied habitat
     * 	Then the animal habitat should not change
     *
     * |   type  |  habitat  |
     * 			| --------- | --------- |
     * 			| flying     |   nest    |
     * 			| swimming  |   ocean   |
     * 			| walking   |   forest  |
     */

    /**
     *
     * 	As a zookeeper, I want to search zoo data so that I can make reports on my zoo.
     *
     * 	Given I have animals in my zoo
     * 	When I search for <mood> and <type>
     * 	Then I see a list of animals matching only <mood> and <type>
     *
     * 	Given I have habitats in my zoo
     * 	When I search for empty habitats
     * 	Then I see a list of empty habitats
     */

}
