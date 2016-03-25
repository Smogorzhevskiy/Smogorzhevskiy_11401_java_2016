package Task004;

import Task004.Interface.Unit;

public class Main {

    public static void main(String[] args) {
        Unit unit1 = new HumanGuard();
        Unit unit2 = new ElfScout();

        unit1.getInformation();
        unit1.check_Invent();
        unit2.getInformation();
        unit2.check_Invent();
        unit1.useSkill();
        unit2.useSkill();
        unit1.lvlUp();
        unit2.lvlUp();
        unit1.getInformation();
        unit2.getInformation();


    }
}


