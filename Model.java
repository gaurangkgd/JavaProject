package Model;

import Model.City.manageCities;
import Model.Enrolls.manageEnrolls;
import Model.Tourist.manageTourists;

public class Model {
    manageTourists mt;
    manageCities mc;
    manageEnrolls me;

    public Model() {
        mt = new manageTourists();
        mc = new manageCities();
        me = new manageEnrolls();
    }

    public manageTourists getMt() {
        return mt;
    }

    public manageCities getMc() {
        return mc;
    }

    public manageEnrolls getMe() {
        return me;
    }

    public void setMt(manageTourists mt) {
        this.mt = mt;
    }

    public void setMc(manageCities mc) {
        this.mc = mc;
    }

    public void setMe(manageEnrolls me) {
        this.me = me;
    }
}
