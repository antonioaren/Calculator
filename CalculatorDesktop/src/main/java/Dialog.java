
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Dialog extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	public Dialog(JFrame ventana, String titulo, String mensaje) {
		super (ventana, titulo, true);
		JLabel  texto = new JLabel("        "+mensaje+"        ");
		texto.setFont(new Font("Arial", Font.BOLD, 20));
		texto.setLayout(new FlowLayout());
		JButton ok    = new JButton("OK");
		ok.addActionListener (this);
		setLayout(new BorderLayout (10,10));
		add (texto,BorderLayout.CENTER);
		add (ok,   BorderLayout.SOUTH);
		pack();
        setLocationRelativeTo(null);
		setVisible (true);
	}
		
	public void actionPerformed (ActionEvent e){
		dispose();
	}
}
