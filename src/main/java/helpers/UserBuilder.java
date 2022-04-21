package helpers;

import model.User;

public class UserBuilder {



    public User.UserBuilder getRandomUser() {

        User.UserBuilder user = new User.UserBuilder()
                .firstName(FakeDataFactory.getFakeFirstName())
                .lastName(FakeDataFactory.getFakeLastName())
                .email(FakeDataFactory.getFakeEmail())
                .password(FakeDataFactory.getPassword(8,24,true,true))
                .birthDate(FakeDataFactory.getFakeBirthDate());
        return user;
    }

    public User.UserBuilder getAlreadyRegisterUser() {
        User.UserBuilder user = new User.UserBuilder()
                .firstName("Jan")
                .lastName("Kowalski")
                .email("jankowalski@gmail.com")
                .password("1qaz@WSX")
                .birthDate("01.01.1999");
        return user;

    }
}
