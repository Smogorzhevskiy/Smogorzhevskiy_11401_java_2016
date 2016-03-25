package Task006;

import Task006.Interface.Ability;

/**
 * Created by User on 24.02.16.
 */
public class Treatment implements Ability {
    int health =10;
    @Override
    public int getDescription() {
        return health;
    }
}
