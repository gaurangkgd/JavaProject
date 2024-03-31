package View.Cities;

import javax.swing.*;

public class EditCitiesPanel extends JPanel{

        JTextField txt_get_city_idx;
        JButton getCityBtn;
        JTextField txt_city_id;
        JTextField txt_city_name;
        JTextField txt_city_currency;
        JTextField txt_city_country;
        JTextField txt_city_language;
        JButton editCityBtn;

        public EditCitiesPanel()
        {

            txt_city_id = new JTextField();
            txt_city_name = new JTextField();
            txt_city_country = new JTextField();
            txt_city_language = new JTextField();
            txt_city_currency = new JTextField();
            editCityBtn = new JButton("Edit City");
            txt_get_city_idx = new JTextField();

            getCityBtn = new JButton("Get City to Edit");

            txt_city_id.setText("txt_city_id");
            txt_city_name.setText("txt_city_name");
            txt_city_country.setText("txt_city_country");
            txt_city_language.setText("txt_city_language");
            txt_city_currency.setText("txt_city_currency");
            txt_get_city_idx.setText("get city idx");


            add(txt_get_city_idx);
            add(getCityBtn);

            add(txt_city_id);
            add(txt_city_name);
            add(txt_city_country);
            add(txt_city_language);
            add(txt_city_currency);
            add(editCityBtn);
        }

        public JTextField getTxt_city_id() {
            return txt_city_id;
        }

        public JTextField getTxt_city_name() {
            return txt_city_name;
        }

    public JTextField getTxt_city_language() {
        return txt_city_language;
    }

    public JTextField getTxt_city_currency() {
            return txt_city_currency;
        }

        public JTextField getTxt_city_country() {
            return txt_city_country;
        }

        public JButton getEditCityBtn() {
            return editCityBtn;
        }

        public JTextField getTxt_get_city_idx() {
            return txt_get_city_idx;
        }
        public JButton getGetCityBtn() {
            return getCityBtn;
        }
        public void setTxt_city_id(JTextField txt_city_id) {
            this.txt_city_id = txt_city_id;
        }

        public void setTxt_city_name(JTextField txt_city_name) {
            this.txt_city_name = txt_city_name;
        }

        public void setTxt_city_currency(JTextField txt_city_currency) {
            this.txt_city_currency = txt_city_currency;
        }

    public void setTxt_city_language(JTextField txt_city_language) {
        this.txt_city_language = txt_city_language;
    }

    public void setTxt_city_country(JTextField txt_city_country) {
            this.txt_city_country = txt_city_country;
        }

        public void setEditCityBtn(JButton editCityBtn) {
            this.editCityBtn = editCityBtn;
        }

        public void setTxt_get_city_idx(JTextField txt_get_city_idx) {
            this.txt_get_city_idx = txt_get_city_idx;
        }

        public void setGetCityBtn(JButton getCityBtn) {
            this.getCityBtn = getCityBtn;
        }
    }


