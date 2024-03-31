package View.Enroll;

import javax.swing.*;

public class EditEnrollPanel extends JPanel{

        JTextField txt_get_enroll_idx;
        JButton getEnrollBtn;
        JTextField txt_enroll_c_id;
        JTextField txt_enroll_t_id;
        JTextField txt_enroll_date;
        JTextField txt_enroll_fees;
        JButton editEnrollBtn;

        public EditEnrollPanel()
        {

            txt_enroll_c_id = new JTextField();
            txt_enroll_t_id = new JTextField();
            txt_enroll_date = new JTextField();
            txt_enroll_fees = new JTextField();

            editEnrollBtn = new JButton("Edit Enroll");
            txt_get_enroll_idx = new JTextField();

            getEnrollBtn = new JButton("Get Enroll to Edit");

            txt_enroll_c_id.setText("txt_enroll_c_id");
            txt_enroll_t_id.setText("txt_enroll_t_id");
            txt_enroll_date.setText("txt_enroll_date");
            txt_enroll_fees.setText("txt_enroll_fees");
            txt_get_enroll_idx.setText("get enroll idx");

            add(txt_get_enroll_idx);
            add(getEnrollBtn);

            add(txt_enroll_t_id);
            add(txt_enroll_c_id);
            add(txt_enroll_date);
            add(txt_enroll_fees);
            add(editEnrollBtn);
        }

        public JTextField getTxt_enroll_c_id() {
            return txt_enroll_c_id;
        }

        public JTextField getTxt_enroll_t_id() {
            return txt_enroll_t_id;
        }

        public JTextField getTxt_enroll_fees() {
        return txt_enroll_fees;
    }
        public JTextField getTxt_enroll_date() {
            return txt_enroll_date;
        }

        public JButton getEditEnrollBtn() {
            return editEnrollBtn;
        }

        public JTextField getTxt_get_enroll_idx() {
            return txt_get_enroll_idx;
        }
        public JButton getGetEnrollBtn() {
            return getEnrollBtn;
        }
        public void setTxt_enroll_id(JTextField txt_enroll_c_id) {
            this.txt_enroll_c_id = txt_enroll_c_id;
        }

        public void setTxt_enroll_t_id(JTextField txt_enroll_t_id) {
            this.txt_enroll_t_id = txt_enroll_t_id;
        }


    public void setTxt_enroll_fees(JTextField txt_enroll_fees) {
        this.txt_enroll_fees = txt_enroll_fees;
    }

    public void setTxt_enroll_date(JTextField txt_enroll_date) {
            this.txt_enroll_date = txt_enroll_date;
        }

        public void setEditEnrollBtn(JButton editEnrollBtn) {
            this.editEnrollBtn = editEnrollBtn;
        }

        public void setTxt_get_enroll_idx(JTextField txt_get_enroll_idx) {
            this.txt_get_enroll_idx = txt_get_enroll_idx;
        }

        public void setGetEnrollBtn(JButton getEnrollBtn) {
            this.getEnrollBtn = getEnrollBtn;
        }
    }


