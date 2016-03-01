package es.ulpgc.eite.calculator.android.mediator;


import es.ulpgc.eite.framework.android.AndroidMediatorSingleton;

public class CalculatorMediatorSingleton extends AndroidMediatorSingleton {

    @Override
    public void createMediator() {
        setCustomConfig(new CalculatorMediatorConfig(this));
    }


}
