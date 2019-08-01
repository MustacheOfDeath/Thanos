package it.lf.thanos.utility;

import javax.imageio.ImageIO;
import javax.swing.*;

import static it.lf.thanos.utility.OsSwitch.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FrameUtility extends JFrame {
	
	private static final long serialVersionUID = 1L;

	boolean isHard = false;
    static int SOFT = 0;
    static int HARD = 1;

    JPanel jp = new JPanel();

    JButton soft = new JButton("Soft Kill");
    JButton hard = new JButton("Hard Kill");

    public FrameUtility() {
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
        //frame
        setSize(1000, 600);
        setLocationRelativeTo(null);
        Image image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/image/thanos.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon thanos = new ImageIcon(image);
        //Label
        JLabel thanosLabel = new JLabel("");
        thanosLabel.setIcon(thanos);
        //Panel
        jp.add(thanosLabel);
    }
}


