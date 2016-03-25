package Task010;

import Task010.Interface.Ability;
import org.springframework.stereotype.Component;

/**
 * Created by User on 24.02.16.
 */

@Component
public class Treatment implements Ability {
    int health = 10;

    @Override
    public int getDescription() {
        return health;
    }
}
