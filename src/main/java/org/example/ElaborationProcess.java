package org.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
public abstract class ElaborationProcess {

    @Getter
    private final String name;
    @Setter
    private List<String> availableMaterials;
    private final List<String> necessaryMaterials;

    /**
     * Add a material to the available materials list
     * @param material: The material to be added to the list
     */
    public void addAvailableMaterial(String material){
        availableMaterials.add(material);
    }

    /**
     * Template method that defines the complete flow of the elaboration process
     * @return A String describing the elaboration process
     */
    public final String  doProcess() {
        StringBuilder result = new StringBuilder();

        String materials = prepareMaterials();
        result.append(materials).append("\n");

        if (materials.contains("Missing materials")){
            return result.toString();
        }

        result.append(elaborationProcess()).append("\n");
        result.append(collectResult());
        return result.toString();
    }

    /**
     * Concrete method that verifies whether the necessary ingredients are available
     * @return A String indicating the missing materials or if all the materials are prepared
     */
    private String prepareMaterials() {
        for (String material : necessaryMaterials) {
            if (!availableMaterials.contains(material)) {
                return "Preparation failed! Missing materials: " + material + ".";
            }
        }
        return "All the materials are prepared.";
    }

    /**
     * Abstract method that each specific process must implement
     * @return The implementation of the specific process for the elaboration of something
     */
    protected abstract String elaborationProcess();

    /**
     * Common concrete method that collects the final result
     * @return "Collecting the final product."
     */
    private String collectResult() {
        return "Collecting the " + name;
    }

}
