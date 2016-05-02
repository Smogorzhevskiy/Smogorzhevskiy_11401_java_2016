/**
 * Created by sentpim on 26.02.2016.
 */
public class Building {
    String name;
    Institute institute;

    public Building(String name, Institute institute) {
        this.name = name;
        this.institute = institute;
    }
    public static Building newBuilding(String name, Institute institute) {
        return new Building(name, institute);
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + " belongs to " + this.institute;
    }


}
