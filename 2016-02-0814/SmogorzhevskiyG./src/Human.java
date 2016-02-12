
public class Human implements Unit {
    String Unit_class= "warrior";
    Standart_Invent invent= new Standart_Invent();
    @Override
    public String check_Invent(Inventory inventory, String Unit_class) {
    inventory=invent;
        System.out.print();
    }

    @Override
    public String check_Accessory(Race race, Group group, String Unit_class) {
        return null;
    }

    @Override
    public void attack_Enemy(Attack attack) {

    }
}
