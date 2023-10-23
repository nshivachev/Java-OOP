package solidLab.p04_InterfaceSegregation.p02_identity;

import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.Account;

public class AccountController {
    private final Account MANAGER;

    public AccountController(Account manager) {
        this.MANAGER = manager;
    }

    public void changePassword(String oldPass, String newPass) {
        this.MANAGER.changePassword(oldPass, newPass);
    }
}
