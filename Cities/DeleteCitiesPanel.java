package View.Cities;

import javax.swing.*;

public class DeleteCitiesPanel extends JPanel {

    JTextField txt_del_city_id;
    JButton deleteCityBtn;

    public DeleteCitiesPanel()
    {

        txt_del_city_id = new JTextField();
        deleteCityBtn = new JButton("Delete City");

        txt_del_city_id.setText("txt_city_id");

        add(txt_del_city_id);
        add(deleteCityBtn);
    }

    public JButton getDeleteCityBtn() {
        return deleteCityBtn;
    }

    public JTextField getTxt_del_city_id() {
        return txt_del_city_id;
    }

    public void setDeleteCityBtn(JButton deleteCityBtn) {
        this.deleteCityBtn = deleteCityBtn;
    }

    public void setTxt_del_city_id(JTextField txt_del_city_id) {
        this.txt_del_city_id = txt_del_city_id;
    }
}
