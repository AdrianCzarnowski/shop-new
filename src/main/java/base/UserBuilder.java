package base;

import model.UserModel;

public class UserBuilder {

    public UserModel.UserBuilder getRandomUser() {

        UserModel.UserBuilder user = new UserModel.UserBuilder()
                .firstName(FakeDataFactory.getFakeFirstName())
                .lastName(FakeDataFactory.getFakeLastName())
                .email(FakeDataFactory.getFakeEmail())
                .password(FakeDataFactory.getPassword())
                .birthDate(FakeDataFactory.getFakeBirthDate());
        return user;
    }

    public UserModel.UserBuilder getAlreadyRegisterUser() {
        UserModel.UserBuilder user = new UserModel.UserBuilder()
                .firstName("Jan")
                .lastName("Kowalski")
                .email("jankowalski@gmail.com")
                .password("1qaz@WSX")
                .birthDate("01.01.1999");
        return user;

    }
}
