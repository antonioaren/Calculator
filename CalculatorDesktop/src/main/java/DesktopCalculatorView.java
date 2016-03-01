import es.ulpgc.eite.calculator.core.model.CalculatorModel;
import es.ulpgc.eite.calculator.core.model.I_CalculatorModel;
import es.ulpgc.eite.calculator.core.presenter.CalculatorPresenter;
import es.ulpgc.eite.calculator.core.presenter.I_CalculatorPresenter;
import es.ulpgc.eite.calculator.core.view.I_CalculatorView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesktopCalculatorView implements I_CalculatorView {
	private I_CalculatorModel _model;
	private I_CalculatorPresenter _presenter;

	private JFrame _guiFrame;
	private JTextField _display;

	private static final Font _screenFont = new Font("CalculatorScreen", Font.PLAIN, 35);
	private static final Font _operatorFont = new Font("CalculatorOperator", Font.PLAIN, 30);
	private static final Font _digitFont = new Font("CalculatorDigit", Font.PLAIN, 25);
	private static final Font _controlFont = new Font("CalculatorControl", Font.PLAIN, 20);


	public DesktopCalculatorView() {
		_guiFrame = new JFrame();

		//make sure the program exits when the frame closes
		_guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_guiFrame.setTitle("Simple Calculator");
		_guiFrame.setSize(300,400);

		//This will center the JFrame in the middle of the screen
		_guiFrame.setLocationRelativeTo(null);

		_display = new JTextField();
		_display.setFont(_screenFont);
		_display.setHorizontalAlignment(JTextField.RIGHT);
		_display.setEditable(false);

		_guiFrame.add(_display, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel();

		//Make a Grid
		buttonPanel.setLayout(new GridLayout(5,1));
		_guiFrame.add(buttonPanel, BorderLayout.CENTER);

        //  ------ Initialization of the Model-View-Presenter
		_model     = new CalculatorModel();
        _presenter = new CalculatorPresenter(this, _model);

		//First row
		JPanel buttonPanelRow1 = new JPanel();
		buttonPanelRow1.setLayout(new GridLayout(1,2));
		buttonPanel.add(buttonPanelRow1, BorderLayout.CENTER);

		addBackspaceAction(buttonPanelRow1, "Clear", _presenter);
		//  To-do: Ejercicio propuesto: programar este boton como "Clear" para que
		//  ponga a 0 el valor de la calculadora.

		addBackspaceAction(buttonPanelRow1, "Backspace", _presenter);

		//Second row
		JPanel buttonPanelRow2 = new JPanel();
		buttonPanelRow2.setLayout(new GridLayout(1,4));
		buttonPanel.add(buttonPanelRow2, BorderLayout.CENTER);

		for (int i=1;i<=3;i++) {
			addDigit(buttonPanelRow2, String.valueOf(i), _presenter);
		}
		addOperator(buttonPanelRow2, "/", Color.BLUE, _presenter);

		//Third row
		JPanel buttonPanelRow3 = new JPanel();
		buttonPanelRow3.setLayout(new GridLayout(1,4));
		buttonPanel.add(buttonPanelRow3, BorderLayout.CENTER);

		for (int i=4;i<=6;i++) {
			addDigit(buttonPanelRow3, String.valueOf(i), _presenter);
		}
		addOperator(buttonPanelRow3, "*", Color.BLUE, _presenter);

		//Fourth row
		JPanel buttonPanelRow4 = new JPanel();
		buttonPanelRow4.setLayout(new GridLayout(1,4));
		buttonPanel.add(buttonPanelRow4, BorderLayout.CENTER);

		for (int i=7;i<=9;i++) {
			addDigit(buttonPanelRow4, String.valueOf(i), _presenter);
		}
		addOperator(buttonPanelRow4, "-", Color.BLUE, _presenter);

		//Fifth row
		JPanel buttonPanelRow5 = new JPanel();
		buttonPanelRow5.setLayout(new GridLayout(1,4));
		buttonPanel.add(buttonPanelRow5, BorderLayout.CENTER);

		addDigit(buttonPanelRow5, "0", _presenter);

		addOperator(buttonPanelRow5, ".", Color.BLUE, _presenter);
		//  To-do: Ejercicio propuesto: programar este boton como "." para que
		//  la calculadora trabaje con decimales.

		addOperator(buttonPanelRow5, "=", Color.GREEN, _presenter);
		addOperator(buttonPanelRow5, "+", Color.BLUE, _presenter);

		_guiFrame.setVisible(true);
        display("0");
	}


	public void initCalculator() { }

	public void display(String text) {
		_display.setText(text);
	}

//	public void displayWarning(String text) { _display.setText(text); }
	public void displayWarning(String text) { new ErrorDialog(_guiFrame, text); }

	private void addBackspaceAction(Container parent,  String name, I_CalculatorPresenter presenter) {
		JButton _button = new JButton(name);
		_button.setOpaque(true);
		_button.setBorderPainted(false);
		_button.setActionCommand(name);
		_button.setFont(_controlFont);
		_button.setBackground(Color.red);
		_button.setForeground(Color.white);

		BackspaceAction _action = new BackspaceAction(presenter);
		_button.addActionListener(_action);

		addButton(parent, _button);
	}

	private void addDigit(Container parent, String name, I_CalculatorPresenter presenter) {
		JButton _button = new JButton(name);
		_button.setOpaque(true);
		_button.setBorderPainted(false);
		_button.setActionCommand(name);
		_button.setFont(_digitFont);
		_button.setBackground(Color.BLACK);
		_button.setForeground(Color.WHITE);

		DigitAction _action = new DigitAction(name, presenter);
		_button.addActionListener(_action);

		addButton(parent, _button);
	}

	private void addOperator(Container parent, String name, Color color, I_CalculatorPresenter presenter) {
		JButton _button = new JButton(name);
		_button.setOpaque(true);
		_button.setBorderPainted(false);
		_button.setActionCommand(name);
		_button.setFont(_operatorFont);
		_button.setBackground(color);
		_button.setForeground(Color.WHITE);

		OperatorAction _action = new OperatorAction(name, presenter);
		_button.addActionListener(_action);

		addButton(parent, _button);
	}

	private void addButton(Container parent, JButton button) {
		JPanel localButtonPanel = new JPanel();
		localButtonPanel.setLayout(new BorderLayout());
		localButtonPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		localButtonPanel.add(button, BorderLayout.CENTER);
		parent.add(localButtonPanel);
	}

	private class BackspaceAction implements ActionListener {
		private I_CalculatorPresenter _presenter;

		public BackspaceAction(I_CalculatorPresenter presenter) {
			_presenter = presenter;
		}

		public void actionPerformed(ActionEvent event) {
			_presenter.backspacePressed();
		}
	}

	private class OperatorAction implements ActionListener {
        private I_CalculatorPresenter _presenter;
 		private String _text;

		public OperatorAction(String text, I_CalculatorPresenter presenter) {
			_text = text;
			_presenter = presenter;
		}

		public void actionPerformed(ActionEvent event) {
			_presenter.operatorPressed(_text);
		}
	}
	
	private class DigitAction implements ActionListener {
        private I_CalculatorPresenter _presenter;
		private String _text;
        
		public DigitAction(String text, I_CalculatorPresenter presenter) {
			_text = text;
			_presenter = presenter;
		}

		public void actionPerformed(ActionEvent event)
		{
			_presenter.digitPressed(_text);
		}
	}

}
