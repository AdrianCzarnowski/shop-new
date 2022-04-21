package helpers;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FakeDataFactory {

    Faker faker = new Faker();
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    String fakeFirstName = faker.name().firstName();
    String fakeLastName = faker.name().lastName();
    String fakeEmail = fakeValuesService.bothify("????##@gmail.com");
    String fakeBirthDate = fakeValuesService.numerify("########");
    String fakePassword = fakeValuesService.bothify("?#?#?#?#?#?#?#?#?#??#?#?#?#");

}
