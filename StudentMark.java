import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class StudentMark {
    private JFrame frame;
    private JTextField sub1;
    private JTextField sub2;
    private JTextField sub3;
    private JTextField totalmarks;
    private JTextField average;
    private JTextField grade;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentMark window = new StudentMark();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public StudentMark() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 558, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.LIGHT_GRAY, null, null));
        panel.setBounds(20, 10, 500, 340);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("Student Mark Calculation System");
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblTitle.setBounds(120, 10, 300, 26);
        panel.add(lblTitle);

        JLabel lblSub1 = new JLabel("Subject 1");
        lblSub1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblSub1.setBounds(50, 50, 85, 20);
        panel.add(lblSub1);

        sub1 = new JTextField();
        sub1.setBounds(150, 50, 110, 20);
        panel.add(sub1);
        sub1.setColumns(10);

        JLabel lblSub2 = new JLabel("Subject 2");
        lblSub2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblSub2.setBounds(50, 90, 85, 20);
        panel.add(lblSub2);

        sub2 = new JTextField();
        sub2.setBounds(150, 90, 110, 20);
        panel.add(sub2);
        sub2.setColumns(10);

        JLabel lblSub3 = new JLabel("Subject 3");
        lblSub3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblSub3.setBounds(50, 130, 85, 20);
        panel.add(lblSub3);

        sub3 = new JTextField();
        sub3.setBounds(150, 130, 110, 20);
        panel.add(sub3);
        sub3.setColumns(10);

        JLabel lblTotal = new JLabel("Total Marks");
        lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblTotal.setBounds(50, 170, 85, 20);
        panel.add(lblTotal);

        totalmarks = new JTextField();
        totalmarks.setBounds(150, 170, 110, 20);
        totalmarks.setEditable(false);
        panel.add(totalmarks);
        totalmarks.setColumns(10);

        JLabel lblAverage = new JLabel("Average");
        lblAverage.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblAverage.setBounds(50, 210, 85, 20);
        panel.add(lblAverage);

        average = new JTextField();
        average.setBounds(150, 210, 110, 20);
        average.setEditable(false);
        panel.add(average);
        average.setColumns(10);

        JLabel lblGrade = new JLabel("Grade");
        lblGrade.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblGrade.setBounds(50, 250, 85, 20);
        panel.add(lblGrade);

        grade = new JTextField();
        grade.setBounds(150, 250, 110, 20);
        grade.setEditable(false);
        panel.add(grade);
        grade.setColumns(10);

        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int s1 = Integer.parseInt(sub1.getText());
                    int s2 = Integer.parseInt(sub2.getText());
                    int s3 = Integer.parseInt(sub3.getText());

                    int total = s1 + s2 + s3;
                    float avg = (float) total / 3;

                    totalmarks.setText(String.valueOf(total));
                    average.setText(String.format("%.2f", avg));

                    if (avg >= 90) {
                        grade.setText("A");
                    } else if (avg >= 80) {
                        grade.setText("B");
                    } else if (avg >= 70) {
                        grade.setText("C");
                    } else if (avg >= 50) {
                        grade.setText("D");
                    } else {
                        grade.setText("F");
                    }
                } catch (NumberFormatException ex) {
                    totalmarks.setText("Error");
                    average.setText("Error");
                    grade.setText("Invalid Input");
                }
            }
        });
        btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnCalculate.setBounds(300, 80, 100, 30);
        panel.add(btnCalculate);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sub1.setText("");
                sub2.setText("");
                sub3.setText("");
                totalmarks.setText("");
                average.setText("");
                grade.setText("");
                sub1.requestFocus();
            }
        });
        btnClear.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnClear.setBounds(300, 140, 100, 30);
        panel.add(btnClear);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnExit.setBounds(300, 200, 100, 30);
        panel.add(btnExit);
    }
}
