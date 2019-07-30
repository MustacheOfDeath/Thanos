package utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static utility.osSwitch.*;

public class frameUtility extends JFrame {
    boolean isHard = false;
    static int SOFT = 0;
    static int HARD = 1;

    JPanel jp = new JPanel();

    JButton soft = new JButton("Soft Kill");
    JButton hard = new JButton("Hard Kill");

    public frameUtility() {
        setTitle("THANOS");
        setLayout(new FlowLayout());
        setJPanelandComponents();
        setSize(200, 100);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setJPanelandComponents() {
        List<JButton> jbuttonList = setButton(soft, hard);
        jp.add(jbuttonList.get(SOFT));
        jp.add(jbuttonList.get(HARD));
        add(jp);
    }

    private List<JButton> setButton(final JButton soft, final JButton hard) {
        List<JButton> result = new ArrayList<>();
        soft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // SoftKill
                isHard = false;
                try {
                    searchOs(isHard);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                dispose();
            }
        });
        hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // HardKill
                isHard = true;
                try {
                    searchOs(isHard);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                soft.setVisible(false);
                hard.setVisible(false);
                showThanos();

            }
        });

        result.add(SOFT, soft);
        result.add(HARD, hard);

        return result;
    }

    public void showThanos() {
        //TODO insert Thanos image
        //frame
        setSize(500, 500);
        setLocationRelativeTo(null);

        //Label
        JLabel thanosLabel = new JLabel("THANOS IMAGE");

        //Panel
        jp.setSize(500, 500);
        jp.add(thanosLabel);
    }
}


