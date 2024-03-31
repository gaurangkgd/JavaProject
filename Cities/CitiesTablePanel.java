package View.Cities;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CitiesTablePanel extends JPanel {

    ArrayList<JButton> city_buttons = new ArrayList<>();

    public CitiesTablePanel()
    {
        super();
    }

    public void createButtons(int count)
    {
        for (int i = 1; i <= count; i++)
        {
            JButton b = new JButton();
            b.setBackground(Color.pink);
            b.setSize(500,50);
            city_buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }

    }

    public void setButtonText(int button_no, String button_text) {
        city_buttons.get(button_no).setText(button_text);
    }

    public ArrayList<JButton> getAllButtons()
    {
        return city_buttons;
    }

}
