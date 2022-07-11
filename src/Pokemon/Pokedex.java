package Pokemon;

import java.io.*;
import java.util.*;

public abstract class Pokedex {
    //    Order in the CSV File Pokedex!
    //    ID,Name,Form,Type1,Type2,
    //    Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation
    public final String name, form, type1, type2;
    public final int id, total, maxHp, atk, def, spAtk, spDef, speed, gen;
    public int hp;

    // Order in Skills.Csv
    // Id , Form , Name , Ability 1, Ability 2
    public final String[] ability = new String[2];

     public Pokedex(int id) throws IOException {
        BufferedReader pokedex = new BufferedReader(new FileReader("files/Pokedex.csv"));
        BufferedReader abilityReader = new BufferedReader(new FileReader("files/skills.csv"));
        int size = 0;
        while (id != size) {
            pokedex.readLine();
            abilityReader.readLine();
            size++;
        }
        String input = pokedex.readLine();
        String[] value = input.split(",");
        String skill = abilityReader.readLine();
        String[] skills = skill.split(",");

        this.name = value[1];
        this.form = value[2];
        this.type1 = value[3];
        this.type2 = value[4];
        this.id = Integer.parseInt(value[0]);
        this.total = Integer.parseInt(value[5]);
        this.maxHp = Integer.parseInt(value[6]);
        this.hp = Integer.parseInt(value[6]);
        this.atk = Integer.parseInt(value[7]);
        this.def = Integer.parseInt(value[8]);
        this.spAtk = Integer.parseInt(value[9]);
        this.spDef = Integer.parseInt(value[10]);
        this.speed = Integer.parseInt(value[11]);
        this.gen = Integer.parseInt(value[12]);
        this.ability[0] = skills[3];
        try {
            this.ability[1] = skills[4];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.ability[1] = "";
        }
    }
    public Pokedex(String name) throws IOException {
        BufferedReader pokedex = new BufferedReader(new FileReader("files/Pokedex.csv"));
        BufferedReader abilityReader = new BufferedReader(new FileReader("files/skills.csv"));
        String[] value, skills;
        do {
            String input = pokedex.readLine();
            value = input.split(",");
            String skill = abilityReader.readLine();
            skills = skill.split(",");
        } while (!value[1].equalsIgnoreCase(name) || skills[2].equalsIgnoreCase(name));

        this.name = value[1];
        this.form = value[2];
        this.type1 = value[3];
        this.type2 = value[4];
        this.id = Integer.parseInt(value[0]);
        this.total = Integer.parseInt(value[5]);
        this.maxHp = Integer.parseInt(value[6]);
        this.hp = Integer.parseInt(value[6]);
        this.atk = Integer.parseInt(value[7]);
        this.def = Integer.parseInt(value[8]);
        this.spAtk = Integer.parseInt(value[9]);
        this.spDef = Integer.parseInt(value[10]);
        this.speed = Integer.parseInt(value[11]);
        this.gen = Integer.parseInt(value[12]);
        this.ability[0] = skills[3];
        try {
            this.ability[1] = skills[4];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.ability[1] = "";
        }
    }

    // Extra for the different Forms !
    public Pokedex(String name, String form) throws IOException {
        BufferedReader pokedex = new BufferedReader(new FileReader("files/Pokedex.csv"));
        BufferedReader abilityReader = new BufferedReader(new FileReader("files/skills.csv"));
        String[] value, skills;
        do {
            String input = pokedex.readLine();
            value = input.split(",");
            String skill = abilityReader.readLine();
            skills = skill.split(",");
        } while (!value[2].equalsIgnoreCase(form) || skills[1].equalsIgnoreCase(form));

        this.name = value[1];
        this.form = value[2];
        this.type1 = value[3];
        this.type2 = value[4];
        this.id = Integer.parseInt(value[0]);
        this.total = Integer.parseInt(value[5]);
        this.maxHp = Integer.parseInt(value[6]);
        this.hp = Integer.parseInt(value[6]);
        this.atk = Integer.parseInt(value[7]);
        this.def = Integer.parseInt(value[8]);
        this.spAtk = Integer.parseInt(value[9]);
        this.spDef = Integer.parseInt(value[10]);
        this.speed = Integer.parseInt(value[11]);
        this.gen = Integer.parseInt(value[12]);
        this.ability[0] = skills[3];
        try {
            this.ability[1] = skills[4];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.ability[1] = "";
        }
    }

    // Implementing Type Advantages below !!
    public double typeAdvantage1(Pokemon trainer, Pokemon enemy) throws IOException {
        // TypeAdvantage Csv Order
        // BaseType vs,Normal,Fire,Water,Electric,Grass,Ice,Fighting,Poison,
        // Ground,Flying,Psychic,Bug,Rock,Ghost,Dragon,Dark,Steel,Fairy
        BufferedReader typeAdvantage = new BufferedReader(new FileReader("files/TypeAdvantage.csv"));

        String[] type;
        double advantage = 0;
        do {
            String input = typeAdvantage.readLine();
            type = input.split(",");
        } while (!type[0].equalsIgnoreCase(trainer.getType1()));
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

    public double typeAdvantage2(Pokemon trainer, Pokemon enemy) throws IOException {
        // If there is No second Type return 1 because *1 stays the same !
        if (trainer.getType2().equalsIgnoreCase("")) {
            return 1;
        }

        // TypeAdvantage Csv Order
        // BaseType vs,Normal,Fire,Water,Electric,Grass,Ice,Fighting,Poison,
        // Ground,Flying,Psychic,Bug,Rock,Ghost,Dragon,Dark,Steel,Fairy
        BufferedReader typeAdvantage = new BufferedReader(new FileReader("files/TypeAdvantage.csv"));
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
    // Calculating the Dmg
    public int dmgCalculation(Pokemon trainer, Pokemon enemy) throws IOException {
        Random rng = new Random();
        double attAdvantage1, defAdvantage1, attAdvantage2, defAdvantage2;
        attAdvantage1 = typeAdvantage1(trainer, enemy);
        attAdvantage2 = typeAdvantage2(trainer, enemy);
        defAdvantage1 = typeAdvantage1(enemy, trainer);
        defAdvantage2 = typeAdvantage2(enemy, trainer);
        return (int) ((trainer.getAtk() * rng.nextDouble(1.01) * attAdvantage1 * attAdvantage2)
                - (enemy.getDef() * rng.nextDouble(0.501) * defAdvantage1 * defAdvantage2));
    }

}
