package helpers;

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
        return fakeValuesService.numerify("##"+"/"+"##"+"/"+"####");
    }

    public static String getPassword(int minimumLength, int maximumLength, boolean includeUppercase, boolean includeSpecial) {
        if (includeSpecial) {
            char[] password = faker.lorem().characters(minimumLength, maximumLength, includeUppercase).toCharArray();
            char[] special = new char[]{'!', '@', '#', '$', '%', '^', '&', '*','(',')'};
            for (int i = 0; i < faker.random().nextInt(minimumLength); i++) {
                password[faker.random().nextInt(password.length)] = special[faker.random().nextInt(special.length)];
            }
            return new String(password);
        } else {
            return faker.lorem().characters(minimumLength, maximumLength, includeUppercase);
        }
    }
}


