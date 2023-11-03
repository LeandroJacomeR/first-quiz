package org.velezreyes.quiz.question6;

public class DrinkImpl implements Drink{

    private String name;

    public DrinkImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isFizzy() {
        if (this.name.equals("ScottCola")){
            return true;
        } else {
            return false;
        }
    }
}
