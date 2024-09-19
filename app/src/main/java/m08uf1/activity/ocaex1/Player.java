package m08uf1.activity.ocaex1;

import java.util.Random;
import java.util.Scanner;

public class Player extends Person {
    private String color;
    private int square;
    private int nextTurn = 0;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public Player(String name, String nickname, int age, String color ) {
        super(name, nickname, age);
        this.color = color;
        this.square = 0;
        this.nextTurn = 0;
    }

    @Override
    public String toString() {
        return super.toString() + " Color: " + color;
    }

    public Boolean throwDice(Scanner scanner){
        Random random = new Random();

        if (nextTurn > 0){
            System.out.println("El " + getName() + " No tira aquest turn");
            nextTurn --;
            scanner.nextLine();
            return false;
        }

        System.out.println("Toca tirar a en " + getName());
        scanner.nextLine();
        int dice =  random.nextInt(6)+1;
        int nsquare = square + dice;
        System.out.println("Ha tret un " + dice + " i va a la casella " + nsquare);
        scanner.nextLine();
        if (nsquare == 63 ){
            System.out.println("Felicitats has entrat al jardi de l'oca. Has guanyat!!!");
            square = nsquare;
            scanner.nextLine();
            return false;

        }
        if (nsquare > 63){
            System.out.println(" Has de entrar just al jardí, sinó, et toca retrocedír...");
            square -= nsquare - 63;
            scanner.nextLine();
            return false;
        }
        if (nsquare % 9 == 0 ){
            System.out.println("De oca en oca y tiro por que me toca !!!");
            square = nsquare + 5;
            scanner.nextLine();
            return true;
        }
        if (nsquare % 9 == 5 || nsquare == 1){
            System.out.println("De oca en oca y tiro por que me toca !!!");
            square = nsquare + 4;
            scanner.nextLine();
            return true;
        }
        if (nsquare == 6 || nsquare == 12 ){
            System.out.println("Desde el pont...");
            nsquare = 19;
            scanner.nextLine();
        }
        if (nsquare == 19){
            System.out.println("Has caigut a la taberna, tocara descansar un temps...");
            square = nsquare;
            nextTurn = 1;
            scanner.nextLine();
            return false;
        }
        if ( nsquare == 42 ){
            System.out.println("Has caigut al laberint, toca tornar enrera..");
            square = 30;
            scanner.nextLine();
            return false;
        }
        if ( nsquare == 26 || nsquare == 53){
            System.out.println("Toca avançar...");
            square = (nsquare / 10) + (nsquare % 10);
            scanner.nextLine();
            return false;
        }
        if (nsquare == 58){
            System.out.println("La calavera, ja ho tenies però la vida és injusta, et toca tornar a començar...");
            square = 1;
            scanner.nextLine();
            return false;
        }
        if (nsquare == 56){
            System.out.println("Has caigut a la presó dos torns sense tirar");
            square = nsquare;
            nextTurn = 2;
            scanner.nextLine();
            return false;
        }
        else {
            square = nsquare;
            return false;
        }
    }
}
