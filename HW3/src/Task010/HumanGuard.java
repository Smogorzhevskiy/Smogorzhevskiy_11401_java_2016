package Task010;

import Task010.Interface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class HumanGuard implements Unit {
    String Unit_class = "warrior";
    int lvl;
    int health;
    int mana;
    int damage;
    @Autowired
    @Qualifier("sword")
    Weapon weapon;
    Potion potion;
    @Autowired
    @Qualifier("human")
    Race race;
    @Autowired
    @Qualifier("standartInvent")
    Inventory inventory;

    public HumanGuard() {
        lvl = 1;
        health = 50;
        mana = 20;
        System.out.println(Unit_class);
    }


    @Override
    public String check_Invent() {
        String inf;
        System.out.println("Weapon: " + inventory.getWeapon());
        System.out.println("Potion: " + inventory.getPotion());
        return inf = "Weapon: " + inventory.getWeapon()[0] + " " + "Potion: " + inventory.getPotion()[0];


    }


    @Override
    public void lvlUp() {
        lvl++;
        health += 10;
        mana += 5;
        weapon.upWeapon();
        damage = weapon.getWeaponsAttackPower();


    }

    @Override
    public int useSkill() {
        System.out.println("race's ability");
        System.out.println("initial attack: " + damage);
        damage += race.ability();
        System.out.println("now attack :" + damage);
        return damage;
    }

    @Override
    public String getInformation() {
        damage = weapon.getWeaponsAttackPower();
        String inf = Unit_class + " lvl: " + lvl + " health: " + health + " mana: " + mana + " attack: " + damage;
        System.out.println(inf);
        return inf;
    }

    @Override
    public void autoCompleteCell() {
        weapon = inventory.getWeapon1();
        potion = inventory.getPotion1();
        damage = weapon.getWeaponsAttackPower();
    }
}
