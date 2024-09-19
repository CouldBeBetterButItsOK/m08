package m08uf1.activity.ocaex1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Joc implements Resultat{
    @Override
    public String getWinnerPlayer() {
        return winnerPlayer;
    }

    int playersnumber;
    Scanner scanner = new Scanner(System.in);
    List <Player> players = new ArrayList<>();
    Set<String> usedColors = new HashSet<>();
    Boolean winner = false;
    String winnerPlayer;

    public Joc(int playersnumber){
        this.playersnumber = playersnumber;
    }

    public void start(){
        for (int i = 0; i < playersnumber; i++){

            System.out.println("Afegint nou jugador");
            scanner.nextLine();
            System.out.println("Nom: ");
            String name = scanner.nextLine();
            System.out.println("Nickname: ");
            String nickname = scanner.nextLine();
            System.out.println("Edat: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Color: ");
            String color = scanner.nextLine();
            while (usedColors.contains(color)){
                System.out.println("Aquest color ja existeix. Torna-ho a probar: ");
                color = scanner.nextLine();
            }
            usedColors.add(color);
            Player p = new Player(name, nickname, age, color);
            players.add(p);

            System.out.println(p);
            scanner.nextLine();
        }
    }

    public void jugar(){
        System.out.println("Comença la partida!");
        scanner.nextLine();

        while (!winner){
            Iterator<Player> iterator = players.iterator();
            while(iterator.hasNext() && !winner){
            Player p = iterator.next();
            Boolean turn = true;
            while (turn) {
             turn = p.throwDice(scanner);
            }
            if (p.getSquare() == 63) {
                winner = true;
                winnerPlayer = p.getName();
                System.out.println("S'ha acabat la partida !!!");
            }
            }
        }
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()){
            Player p = iterator.next();
            System.out.println(p.getName() + "         " + p.getSquare());
        }
    }


    }

