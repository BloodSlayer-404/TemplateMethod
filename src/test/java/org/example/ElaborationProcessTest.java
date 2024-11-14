package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElaborationProcessTest {

    private List<String> playerInventory = new ArrayList<>(
            List.of("Raw Meat", "Apple", "Lizard Tail", "Electro Crystal")
    );

    /**
     * Check if the process to synthesize an object works correctly
     */
    @Test
    void materialSynthesisTest(){
        ElaborationProcess synthesis = new MaterialsSynthesis("Insulation Potion",
                List.of("Butterfly Wings", "Electro Crystal"));

        synthesis.setAvailableMaterials(playerInventory);

        assertEquals("Preparation failed! Missing materials: Butterfly Wings.\n", synthesis.doProcess());

        synthesis.addAvailableMaterial("Butterfly Wings");

        assertEquals("All the materials are prepared.\n" +
                        "Synthesizing materials to create a Insulation Potion\n" +
                        "Collecting the Insulation Potion",
                synthesis.doProcess());
    }

    /**
     * Checks if the process to cook a dish work correctly
     */
    @Test
    void cookingTest(){
        ElaborationProcess cooking = new CookADish("Honey Char Siu",
                List.of("Raw Meat", "Sugar"));

        cooking.setAvailableMaterials(playerInventory);

        assertEquals("Preparation failed! Missing materials: Sugar.\n", cooking.doProcess());

        cooking.addAvailableMaterial("Sugar");

        assertEquals("All the materials are prepared.\n" +
                        "Cooking an order of Honey Char Siu\n" +
                        "Collecting the Honey Char Siu",
                cooking.doProcess());

    }

}