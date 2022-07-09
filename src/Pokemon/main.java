package Pokemon;

import java.io.*;
import java.util.Random;

public class main {
    public static void main(String[] args) throws IOException {

        Random rng = new Random();

        Pokemon myPokemon = new Pokemon("Eternatus","Eternamax");
        Pokemon enemy = new Pokemon(rng.nextInt(0,906));


    }
}
