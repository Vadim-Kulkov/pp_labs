package sixth_lab.factories;

import sixth_lab.entities.Entrant;
import sixth_lab.interfaces.Factory;

public class EntrantFactory implements Factory {

    @Override
    public Entrant createInstance() {
        return new Entrant();
    }
}
