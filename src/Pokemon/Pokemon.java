package Pokemon;

import java.io.*;
import java.util.*;


public class Pokemon extends Pokedex {

    // Constructors implemented from Pokedex
    public Pokemon(int id) throws IOException {
        super(id);
    }
    public Pokemon(String name) throws IOException {
        super(name);
    }
    public Pokemon(String name, String form) throws IOException {
        super(name, form);
    }

    // Methods
    public void fight(Pokemon enemy) throws InterruptedException, IOException {
        // Shows Name / Hp  + skills from trainer pokemon & enemy pokemon
        status(enemy);

        Random rng = new Random();
        Scanner sc = new Scanner(System.in);
        int use = 0, dmg = 0;
        while (this.hp > 0 || enemy.getHp() > 0) {
            System.out.println("\nWhich Skill do you want to Use?");
            do {
                try {
                    use = sc.nextInt();
                    dmg = dmgCalculation(this, enemy);
                    switch (use) {
                        case 1 -> System.out.println(this.name + " attacks with " + this.ability[0] + ".\n"
                                + this.name + " deals " + dmg + " Dmg!");
                        case 2 -> System.out.println(this.name + " attacks with " + this.ability[1] + ".\n"
                                + this.name + " deals " + dmg + " Dmg!");
                        default -> throw new InputMismatchException();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error! Use 1 or 2!");
                    fight(enemy);
                }
            } while (use < 0 || use > 2);

            if (dmg > 0) {
                enemy.setHp(enemy.getHp() - dmg);
                if (dmg > 50) {
                    System.out.println("Critical Hit!");
                } else if (dmg > 25) {
                    System.out.println("Good Hit");
                }
            }
            if (enemy.getHp() <= 0) {
                System.out.println("Enemy Defeated");
                return;
            }
            System.out.println("Enemy Turn!");
            Thread.sleep(500);

            use = rng.nextInt(1, 3);
            dmg = dmgCalculation(enemy, this);
            switch (use) {
                case 1 -> System.out.println(enemy.getName() + " attacks with " + enemy.getAbility1() + ".\n" +
                        enemy.getName() + " deals " + dmg + " Dmg!");
                case 2 -> System.out.println(enemy.getName() + " attacks with " + enemy.getAbility2() + ".\n" +
                        enemy.getName() + " deals " + dmg + " Dmg!");
            }

            if (dmg > 0) {
                this.hp -= dmg;
                if (dmg > 50) {
                    System.out.println("Critical Hit!");
                } else if (dmg > 25) {
                    System.out.println("Good Hit");
                }
            }

            if (this.hp <= 0) {
                System.out.println("You Lost the Fight!");
                return;
            }

            Thread.sleep(1000);
            status(enemy);
        }
    }

    // Simple Overview  Name | Hp | Skills
    public void status(Pokemon enemy) {
        System.out.printf("%s %s %d %s %d %s %s %s %s %d %s %d %s %s %6s %s %5s",
                this.form.equalsIgnoreCase("") ? this.name : this.form,
                "(", this.hp, "|", this.maxHp, ")"," Vs ",
                enemy.getForm().equalsIgnoreCase("") ? enemy.getName() : enemy.getForm(),
                "(", enemy.getHp(), "|", enemy.getMaxHp(), ")",
                "\nMy Skills:", Arrays.toString(this.ability),
                "\nEnemy Skills: ", Arrays.toString(enemy.getAbility()) );
    }

    @Override
    public String toString() {
        return String.format("%16s %d %s %24s %s  %16s %s %s %11d %s %12d %s %9d %s %d %s %9d %s %d %s %6d %s %d %s %20s",
                "Pokemon", id,
                "\nName: ", (form.equalsIgnoreCase(" "))? name: form,
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

    public int getMaxHp() {
        return maxHp;
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


