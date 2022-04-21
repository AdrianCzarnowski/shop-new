package helpers;

import model.User;

public class UserFactory {
    FakeDataFactory fakeDataFactory;

    public User.UserBuilder randomUser() {

        User.UserBuilder user = new User.UserBuilder()
                .firstName(fakeDataFactory.fakeFirstName)
                .lastName(fakeDataFactory.fakeLastName)
                .email(fakeDataFactory.fakeEmail)
                .password(fakeDataFactory.fakePassword)
                .birthDate(fakeDataFactory.fakeBirthDate);
        return user;
    }

    public User.UserBuilder alreadyRegisterUser() {
        User.UserBuilder user = new User.UserBuilder()
                .firstName("Jan")
                .lastName("Kowalski")
                .email("jankowalski@gmail.com")
                .password("1qaz@WSX")
                .birthDate("01.01.1999");
        return user;

    }
}
