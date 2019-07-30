package utility;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import static utility.osSwitch.*;

public class frameUtility extends JFrame  {
    boolean isHard = false;
    public frameUtility() {
        setTitle("THANOS");
        setLayout(new FlowLayout());
        setJPanelandComponents();
        setSize(200, 100);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setJPanelandComponents()  {
        JButton soft = new JButton("Soft Kill");
        JButton hard = new JButton("Hard Kill");
        List <JButton> jbuttonList = setButton(soft, hard);
        JPanel jp = new JPanel();
        jp.setBorder(BorderFactory.createTitledBorder("JPanel Title"));
        jp.add(jbuttonList.get(0)); //soft
        jp.add(jbuttonList.get(1)); //hard
        add(jp);
    }

    private List<JButton> setButton(JButton soft, JButton  hard) {
        List<JButton> result = new ArrayList<>();
        soft.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)  {
                // SoftKill
                System.out.println("SOFT");
                isHard = false;
                try {
                    searchOs(isHard);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                dispose();
            }
        });
        hard.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // HardKill
                System.out.println("HARD");
                isHard = true;
                try {
                    searchOs(isHard);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                dispose();
            }
        });
        result.add(soft);
        result.add(hard);

        return result;
    }
}


