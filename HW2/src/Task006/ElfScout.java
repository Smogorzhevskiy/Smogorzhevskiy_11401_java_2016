package Task006;

import Task006.Interface.*;

/**
 * Created by User on 24.02.16.
 */
public class ElfScout implements Unit {
    String Unit_class = "archer";
    int lvl;
    int health;
    int mana;
    Race race;
    Inventory inventory;

    public ElfScout() {
        lvl = 1;
        health = 40;
        mana = 30;
        System.out.println(Unit_class);

    }


    @Override
    public String check_Invent() {
        String inf;
        System.out.println("Weapon: " + inventory.getWeapon());
        System.out.println("Potion: " + inventory.getPotion());
        return inf = "Weapon: " + inventory.getWeapon() + " " + "Potion: " + inventory.getPotion();
    }


    @Override
    public void lvlUp() {
        lvl++;
        health += 5;
        mana += 10;
        inventory.getWeapon2().upWeapon();


    }

    @Override
    public int useSkill() {
        System.out.println("race's ability");
        System.out.println("initial health: " + health);

        health += race.ability();
        System.out.println("now health: " + health);
        return health;

    }

    @Override
    public String getInformation() {
        String inf = Unit_class + " lvl: " + lvl + " health: " + health + " mana: " + mana + " attack: " + inventory.getWeapon2().getWeaponsAttackPower();
        System.out.println(inf);
        return inf;

    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}
