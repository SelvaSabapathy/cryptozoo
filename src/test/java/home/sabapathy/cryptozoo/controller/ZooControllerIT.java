package home.sabapathy.cryptozoo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import home.sabapathy.cryptozoo.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ZooControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    /**
     *  As zookeeper, I want to add animals to my zoo.
     *
     * 	Rule: Animal should have a name and a type (flying, swimming, walking)     *
     *
     * 	When I add an animalDto
     * 	Then it is in my zoo
     */
    @Test
    public void addAnimalsToMyZoo() throws Exception {
        AnimalDto animalDto = new AnimalDto(UUID.randomUUID(), "Camel", AnimalType.WALKING, AnimalMood.UNHAPPY);
        mockMvc.perform(post("/zoo/animals")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(animalDto))
        ).andExpect(status().isCreated());
    }

    /**
	 * 	As zookeeper, I want to view animals of my zoo.
	 *
     * 	Given I have added animals to my zoo
	 * 	When I check my zoo
	 * 	Then I see all the animals
	 */
    @Test
    public void viewAnimalsOfMyZoo() throws Exception {
        mockMvc.perform(get("/zoo/animals")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    public void addAndViewAnimalsOfMyZoo() throws Exception {
        AnimalDto animalDto = new AnimalDto(UUID.randomUUID(), "Zebra", AnimalType.WALKING, AnimalMood.UNHAPPY);
        mockMvc.perform(post("/zoo/animals")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(animalDto))
        ).andExpect(status().isCreated());

        mockMvc.perform(get("/zoo/animals")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        //        ).andExpect(jsonPath("length()").value(1));
    }

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
    @Test
    public void unhappyAnimalMoodsAfterTreat() throws Exception {
        AnimalDto animalDto = new AnimalDto(UUID.randomUUID(), "Horse", AnimalType.WALKING, AnimalMood.UNHAPPY);
        mockMvc.perform(post("/zoo/animals")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(animalDto))
        ).andExpect(status().isCreated());

        AnimalTreatDto animalTreatDto = new AnimalTreatDto(animalDto.getId(), AnimalTreat.YES);
        mockMvc.perform(patch("/zoo/animals")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(animalTreatDto))
        ).andDo(print()
        ).andExpect(status().isNoContent()
        );
    }

    @Test
    public void happyAnimalMoodsAfterTreat() throws Exception {
        AnimalDto animalDto = new AnimalDto(UUID.randomUUID(), "Dolphin", AnimalType.SWIMMING, AnimalMood.HAPPY);
        mockMvc.perform(post("/zoo/animals")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(animalDto))
        ).andExpect(status().isCreated());

        AnimalTreatDto animalTreatDto = new AnimalTreatDto(animalDto.getId(), AnimalTreat.YES);
        mockMvc.perform(patch("/zoo/animals")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(animalTreatDto))
        ).andDo(print()
        ).andExpect(status().isNoContent()
        );
    }

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
