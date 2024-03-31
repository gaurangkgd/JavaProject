package View.Enroll;

import javax.swing.*;

public class AddPanelEnroll extends JPanel {
    JTextField txt_t_temp;
    JTextField txt_c_temp;
    JTextField txt_enroll_date;
    JTextField txt_Cities_fees;
    JButton addEnrollBtn;

    public AddPanelEnroll()
    {
        txt_t_temp = new JTextField();
        txt_c_temp = new JTextField();
        txt_enroll_date = new JTextField();
        txt_Cities_fees = new JTextField();

        addEnrollBtn = new JButton("Add Enroll");

        txt_t_temp.setText("txt_t_temp");
        txt_c_temp.setText("txt_c_temp");
        txt_enroll_date.setText("txt_enroll_date");
        txt_Cities_fees.setText("txt_Cities_fees");


        add(txt_t_temp);
        add(txt_c_temp);
        add(txt_enroll_date);
        add(txt_Cities_fees);

        add(addEnrollBtn);
    }

    public void setAddEnrollBtn(JButton addEnrollBtn) {
        this.addEnrollBtn = addEnrollBtn;
    }

    public void setTxt_Cities_fees(JTextField txt_Cities_fees) {
        this.txt_Cities_fees = txt_Cities_fees;
    }

    public void setTxt_t_temp(JTextField txt_t_temp) {
        this.txt_t_temp = txt_t_temp;
    }

    public void setTxt_enroll_date(JTextField txt_enroll_date) {
        this.txt_enroll_date = txt_enroll_date;
    }


    public void setTxt_c_temp(JTextField txt_c_temp ){
        this.txt_c_temp = txt_c_temp;
    }


    public JTextField getTxt_t_temp() {
        return txt_t_temp;
    }

    public JTextField getTxt_c_temp() {
        return txt_c_temp;
    }

    public JTextField getTxt_enroll_date() {
        return txt_enroll_date;
    }

    public JTextField getTxt_Cities_fees() {
        return txt_Cities_fees;
    }

    public JButton getAddEnrollBtn() {
        return addEnrollBtn;
    }
}
