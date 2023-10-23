package solidLab.p04_InterfaceSegregation.p02_identity;

import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.User;
import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public Iterable<User> getAllUsersOnline() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<User> getAllUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public User getUserByName(String name) {
        throw new UnsupportedOperationException();
    }
}
