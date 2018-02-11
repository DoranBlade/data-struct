package faker;

import com.github.javafaker.Faker;
import model.Person;

import java.util.Arrays;
import java.util.List;

/**
 * created by eric on 18-2-11
 */
public class PersonFaker {

    private static final Faker faker = new Faker();

    public static Person getInstance() {
        return new Person(faker.name().name(), faker.number().numberBetween(1, 100));
    }

    public static List<Person> getList() {
        return Arrays.asList(
                getInstance(),
                getInstance(),
                getInstance()
        );
    }
}
