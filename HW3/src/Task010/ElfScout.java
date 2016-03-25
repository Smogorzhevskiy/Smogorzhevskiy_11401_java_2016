package Task010;

import Task010.Interface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by User on 24.02.16.
 */
public class ElfScout implements Unit {
    String Unit_class = "archer";
    int lvl;
    int health;
    int mana;
    int damage;
    Weapon weapon1;
    @Autowired
    @Qualifier("bow")
    Weapon weapon2;
    Potion potion1;
    Potion potion2;
    @Autowired
    @Qualifier("elf")
    Race race;
    @Autowired
    @Qualifier("premiumInvent")
    Inventory inventory;


    public ElfScout() {
        lvl = 1;
        health = 40;
        mana = 30;

        System.out.println(Unit_class);

    }

    public void autoCompleteCell() {
        weapon1 = inventory.getWeapon1();
        weapon2 = inventory.getWeapon2();
        potion1 = inventory.getPotion1();
        potion2 = inventory.getPotion2();
        damage = weapon2.getWeaponsAttackPower();
        System.out.println(Unit_class + "good");

    }


    @Override
    public String check_Invent() {
        String inf;
        System.out.println("Weapon: " + inventory.getWeapon()[0] + ", " + inventory.getWeapon()[1]);
        System.out.println("Potion: " + inventory.getPotion()[0] + ", " + inventory.getPotion()[1]);
        return inf = "Weapon: " + inventory.getWeapon()[1] + " " + "Potion: " + inventory.getPotion()[1];
    }


    @Override
    public void lvlUp() {
        lvl++;
        health += 5;
        mana += 10;
        weapon2.upWeapon();
        damage = weapon2.getWeaponsAttackPower();


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
        damage = weapon2.getWeaponsAttackPower();

        String inf = Unit_class + " lvl: " + lvl + " health: " + health + " mana: " + mana + " attack: " + damage;
        System.out.println(inf);
        return inf;

    }

}
