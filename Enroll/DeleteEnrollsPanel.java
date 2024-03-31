package View.Enroll;

import javax.swing.*;

public class DeleteEnrollsPanel extends JPanel {

    JTextField txt_del_enroll_id;
    JButton deleteEnrollBtn;

    public DeleteEnrollsPanel()
    {

        txt_del_enroll_id = new JTextField();
        deleteEnrollBtn = new JButton("Delete Enroll");

        txt_del_enroll_id.setText("txt_enroll_id");

        add(txt_del_enroll_id);
        add(deleteEnrollBtn);
    }

    public JButton getDeleteEnrollBtn() {
        return deleteEnrollBtn;
    }

    public JTextField getTxt_del_enroll_id() {
        return txt_del_enroll_id;
    }

    public void setDeleteEnrollBtn(JButton deleteEnrollBtn) {
        this.deleteEnrollBtn = deleteEnrollBtn;
    }

    public void setTxt_del_enroll_id(JTextField txt_del_enroll_id) {
        this.txt_del_enroll_id = txt_del_enroll_id;
    }
}
