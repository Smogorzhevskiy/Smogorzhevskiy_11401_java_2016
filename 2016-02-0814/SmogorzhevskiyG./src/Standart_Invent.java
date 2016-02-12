/**
 * Created by User on 12.02.16.
 */
public class Standart_Invent implements Inventory {
Sword sword=new Sword();
    @Override
    public String check_Type_weapon(Weapon weapon) {
        weapon=sword;
System.out.print();
        return null;
    }

    @Override
    public String check_Type_potion(Potion potion) {
        return null;
    }

    @Override
    public void clean_inventory(int weapon_quantity, int potion_quantity) {

    }
}
