import org.springframework.stereotype.Component;

/**
 * Created by sentpim on 26.02.2016.
 */

@Component
public class Institute {
    private String name;

    Institute(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
