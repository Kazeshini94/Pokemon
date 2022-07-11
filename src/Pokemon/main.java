package Pokemon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Random rng = new Random();

        Pokemon myPokemon = new Pokemon("Necrozma","Ultra Necrozma");
        Pokemon enemy = new Pokemon(rng.nextInt(0, 906));

        System.out.println(myPokemon);
        System.out.println("--------------!Fight!---------------");


        myPokemon.fight(enemy);
    }
}
