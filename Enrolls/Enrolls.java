package Model.Enrolls;
import Model.City.Cities;

import Model.Tourist.Tourists;

public class Enrolls {
    Tourists t_temp;
    Cities c_temp;
    String enroll_date;
    int Cities_fees;

    public Enrolls(Tourists s, Cities c, String c_date, int fees)
    {
        setT_temp(s);
        setC_temp(c);
        setEnroll_date(c_date);
        setCities_fees(fees);
    }

    public void setT_temp(Tourists s_temp) {
        this.t_temp = s_temp;
    }

    public void setC_temp(Cities c_temp) {
        this.c_temp = c_temp;
    }

    public void setEnroll_date(String enroll_date) {
        this.enroll_date = enroll_date;
    }

    public void setCities_fees(int Cities_fees) {
        this.Cities_fees = Cities_fees;
    }

    public Tourists getT_temp() {
        return t_temp;
    }

    public Cities getC_temp() {
        return c_temp;
    }

    public String getEnroll_date() {
        return enroll_date;
    }

    public int getCities_fees() {
        return Cities_fees;
    }
}
