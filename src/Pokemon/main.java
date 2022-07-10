package Pokemon;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static Pokemon.Fight.fight;
import static Pokemon.Fight.status;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Random rng = new Random();
        Scanner sc = new Scanner(System.in);

        Pokemon myPokemon = new Pokemon(rng.nextInt(0,906));
        Pokemon enemy = new Pokemon(rng.nextInt(0, 906));

       fight(myPokemon, enemy);

    }
}
