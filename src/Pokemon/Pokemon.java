package Pokemon;

import java.io.*;

public class Pokemon {
    //    Order in the CSV File !
    //    ID,Name,Form,Type1,Type2,
    //    Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation
    private final String name, form, type1, type2;
    private final int id, total, hp, atk, def, spAtk, spDef, speed, gen;

    BufferedReader reader = new BufferedReader(new FileReader("files/Pokedex.csv"));

    // Constructor through  Pokemon ID !!
    public Pokemon(int id) throws IOException {
        int size = 0;
        while (id != size) {
            reader.readLine();
            size++;
        }
        String input = reader.readLine();
        String[] value = input.split(",");

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
    }

    // through Pokemon Name !!
    public Pokemon(String name) throws IOException {
        String[] value;
        do {
            String input = reader.readLine();
            value = input.split(",");
        } while (!value[1].equalsIgnoreCase(name));

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
    }
    // Extra for the different Forms !
    public Pokemon(String name, String form) throws IOException {
        String[] value;
        do {
            String input = reader.readLine();
            value = input.split(",");
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
    }

    // Getters!!
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


