package Controller;

import Model.Model;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;


public class Controller {
    Model model;
    View view;

    public Controller(Model m, View v)
    {
        model = m;
        view = v;

        view.getFf().getManageCityBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("City Button Clicked");
                view.getFf().setVisible(false);
                view.getMcf().setVisible(true);
            }
        });

        view.getMcf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });

        model.getMc().setLinesBeingDisplayed(20);
        view.centerInitialSetupCity(model.getMc().getLinesBeingDisplayed(),model.getMc().getHeaders().size());

        model.getMc().setFirstLineToDisplay(0);
        view.centerUpdateCity(model.getMc().getLines(model.getMc().getFirstLineToDisplay(),model.getMc().getLastLineToDisplay()),model.getMc().getHeaders());


        view.getMcf().getCity_ip().getCtp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMc().getFirstLineToDisplay();
                int current_last_line = model.getMc().getLastLineToDisplay();
                int no_of_cities = model.getMc().getTable().size();
                int no_of_display_lines = model.getMc().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMc().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMc().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_cities-1)
                {
                    model.getMc().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_cities-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_cities - no_of_display_lines)
                    {
                        new_first_line = no_of_cities-no_of_display_lines;
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateCity(model.getMc().getLines(model.getMc().getFirstLineToDisplay(), model.getMc().getLastLineToDisplay()), model.getMc().getHeaders());
            }
        });
        view.getMcf().getCity_ip().getAcp().getAddCityBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add City Button Clicked");
                String txt_city_id = view.getMcf().getCity_ip().getAcp().getTxt_city_id().getText();
                String txt_city_name = view.getMcf().getCity_ip().getAcp().getTxt_city_name().getText();
                String txt_city_country = view.getMcf().getCity_ip().getAcp().getTxt_city_country().getText();
                String txt_city_language = view.getMcf().getCity_ip().getAcp().getTxt_city_language().getText();
                String txt_city_currency = view.getMcf().getCity_ip().getAcp().getTxt_city_currency().getText();
                try {
                    model.getMc().addNewCity(Integer.valueOf(txt_city_id),txt_city_name,txt_city_country,txt_city_language,txt_city_currency);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMcf().getCity_ip().getEcp().getGetCityBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get City Details Clicked");
                String txt_city_idx = view.getMcf().getCity_ip().getEcp().getTxt_get_city_idx().getText();
                model.getMc().readCitiesJsonFile("Exp11/src/Model/City/Cities.json");
                int city_id = model.getMc().getTable().get(Integer.valueOf(txt_city_idx)).getct_id();
                String city_name = model.getMc().getTable().get(Integer.valueOf(txt_city_idx)).getct_name();
                String city_country = model.getMc().getTable().get(Integer.valueOf(txt_city_idx)).getct_country();
                String city_language = model.getMc().getTable().get(Integer.valueOf(txt_city_idx)).getct_lang();
                String city_currency = model.getMc().getTable().get(Integer.valueOf(txt_city_idx)).getct_currency();
                view.getMcf().getCity_ip().getEcp().getTxt_city_id().setText(String.valueOf(city_id));
                view.getMcf().getCity_ip().getEcp().getTxt_city_name().setText(city_name);
                view.getMcf().getCity_ip().getEcp().getTxt_city_country().setText(city_country);
                view.getMcf().getCity_ip().getEcp().getTxt_city_language().setText(city_language);
                view.getMcf().getCity_ip().getEcp().getTxt_city_currency().setText(city_currency);

            }
        });

        view.getMcf().getCity_ip().getEcp().getEditCityBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit City Button Clicked");
                String txt_city_idx = view.getMcf().getCity_ip().getEcp().getTxt_get_city_idx().getText();
                String txt_city_id = view.getMcf().getCity_ip().getEcp().getTxt_city_id().getText();
                String txt_city_name = view.getMcf().getCity_ip().getEcp().getTxt_city_name().getText();
                String txt_city_country = view.getMcf().getCity_ip().getEcp().getTxt_city_country().getText();
                String txt_city_language = view.getMcf().getCity_ip().getEcp().getTxt_city_language().getText();
                String txt_city_currency = view.getMcf().getCity_ip().getEcp().getTxt_city_currency().getText();
                try {
                    model.getMc().editNewCity(Integer.valueOf(txt_city_idx),Integer.valueOf(txt_city_id),txt_city_name,txt_city_country,txt_city_language,txt_city_currency);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMcf().getCity_ip().getDcp().getDeleteCityBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete City Button Clicked");
                String txt_city_idx = view.getMcf().getCity_ip().getDcp().getTxt_del_city_id().getText();
                try {
                    model.getMc().deleteCity(Integer.valueOf(txt_city_idx));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        view.getFf().getManageEnrollBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Enroll Button Clicked");
                view.getFf().setVisible(false);
                view.getMef().setVisible(true);
            }
        });
        view.getMef().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });


        model.getMe().setLinesBeingDisplayed(20);
        view.centerInitialSetupEnroll(model.getMe().getLinesBeingDisplayed(),model.getMe().getHeaders().size());
        model.getMe().setFirstLineToDisplay(0);
        view.centerUpdateEnroll(model.getMe().getLines(model.getMe().getFirstLineToDisplay(),model.getMe().getLastLineToDisplay()),model.getMe().getHeaders());

        view.getMef().getEnroll_ip().getEtp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMe().getFirstLineToDisplay();
                int current_last_line = model.getMe().getLastLineToDisplay();
                int no_of_enrolls = model.getMe().getTable().size();
                int no_of_display_lines = model.getMe().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMe().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMe().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMe().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_enrolls-1)
                {
                    model.getMe().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_enrolls-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_enrolls - no_of_display_lines)
                    {
                        new_first_line = no_of_enrolls-no_of_display_lines;
                        model.getMe().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMe().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateEnroll(model.getMe().getLines(model.getMe().getFirstLineToDisplay(), model.getMe().getLastLineToDisplay()), model.getMe().getHeaders());
            }
        });

        view.getMef().getEnroll_ip().getApe().getAddEnrollBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Enroll Button Clicked");
                String txt_enroll_t_id = view.getMef().getEnroll_ip().getApe().getTxt_t_temp().getText();
                String txt_enroll_c_id = view.getMef().getEnroll_ip().getApe().getTxt_c_temp().getText();
                String txt_enroll_date = view.getMef().getEnroll_ip().getApe().getTxt_enroll_date().getText();
                String txt_enroll_fees = view.getMef().getEnroll_ip().getApe().getTxt_Cities_fees().getText();
                try {
                    model.getMe().addNewEnroll(Integer.valueOf(txt_enroll_t_id),Integer.valueOf(txt_enroll_c_id),txt_enroll_date,Integer.valueOf(txt_enroll_fees));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMef().getEnroll_ip().getEep().getGetEnrollBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Enroll Details Clicked");
                String txt_enroll_idx = view.getMef().getEnroll_ip().getEep().getTxt_get_enroll_idx().getText();
                model.getMe().readEnrollsJsonFile("Exp11/src/Model/Enrolls/Enrolls.json");

                int enroll_t_id = model.getMe().getTable().get(Integer.valueOf(txt_enroll_idx)).getT_temp().gettr_id();
                int enroll_c_id = model.getMe().getTable().get(Integer.valueOf(txt_enroll_idx)).getC_temp().getct_id();
                String enroll_date = model.getMe().getTable().get(Integer.valueOf(txt_enroll_idx)).getEnroll_date();
                int enroll_fees = model.getMe().getTable().get(Integer.valueOf(txt_enroll_idx)).getCities_fees();


                view.getMef().getEnroll_ip().getEep().getTxt_enroll_t_id().setText(String.valueOf(enroll_t_id));
                view.getMef().getEnroll_ip().getEep().getTxt_enroll_c_id().setText(String.valueOf(enroll_c_id));
                view.getMef().getEnroll_ip().getEep().getTxt_enroll_date().setText(enroll_date);
                view.getMef().getEnroll_ip().getEep().getTxt_enroll_fees().setText(String.valueOf(enroll_fees));
            }
        });

        view.getMef().getEnroll_ip().getEep().getEditEnrollBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Enroll Button Clicked");
                String txt_enroll_idx = view.getMef().getEnroll_ip().getEep().getTxt_get_enroll_idx().getText();
                String txt_enroll_t_id = view.getMef().getEnroll_ip().getEep().getTxt_enroll_t_id().getText();
                String txt_enroll_c_id = view.getMef().getEnroll_ip().getEep().getTxt_enroll_c_id().getText();
                String txt_enroll_date = view.getMef().getEnroll_ip().getEep().getTxt_enroll_date().getText();
                String txt_enroll_fees = view.getMef().getEnroll_ip().getEep().getTxt_enroll_fees().getText();

                try {
                    model.getMe().editNewEnroll(Integer.valueOf(txt_enroll_idx),Integer.valueOf(txt_enroll_t_id),Integer.valueOf(txt_enroll_c_id),txt_enroll_date,Integer.valueOf(txt_enroll_fees));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMef().getEnroll_ip().getDep().getDeleteEnrollBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Enroll Button Clicked");
                String txt_enroll_idx = view.getMef().getEnroll_ip().getDep().getTxt_del_enroll_id().getText();
                try {
                    model.getMe().deleteEnroll(Integer.valueOf(txt_enroll_idx));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        view.getFf().getManageTouristBtn().addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              view.getFf().setVisible(false);
              view.getMtf().setVisible(true);
          }
        });
        view.getMtf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });


        view.getMtf().getTourist_ip().getCpt().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMt().getFirstLineToDisplay();
                int current_last_line = model.getMt().getLastLineToDisplay();
                int no_of_tourists = model.getMt().getTable().size();
                int no_of_display_lines = model.getMt().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMt().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMt().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMt().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_tourists-1)
                {
                    model.getMt().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_tourists-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_tourists - no_of_display_lines)
                    {
                        new_first_line = no_of_tourists-no_of_display_lines;
                        model.getMt().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMt().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateTourist(model.getMt().getLines(model.getMt().getFirstLineToDisplay(), model.getMt().getLastLineToDisplay()), model.getMt().getHeaders());
            }
        });

        view.getMtf().getTourist_ip().getApt().getAddTouristBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Tourist Button Clicked");
                String txt_tourist_id = view.getMtf().getTourist_ip().getApt().getTxt_t_id().getText();
                String txt_tourist_f_name = view.getMtf().getTourist_ip().getApt().getTxt_fname().getText();
                String txt_tourist_l_name = view.getMtf().getTourist_ip().getApt().getTxt_lname().getText();
                String txt_tourist_gender = view.getMtf().getTourist_ip().getApt().getTxt_gender().getText();
                String txt_tourist_age = view.getMtf().getTourist_ip().getApt().getTxt_age().getText();
                String txt_tourist_mob = view.getMtf().getTourist_ip().getApt().getTxt_mobile().getText();
                try {
                    model.getMt().addNewTourist(Integer.valueOf(txt_tourist_id),txt_tourist_f_name,txt_tourist_l_name,txt_tourist_gender,Integer.valueOf(txt_tourist_age),txt_tourist_mob);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        view.getMtf().getTourist_ip().getEtp().getGetTouristBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Tourist Details Clicked");
                String txt_tourist_idx = view.getMtf().getTourist_ip().getEtp().getTxt_get_Tourist_idx().getText();
                model.getMt().readTouristsJsonFile("Exp11/src/Model/Tourist/Tourists.json");
                int tourist_id = model.getMt().getTable().get(Integer.valueOf(txt_tourist_idx)).gettr_id();
                String tourist_f_name = model.getMt().getTable().get(Integer.valueOf(txt_tourist_idx)).getFname();
                String tourist_l_name = model.getMt().getTable().get(Integer.valueOf(txt_tourist_idx)).getLname();
                String tourist_gender = model.getMt().getTable().get(Integer.valueOf(txt_tourist_idx)).getgender();
                int tourist_age = model.getMt().getTable().get(Integer.valueOf(txt_tourist_idx)).getage();
                String tourist_mob = model.getMt().getTable().get(Integer.valueOf(txt_tourist_idx)).gettr_mob();

                view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_id().setText(String.valueOf(tourist_id));
                view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_f_name().setText(tourist_f_name);
                view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_l_name().setText(tourist_l_name);
                view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_gender().setText(tourist_gender);
                view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_age().setText(String.valueOf(tourist_age));
                view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_mobile().setText(tourist_mob);
            }
        });

        view.getMtf().getTourist_ip().getEtp().getEditTouristBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Tourist Button Clicked");
                String txt_tourist_idx = view.getMtf().getTourist_ip().getEtp().getTxt_get_Tourist_idx().getText();
                String txt_tourist_id = view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_id().getText();
                String txt_tourist_f_name = view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_f_name().getText();
                String txt_tourist_l_name = view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_l_name().getText();
                String txt_tourist_gender = view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_gender().getText();
                String txt_tourist_age = view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_age().getText();
                String txt_tourist_mob = view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_mobile().getText();
                try {
                    model.getMt().editNewTourist(Integer.valueOf(txt_tourist_idx),Integer.valueOf(txt_tourist_id),txt_tourist_f_name,txt_tourist_l_name,txt_tourist_gender,Integer.valueOf(txt_tourist_age),txt_tourist_mob);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMtf().getTourist_ip().getDtp().getDeleteTouristBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Tourist Button Clicked");
                String txt_tourist_idx = view.getMtf().getTourist_ip().getDtp().getTxt_del_tourist_id().getText();
                try {
                    model.getMt().deleteTourist(Integer.valueOf(txt_tourist_idx));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        model.getMt().setLinesBeingDisplayed(20);
        view.centerInitialSetupTourist(model.getMt().getLinesBeingDisplayed(),model.getMt().getHeaders().size());
        model.getMt().setFirstLineToDisplay(0);
        view.centerUpdateTourist(model.getMt().getLines(model.getMt().getFirstLineToDisplay(),model.getMt().getLastLineToDisplay()),model.getMt().getHeaders());}}

