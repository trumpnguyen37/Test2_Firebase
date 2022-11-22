package com.example.baiktra2;

import java.io.Serializable;

public class Tree implements Serializable {
    String name, scienceName, nature, leafColor;

    public Tree() {
    }

    public Tree(String name, String scienceName, String nature, String leafColor) {
        this.name = name;
        this.scienceName = scienceName;
        this.nature = nature;
        this.leafColor = leafColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScienceName() {
        return scienceName;
    }

    public void setScienceName(String scienceName) {
        this.scienceName = scienceName;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getLeafColor() {
        return leafColor;
    }

    public void setLeafColor(String leafColor) {
        this.leafColor = leafColor;
    }
}
