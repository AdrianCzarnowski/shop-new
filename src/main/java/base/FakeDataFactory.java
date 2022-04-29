package base;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class FakeDataFactory {

    static Faker faker = new Faker();
    static FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    public static String getFakeFirstName() {
        return faker.name().firstName();
    }

    public static String getFakeLastName() {
        return faker.name().lastName();
    }

    public static String getFakeEmail() {
        return fakeValuesService.bothify("????##@gmail.com");
    }

    public static String getFakeBirthDate() {
        return fakeValuesService.numerify("0#" + "/" + "2#" + "/" + "199#");
    }

    public static String getPassword() {
        return faker.internet().password(8, 24, true, true);
    }
}


