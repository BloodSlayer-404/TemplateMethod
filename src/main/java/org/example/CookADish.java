package org.example;

import java.util.List;

public class CookADish extends ElaborationProcess{
    public CookADish(String name, List<String> necessaryMaterials) {
        super(name, necessaryMaterials);
    }

    @Override
    protected String elaborationProcess() {
        return "Cooking an order of " + getName();
    }
}
