import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class App implements ActionListener{
private JFrame frame;
private JLabel title;
private JLabel intro;
private JLabel startDate;
private JLabel endDate;
private JLabel resultOfDates;
private JLabel addDate;
private JLabel addDays;
private JLabel resultDate;
private JLabel disclamer;
private JButton addButton;
private JButton betweenButton;
private String yearList[] = {"2022", "2023", "2024", "2025", "2026","2027", "2028", "2029", "2030", "2031", "2032"};
private String monthList[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
private String dayList[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
private SimpleDateFormat sdf;
private JComboBox cbYear, cbMonth, cbDay, cbYearEnd, cbMonthEnd, cbDayEnd, cbYearAdd, cbMonthAdd, cbDayAdd, cbAddDays;

public App() {
    frame = new JFrame("Date Calculator");
    frame.setSize(550, 550);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);

    title = new JLabel("Welcome to Date Calculator!");
    title.setBounds(145, 50, 300, 50);
    title.setFont(new Font("Arial", Font.BOLD, 20));

    intro = new JLabel("Calculate amount of days between 2 dates or add days to a specific date");
    intro.setBounds(115, 70, 400, 50);
    intro.setFont(new Font("Arial", Font.BOLD, 10));

    startDate = new JLabel("Start Date:");
    startDate.setBounds(100, 105, 100, 50);
    startDate.setFont(new Font("Arial", Font.BOLD, 15));

    cbYear = new JComboBox(yearList);
    cbYear.setEditable(true);
    cbYear.setSelectedIndex(0);
    cbYear.addActionListener(this);
    cbYear.setBounds(190, 120, 60, 20);

    cbMonth = new JComboBox(monthList);
    cbMonth.setEditable(true);
    cbMonth.setSelectedIndex(0);
    cbMonth.addActionListener(this);
    cbMonth.setBounds(260, 120, 100, 20);

    cbDay = new JComboBox(dayList);
    cbDay.setEditable(true);
    cbDay.setSelectedIndex(0);
    cbDay.addActionListener(this);
    cbDay.setBounds(370, 120, 50, 20);

    endDate = new JLabel("End Date:");
    endDate.setBounds(100, 150, 100, 50);
    endDate.setFont(new Font("Arial", Font.BOLD, 15));

    cbYearEnd = new JComboBox(yearList);
    cbYearEnd.setEditable(true);
    cbYearEnd.setSelectedIndex(1);
    cbYearEnd.addActionListener(this);
    cbYearEnd.setBounds(190, 165, 60, 20);

    cbMonthEnd = new JComboBox(monthList);
    cbMonthEnd.setEditable(true);
    cbMonthEnd.setSelectedIndex(8);
    cbMonthEnd.addActionListener(this);
    cbMonthEnd.setBounds(260, 165, 100, 20);

    cbDayEnd = new JComboBox(dayList);
    cbDayEnd.setEditable(true);
    cbDayEnd.setSelectedIndex(13);
    cbDayEnd.addActionListener(this);
    cbDayEnd.setBounds(370, 165, 50, 20);

    betweenButton = new JButton("Calculate between");
    betweenButton.setBounds(175, 210, 200, 30);
    betweenButton.setFont(new Font("Arial", Font.BOLD, 10));
    betweenButton.setFocusable(false);
    betweenButton.addActionListener(this);

    resultDate = new JLabel("Result: ");
    resultDate.setBounds(200, 250, 200, 50);
    resultDate.setFont(new Font("Arial", Font.BOLD, 15));
    resultDate.setVisible(false);

    addDate = new JLabel("Start Date: ");
    addDate.setBounds(70, 285, 200, 50);
    addDate.setFont(new Font("Arial", Font.BOLD, 15));

    cbYearAdd = new JComboBox(yearList);
    cbYearAdd.setEditable(true);
    cbYearAdd.setSelectedIndex(0);
    cbYearAdd.addActionListener(this);
    cbYearAdd.setBounds(160, 300, 60, 20);

    cbMonthAdd = new JComboBox(monthList);
    cbMonthAdd.setEditable(true);
    cbMonthAdd.setSelectedIndex(0);
    cbMonthAdd.addActionListener(this);
    cbMonthAdd.setBounds(230, 300, 100, 20);

    cbDayAdd = new JComboBox(dayList);
    cbDayAdd.setEditable(true);
    cbDayAdd.setSelectedIndex(0);
    cbDayAdd.addActionListener(this);
    cbDayAdd.setBounds(340, 300, 50, 20);

    addDays = new JLabel("Days to add: ");
    addDays.setBounds(70, 335, 200, 50);
    addDays.setFont(new Font("Arial", Font.BOLD, 15));

    cbAddDays = new JComboBox(dayList);
    cbAddDays.setEditable(true);
    cbAddDays.setSelectedIndex(0);
    cbAddDays.addActionListener(this);
    cbAddDays.setBounds(230, 350, 100, 20);

    disclamer = new JLabel("Disclaimer: if you choose to type in a specific amount of days, don´t forget to press enter and then press the add days button:)");
    disclamer.setBounds(30, 360, 600, 50);
    disclamer.setFont(new Font("Arial", Font.BOLD, 8));

    addButton = new JButton("Add days");
    addButton.setBounds(175, 400, 200, 30);
    addButton.setFont(new Font("Arial", Font.BOLD, 10));
    addButton.setFocusable(false);
    addButton.addActionListener(this);

    resultOfDates = new JLabel("Result:");
    resultOfDates.setBounds(240, 440, 200, 50);
    resultOfDates.setFont(new Font("Arial", Font.BOLD, 15));
    resultOfDates.setVisible(false);

    frame.add(disclamer);
    frame.add(addDays);
    frame.add(cbAddDays);
    frame.add(addDate);
    frame.add(cbDayAdd);
    frame.add(cbMonthAdd);
    frame.add(cbYearAdd);
    frame.add(cbDayEnd);
    frame.add(cbMonthEnd);
    frame.add(cbYearEnd);
    frame.add(cbDay);
    frame.add(cbMonth);
    frame.add(cbYear);
    frame.add(resultOfDates);
    frame.add(addButton);
    frame.add(resultDate);
    frame.add(betweenButton);
    frame.add(startDate);
    frame.add(endDate);
    frame.add(intro);
    frame.add(title);
    frame.setVisible(true);
}
public static void main(String[] args) {
    App app = new App();
}
@Override
public void actionPerformed(ActionEvent e) {
    String startYear = cbYear.getSelectedItem().toString();
    String startMonth = cbMonth.getSelectedItem().toString();
    String startDay = cbDay.getSelectedItem().toString();
    String endYear = cbYearEnd.getSelectedItem().toString();
    String endMonth = cbMonthEnd.getSelectedItem().toString();
    String endDay = cbDayEnd.getSelectedItem().toString();
    String addYear = cbYearAdd.getSelectedItem().toString();
    String addMonth = cbMonthAdd.getSelectedItem().toString();
    String addDay = cbDayAdd.getSelectedItem().toString();
    int daysAdded = Integer.valueOf((String) cbAddDays.getSelectedItem());
    String addDate = addYear + "-" + addMonth + "-" + addDay;
    String startDate = startYear + "-" + startMonth + "-" + startDay;
    String endDate = endYear + "-" + endMonth + "-" + endDay;
    if(e.getSource() == betweenButton){
            findDifference(startDate, endDate);
    }
    if(e.getSource() == addButton){
        addDays(addDate, daysAdded);;
    }

}

public void findDifference(String startDate, String endDate){
    sdf = new SimpleDateFormat("yyyy-MM-dd");

    try {
        Date date1 = sdf.parse(startDate);
        Date date2 = sdf.parse(endDate);

        Long difference_In_Time = date2.getTime() - date1.getTime();

        long difference_In_Days = (difference_In_Time / (1000l * 60 * 60 * 24));

        resultDate.setVisible(true);
        resultDate.setText("Result: " + difference_In_Days + " days left");
    } catch (ParseException e) {
        e.printStackTrace();
    }
    
}
public void addDays(String addDate, int daysAdded){
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    try {
        cal.setTime(sdf.parse(addDate));
        cal.add(Calendar.DATE, daysAdded);
        String dateAfter = sdf.format(cal.getTime());
        resultOfDates.setVisible(true);
        resultOfDates.setText(dateAfter);
    } catch (ParseException e) {
        e.printStackTrace();
    }
}
}
