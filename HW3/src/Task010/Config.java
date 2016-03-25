package Task010;

import Task010.Interface.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by User on 19.03.16.
 */
@Configuration
@ComponentScan("Task010")
public class Config {
    @Bean
    public Unit ElfScout() {
        return new ElfScout();
    }

    @Bean
    public Unit HumanGuard() {
        return new HumanGuard();
    }

    @Bean
    public Weapon bow() {
        return new Bow();
    }

    @Bean
    public Weapon sword() {
        return new Sword();
    }

    @Bean
    public Potion healthPotion() {
        return new HealthPotion();
    }

    @Bean
    public Potion damagePotion() {
        return new DamagePotion();
    }

    @Bean
    public Ability anger() {
        return new Anger();
    }

    @Bean
    public Ability treatment() {
        return new Treatment();
    }

    @Bean
    public Race elf() {
        return new Elf();
    }

    @Bean
    public Race human() {
        return new Human();
    }

    @Bean
    public Inventory pInvent() {
        return new PremiumInvent();
    }

    @Bean
    public Inventory sInvent() {
        return new StandartInvent();
    }
}
