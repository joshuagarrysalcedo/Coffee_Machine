package machine;

import java.util.Scanner;

public class CoffeeMachine {
    Scanner sc = new Scanner(System.in);
    static CoffeeMachine machine = new CoffeeMachine();
    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int cups = 9;
    static int money = 550;
    public static void main(String[] args) {
       machine.ask(water, milk, coffee, cups, money);

    }

    public  void displayStatus(int water, int milk, int coffee, int cups, int money){
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
        ask(water, milk, coffee, cups, money);
    }

    public void ask(int water, int milk, int coffee, int cups, int money){
        System.out.println("Write action (buy, fill, take, remaining, exit)");
        String action = sc.nextLine();
            switch (action){
                case "buy":
                    buy(water, milk, coffee, cups, money);
                    break;
                case "fill":
                    fill(water, milk, coffee, cups, money);
                    break;
                case "take":
                    take(water, milk, coffee, cups, money);
                    break;
                case "exit":
                    System.exit(0);
                    break;
                case "remaining":
                    displayStatus(water, milk, coffee, cups, money);
                    break;
            }

    }

    public void buy(int water, int milk, int coffee, int cups, int money){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");

            switch (sc.nextLine()){
                case "1":
                    // espresso
                    buy(water, milk, coffee, cups, money , 250, 0, 16, 4);
                    break;
                case "2":
                    //latte
                    buy(water, milk, coffee, cups, money , 350, 75, 20, 7);
                    break;
                case "3":
                    // cappuccino
                    buy(water, milk, coffee, cups, money , 200, 100, 12, 6);
                    break;
                case "back":
                    ask(water, milk, coffee, cups, money);
                    break;
            }
    }

    public void fill(int water, int milk, int coffee, int cups, int money){
        System.out.println("Write how many ml of water you want to add:");
            int waterAdd = sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
            int milkAdd = sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
            int coffeeAdd = sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
            int cupsAdd = sc.nextInt();
            sc.nextLine();
                water += waterAdd;
                milk += milkAdd;
                coffee += coffeeAdd;
                cups += cupsAdd;
        ask(water, milk, coffee, cups, money);

    }
    public void take(int water, int milk, int coffee, int cups, int money){
        System.out.println("I gave you $" + money);
        money = 0;
        ask(water, milk, coffee, cups, money);
    }

    public void buy(int water, int milk, int coffee, int cups, int money , int waterCost,
                    int milkCost, int coffeeCost, int moneyCost){
            if(water >= waterCost && milk >= milkCost && coffee >= coffeeCost && cups != 0){
                water -= waterCost;
                milk -= milkCost;
                coffee -= coffeeCost;
                money += moneyCost;
                cups--;
                System.out.println("I have enough resources, making you a coffee!");
            }
            else{
                if(water < waterCost) System.out.println("Sorry, not enough water!");
                if(milk < milkCost) System.out.println("Sorry, not enough milk!");
                if(coffee < coffeeCost) System.out.println("Sorry, not enough coffee beans!");
                if(cups <= 0) System.out.println("Sorry, not enough cups!");
            }
        ask(water, milk, coffee, cups, money);
    }

}
