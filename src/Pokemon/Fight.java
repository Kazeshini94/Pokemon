package Pokemon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Fight {

    String myAbility1, myAbility2, enemyAbility1, enemyAbility2;

    public static void fight(Pokemon trainer, Pokemon enemy) throws InterruptedException, IOException {
        status(trainer,enemy);

        Random rng = new Random();
        Scanner sc = new Scanner(System.in);
        int use, dmg;
        while (trainer.getHp() > 0 || enemy.getHp() > 0) {
            System.out.println("\nWhich Skill do you want to Use?");
            do {
                use = sc.nextInt();
                dmg = dmgCalculation(trainer, enemy);
                switch (use) {
                    case 1 -> System.out.println(trainer.getName() + " attacks with " + trainer.getAbility1() + ".\n" +
                            trainer.getName() + " deals " + dmg + " Dmg!");
                    case 2 -> System.out.println(trainer.getName() + " attacks with " + trainer.getAbility2() + ".\n" +
                            trainer.getName() + " deals " + dmg + " Dmg!");
                    default -> System.out.println("Error! Use 1 or 2!");
                }
            } while (use < 0 || use > 2);

            if (dmg > 0) {
                enemy.setHp(enemy.getHp() - dmg);
                if (dmg > 50) {
                    System.out.println("Critical Hit!");
                }
                if (dmg > 25) {
                    System.out.println("Good Hit");
                }
            }
            if (enemy.getHp() <= 0) {
                System.out.println("Enemy Defeated");
                return;
            }
            System.out.println("Enemy Turn!");
            Thread.sleep(1000);

            use = rng.nextInt(1, 3);
            dmg = dmgCalculation(enemy, trainer);
            switch (use) {
                case 1 -> System.out.println(enemy.getName() + " attacks with " + enemy.getAbility1() + ".\n" +
                        enemy.getName() + " deals " + dmg + " Dmg!");
                case 2 -> System.out.println(enemy.getName() + " attacks with " + enemy.getAbility2() + ".\n" +
                        enemy.getName() + " deals " + dmg + " Dmg!");
            }

            if (dmg > 0) {
                trainer.setHp(trainer.getHp() - dmg);
                if (dmg > 25) {
                    System.out.println("Good Hit");
                }
                if (dmg > 50) {
                    System.out.println("Critical Hit!");
                }
            }
            if (trainer.getHp() <= 0) {
                System.out.println("You Lost the Fight!");
                return;
            }

            Thread.sleep(1000);
            status(trainer, enemy);
        }
    }
    public static void status(Pokemon trainer, Pokemon enemy) {
        System.out.printf("%s %s %d %s %s %s %d %s %s %s %s %s",
                trainer.getName(),"(",trainer.getHp(),")",
                enemy.getName(),"(",enemy.getHp(),")",
                "\n", Arrays.toString(trainer.getAbility()),
                "\n", Arrays.toString(enemy.getAbility()));
    }

    public static int dmgCalculation(Pokemon trainer, Pokemon enemy) throws IOException {
        Random rng = new Random();
        double attAdvantage1 = 0, defAdvantage1 = 0, attAdvantage2 = 0, defAdvantage2 = 0;
        attAdvantage1 = typeAdvantage1(trainer, enemy);
        defAdvantage1 = typeAdvantage1(enemy, trainer);
        attAdvantage2 = typeAdvantage2(trainer, enemy);
        defAdvantage2 = typeAdvantage2(enemy, trainer);
        return (int)(trainer.getAtk() * rng.nextDouble(1) * attAdvantage1 * attAdvantage2
                - enemy.getDef() * rng.nextDouble(0.5) * defAdvantage1 * defAdvantage2);
    }

    // Implementing Type Advantages below !!
    public static double typeAdvantage1(Pokemon trainer, Pokemon enemy) throws IOException {
        BufferedReader typeAdvantage = new BufferedReader(new FileReader("files/TypeAdvantage.csv"));

        // TypeAdvantage Csv Order
        // BaseType vs,Normal,Fire,Water,Electric,Grass,Ice,Fighting,Poison,
        // Ground,Flying,Psychic,Bug,Rock,Ghost,Dragon,Dark,Steel,Fairy

        String[] type;
        double advantage = 0;
        do {
            String input = typeAdvantage.readLine();
            type = input.split(",");
        } while (!type[0].equalsIgnoreCase(trainer.getType1()) );
        // Vs Normal
        if (enemy.getType1().equalsIgnoreCase("Normal")) {
            advantage = Double.parseDouble(type[1]);
        }
        // VS Fire
        if (enemy.getType1().equalsIgnoreCase("Fire")) {
            advantage = Double.parseDouble(type[2]);
        }
        // Vs Water
        if (enemy.getType1().equalsIgnoreCase("Water")) {
            advantage = Double.parseDouble(type[3]);
        }
        // Vs Electric
        if (enemy.getType1().equalsIgnoreCase("Electric")) {
            advantage = Double.parseDouble(type[4]);
        }
        // Vs Grass
        if (enemy.getType1().equalsIgnoreCase("Grass")) {
            advantage = Double.parseDouble(type[5]);
        }
        // Vs Ice
        if (enemy.getType1().equalsIgnoreCase("Ice")) {
            advantage = Double.parseDouble(type[6]);
        }
        // Vs Fighting
        if (enemy.getType1().equalsIgnoreCase("Fighting")) {
            advantage = Double.parseDouble(type[7]);
        }
        // Vs Poison
        if (enemy.getType1().equalsIgnoreCase("Poison")) {
            advantage = Double.parseDouble(type[8]);
        }
        // Vs Ground
        if (enemy.getType1().equalsIgnoreCase("Ground")) {
            advantage = Double.parseDouble(type[9]);
        }
        // Vs Flying
        if (enemy.getType1().equalsIgnoreCase("Flying")) {
            advantage = Double.parseDouble(type[10]);
        }
        // Vs Psychic
        if (enemy.getType1().equalsIgnoreCase("Psychic")) {
            advantage = Double.parseDouble(type[11]);
        }
        // Vs Bug
        if (enemy.getType1().equalsIgnoreCase("Bug")) {
            advantage = Double.parseDouble(type[12]);
        }
        // Vs Rock
        if (enemy.getType1().equalsIgnoreCase("Rock")) {
            advantage = Double.parseDouble(type[13]);
        }
        // Vs Ghost
        if (enemy.getType1().equalsIgnoreCase("Ghost")) {
            advantage = Double.parseDouble(type[14]);
        }
        // Vs Dragon
        if (enemy.getType1().equalsIgnoreCase("Dragon")) {
            advantage = Double.parseDouble(type[15]);
        }
        // Vs Dark
        if (enemy.getType1().equalsIgnoreCase("Dark")) {
            advantage = Double.parseDouble(type[16]);
        }
        // Vs Steel
        if (enemy.getType1().equalsIgnoreCase("Steel")) {
            advantage = Double.parseDouble(type[17]);
        }
        // Vs Fairy
        if (enemy.getType1().equalsIgnoreCase("Fairy")) {
            advantage = Double.parseDouble(type[18]);
        }
        return advantage;
    }
    public static double typeAdvantage2(Pokemon trainer, Pokemon enemy) throws IOException {
        BufferedReader typeAdvantage = new BufferedReader(new FileReader("files/TypeAdvantage.csv"));
        // TypeAdvantage Csv Order
        // BaseType vs,Normal,Fire,Water,Electric,Grass,Ice,Fighting,Poison,
        // Ground,Flying,Psychic,Bug,Rock,Ghost,Dragon,Dark,Steel,Fairy

        // If there is No second Type return 1 because *1 stays the same !
        if (trainer.getType2().equalsIgnoreCase(" ")) {
            return 1;
        }

        String[] type;
        double advantage = 0;
        do {
            String input = typeAdvantage.readLine();
            type = input.split(",");
        } while (!type[0].equalsIgnoreCase(trainer.getType2()));
        // Vs Normal
        if (enemy.getType2().equalsIgnoreCase("Normal")) {
            advantage = Double.parseDouble(type[1]);
        }
        // VS Fire
        if (enemy.getType2().equalsIgnoreCase("Fire")) {
            advantage = Double.parseDouble(type[2]);
        }
        // Vs Water
        if (enemy.getType2().equalsIgnoreCase("Water")) {
            advantage = Double.parseDouble(type[3]);
        }
        // Vs Electric
        if (enemy.getType2().equalsIgnoreCase("Electric")) {
            advantage = Double.parseDouble(type[4]);
        }
        // Vs Grass
        if (enemy.getType2().equalsIgnoreCase("Grass")) {
            advantage = Double.parseDouble(type[5]);
        }
        // Vs Ice
        if (enemy.getType2().equalsIgnoreCase("Ice")) {
            advantage = Double.parseDouble(type[6]);
        }
        // Vs Fighting
        if (enemy.getType2().equalsIgnoreCase("Fighting")) {
            advantage = Double.parseDouble(type[7]);
        }
        // Vs Poison
        if (enemy.getType2().equalsIgnoreCase("Poison")) {
            advantage = Double.parseDouble(type[8]);
        }
        // Vs Ground
        if (enemy.getType2().equalsIgnoreCase("Ground")) {
            advantage = Double.parseDouble(type[9]);
        }
        // Vs Flying
        if (enemy.getType2().equalsIgnoreCase("Flying")) {
            advantage = Double.parseDouble(type[10]);
        }
        // Vs Psychic
        if (enemy.getType2().equalsIgnoreCase("Psychic")) {
            advantage = Double.parseDouble(type[11]);
        }
        // Vs Bug
        if (enemy.getType2().equalsIgnoreCase("Bug")) {
            advantage = Double.parseDouble(type[12]);
        }
        // Vs Rock
        if (enemy.getType2().equalsIgnoreCase("Rock")) {
            advantage = Double.parseDouble(type[13]);
        }
        // Vs Ghost
        if (enemy.getType2().equalsIgnoreCase("Ghost")) {
            advantage = Double.parseDouble(type[14]);
        }
        // Vs Dragon
        if (enemy.getType2().equalsIgnoreCase("Dragon")) {
            advantage = Double.parseDouble(type[15]);
        }
        // Vs Dark
        if (enemy.getType2().equalsIgnoreCase("Dark")) {
            advantage = Double.parseDouble(type[16]);
        }
        // Vs Steel
        if (enemy.getType2().equalsIgnoreCase("Steel")) {
            advantage = Double.parseDouble(type[17]);
        }
        // Vs Fairy
        if (enemy.getType2().equalsIgnoreCase("Fairy")) {
            advantage = Double.parseDouble(type[18]);
        }
        if (advantage <= 0) {
            return 1;
        } else return advantage;
    }
}