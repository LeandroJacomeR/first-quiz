package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine{

  private int money = 0;
  private String drinks[] = {"ScottCola", "KarenTea"};

  public static VendingMachine getInstance() {
    return new VendingMachineImpl();
  }

  @Override
  public void insertQuarter() {
    this.money += 25;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    if (this.money < 75){
      throw new NotEnoughMoneyException();
    }

    if (!isValidDrink(name)) {
      throw new UnknownDrinkException();
    }

    for (int i = 0; i < this.drinks.length; i++) {
      if (this.drinks[i].equals(name) && name.equals("ScottCola")){
        this.money -= 75;
      }
      if (this.drinks[i].equals(name) && name.equals("KarenTea")){
        if (this.money < 100){
          throw new NotEnoughMoneyException();
        }
        this.money -= 100;
      }
    }

    DrinkImpl drink = new DrinkImpl(name);
    return drink;
  }

  private boolean isValidDrink(String name) {
    for (String drink : drinks) {
      if (drink.equalsIgnoreCase(name)) {
        return true;
      }
    }
    return false;
  }
}
