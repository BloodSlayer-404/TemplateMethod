package org.example;

import java.util.List;

public class MaterialsSynthesis extends ElaborationProcess{


    public MaterialsSynthesis(String name, List<String> necessaryMaterials) {
        super(name, necessaryMaterials);
    }

    @Override
    protected String elaborationProcess() {
        return "Synthesizing materials to create a " + getName();
    }
}
