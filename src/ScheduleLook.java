import java.util.Vector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScheduleLook {
	
	public ScheduleLook(Vector<Team> tm, Coach ch, Team yu) {
	Frame frame = new JFrame("College Basketball Manager");
    ((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.setSize(1000, 500);
    frame.setVisible(true);
	
	JLabel sced = new JLabel("SCHEDULE");
	JTextArea textArea = new JTextArea(10, 50); // Rows x Columns
    textArea.setWrapStyleWord(true);
    textArea.setLineWrap(true);
    textArea.append(yu.printsced());
    textArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(textArea);
    panel.add(sced);
	panel.add(scrollPane);
	
	JButton cont = new JButton("Continue");
	panel.add(cont);
	frame.add(panel);
	
	cont.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            new MainScreen(tm, ch);
        }
    });
	}
}
