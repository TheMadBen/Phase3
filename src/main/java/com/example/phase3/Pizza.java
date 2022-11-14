package com.example.phase3;

import javafx.scene.control.CheckBox;

public class Pizza {
    boolean pepperoni;
    boolean vegetables;
    boolean cheese;
    boolean mushroom;
    boolean onion;
    boolean olives;
    boolean extraCheese;

    String output = "";

    CheckBox checkBox = new CheckBox();

    public String pizzaToString() {
        String output = "Pizza Type: ";

        if(pepperoni) output += "Pepperoni ";

        if(vegetables) output += "Vegetable";

        if(cheese) output += "Cheese";

        output += "\nToppings: ";

        if(mushroom) output += "Mushroom ";

        if(onion) output += "Onion ";

        if(olives) output += "Olives ";

        if(extraCheese) output += "Extra cheese ";

        if(!mushroom && !onion && !olives && !extraCheese) output+= "None added";

        output += "\n\n";

        return output;

    }
    public Pizza() {
    }

    public Pizza(boolean pepperoni, boolean vegetables, boolean cheese, boolean mushroom, boolean onion, boolean olives, boolean extraCheese) {
        this.pepperoni = pepperoni;
        this.vegetables = vegetables;
        this.cheese = cheese;
        this.mushroom = mushroom;
        this.onion = onion;
        this.olives = olives;
        this.extraCheese = extraCheese;
    }

    public boolean isPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(boolean pepperoni) {
        this.pepperoni = pepperoni;
    }

    public boolean isVegetables() {
        return vegetables;
    }

    public void setVegetables(boolean vegetables) {
        this.vegetables = vegetables;
    }

    public boolean isCheese() {
        return cheese;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public boolean isMushroom() {
        return mushroom;
    }

    public void setMushroom(boolean mushroom) {
        this.mushroom = mushroom;
    }

    public boolean isOnion() {
        return onion;
    }

    public void setOnion(boolean onion) {
        this.onion = onion;
    }

    public boolean isOlives() {
        return olives;
    }

    public void setOlives(boolean olives) {
        this.olives = olives;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
