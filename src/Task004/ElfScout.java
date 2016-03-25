package Task004;

import Task004.Interface.*;

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
    Weapon weapon2;
    Potion potion1;
    Potion potion2;
    Race race;
    Inventory inventory;

    public  ElfScout(){
        lvl = 1;
        health = 40;
        mana = 30;
        weapon1 = new Sword();
        weapon2 = new Bow();
        potion1 = new HealthPotion();
        potion2 = new HealthPotion();
        race = new Elf();
        damage = weapon2.getWeaponsAttackPower();
        System.out.println(Unit_class);
        inventory = new PremiumInvent(weapon1, weapon2, potion1, potion2);

    }



    @Override
    public String check_Invent() {
        String inf;
        System.out.println("Weapon: " + inventory.getWeapon());
        System.out.println("Potion: " + inventory.getPotion());
return  inf = "Weapon: " + inventory.getWeapon() + " " + "Potion: " + inventory.getPotion();
    }


    @Override
    public void lvlUp() {
        lvl ++;
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
        String inf = Unit_class + " lvl: " + lvl + " health: " + health + " mana: " + mana + " attack: " + damage ;
        System.out.println(inf);
        return inf;

    }
}
