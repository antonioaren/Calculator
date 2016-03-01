package es.ulpgc.eite.calculator.android.pattern.view;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import es.ulpgc.eite.calculator.android.R;
import es.ulpgc.eite.calculator.core.presenter.I_CalculatorPresenter;
import es.ulpgc.eite.calculator.core.view.I_CalculatorView;
import es.ulpgc.eite.framework.android.AndroidScreenView;

public abstract class AndroidCalculatorView
        extends AndroidScreenView implements I_CalculatorView, View.OnClickListener {


    public abstract int getCalculatorLayout();


    @Override
    public void initCalculator() {
        debug("initCalculator");

        setContentView(getCalculatorLayout());
        setCalculatorButtons();

    }

    public I_CalculatorPresenter getCalculatorPresenter() {
        return (I_CalculatorPresenter) getScreenPresenter();
    }


    private void setCalculatorButtons() {

        registerListener(R.id.button0);
        registerListener(R.id.button1);
        registerListener(R.id.button2);
        registerListener(R.id.button3);
        registerListener(R.id.button4);
        registerListener(R.id.button5);
        registerListener(R.id.button6);
        registerListener(R.id.button7);
        registerListener(R.id.button8);
        registerListener(R.id.button9);

        registerListener(R.id.buttonPlus);
        registerListener(R.id.buttonMinus);
        registerListener(R.id.buttonMult);
        registerListener(R.id.buttonDivide);

        registerListener(R.id.buttonClear);
        registerListener(R.id.buttonEqual);
        registerListener(R.id.buttonBackspace);
        registerListener(R.id.buttonDot);
    }


    private void registerListener(int btnId) {

        View btn = findViewById(btnId);

        if (btn != null) {
            btn.setOnClickListener(this);
        } else {
            debug("registerListener", "error", "resource not available");
        }
    }



    @Override
    public void onClick(View btn) {
        debug("onClick");

        int btnId = btn.getId();

        switch (btnId) {
            case R.id.button0:
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
                String digit = getButtonLabel(btn);
                debug("onClick", "", digit);
                getCalculatorPresenter().digitPressed(digit);
                break;

            case R.id.buttonPlus:
            case R.id.buttonMinus:
            case R.id.buttonMult:
            case R.id.buttonDivide:
            case R.id.buttonEqual:
                String op = getButtonLabel(btn);
                debug("onClick", "op", op);
                getCalculatorPresenter().operatorPressed(op);
                break;

            case R.id.buttonClear:
                debug("onClick", "btn", "clear");
                displayWarning("clear pressed");
                getCalculatorPresenter().clearPressed();
                break;

            case R.id.buttonBackspace:
                debug("onClick", "btn", "backspace");
                displayWarning("backspace pressed");
                getCalculatorPresenter().backspacePressed();
                break;

            case R.id.buttonDot:
                displayWarning("dot pressed");
                break;
        }
    }


    @Override
    public void displayWarning(String text) {
        Toast.makeText(getBaseContext(), text, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void display(String text) {
        debug("display", "text", text);

        TextView display = (TextView) findViewById(R.id.display);
        display.setText(text);
    }


    private String getButtonLabel(View _btn) {
        Button btn = (Button) _btn;
        return btn.getText().toString();
    }


}
