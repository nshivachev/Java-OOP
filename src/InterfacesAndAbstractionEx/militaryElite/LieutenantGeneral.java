package InterfacesAndAbstractionEx.militaryElite;

import java.util.Set;

public interface LieutenantGeneral extends Private {

    Set<Private> getPrivates();

    void addPrivate(Private priv);
}
