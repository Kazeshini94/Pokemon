package Pokemon;

import java.io.*;
import java.util.Arrays;

public class Pokemon {
    //    Order in the CSV File Pokedex!
    //    ID,Name,Form,Type1,Type2,
    //    Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation
    private final String name, form, type1, type2;
    private final int id, total, atk, def, spAtk, spDef, speed, gen;
    private int hp;

    // Order in Skills.Csv
    // Id , Form , Name , Ability 1, Ability 2
    private final String[] ability = new String[2];

    BufferedReader reader = new BufferedReader(new FileReader("files/Pokedex.csv"));
    BufferedReader abilityReader = new BufferedReader(new FileReader("files/skills.csv"));

    // Constructor through  Pokemon ID !!
    public Pokemon(int id) throws IOException {
        int size = 0;
        while (id != size) {
            reader.readLine();
            abilityReader.readLine();
            size++;
        }
        String input = reader.readLine();
        String[] value = input.split(",");
        String skill = abilityReader.readLine();
        String[] skills = skill.split(",");

        this.name = value[1];
        this.form = value[2];
        this.type1 = value[3];
        this.type2 = value[4];
        this.id = Integer.parseInt(value[0]);
        this.total = Integer.parseInt(value[5]);
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

    // through Pokemon Name !!
    public Pokemon(String name) throws IOException {
        String[] value, skills;
        do {
            String input = reader.readLine();
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
    public Pokemon(String name, String form) throws IOException {
        String[] value, skills;
        do {
            String input = reader.readLine();
            value = input.split(",");
            String skill = abilityReader.readLine();
            skills = skill.split(",");
        } while (!value[1].equalsIgnoreCase(name) && !value[2].equalsIgnoreCase(form));

        this.name = value[1];
        this.form = value[2];
        this.type1 = value[3];
        this.type2 = value[4];
        this.id = Integer.parseInt(value[0]);
        this.total = Integer.parseInt(value[5]);
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

    public void fight(Pokemon trainer, Pokemon enemy) {

    }

    @Override
    public String toString() {
        return String.format("%16s %d %s %19s %s %s %17s %s %s %11d %s %12d %s %9d %s %d %s %9d %s %d %s %6d %s %d %s %20s",
                "Pokemon", id,
                "\nName: ", name, form,
                "\nType: ", type1, type2,
                "\nGeneration: ", gen,
                "\nStatPoints: ", total,
                "\nHp | Speed: ", hp, "|", speed,
                "\nAtk | Def : ", atk, "|", def,
                "\nSpAtk | SpDef: ", spAtk, "|", spDef,
                "\nAbility: ", Arrays.toString(ability));
    }

    // Getters!!
    public String[] getAbility() {
        return ability;
    }
    public String getAbility1() {
        return ability[0];
    }
    public String getAbility2() {
        return ability[1];
    }

    public String getName() {
        return name;
    }

    public String getForm() {
        return form;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public int getId() {
        return id;
    }

    public int getTotal() {
        return total;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getSpAtk() {
        return spAtk;
    }

    public int getSpDef() {
        return spDef;
    }

    public int getSpeed() {
        return speed;
    }

    public int getGen() {
        return gen;
    }
}


