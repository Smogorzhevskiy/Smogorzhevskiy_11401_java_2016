package Task007;

import Task007.Interface.Ability;
import org.springframework.stereotype.Component;

/**
 * Created by User on 24.02.16.
 */
@Component
public class Anger implements Ability {
    int damage = 10;

    @Override
    public int getDescription() {
        return damage;
    }

}
