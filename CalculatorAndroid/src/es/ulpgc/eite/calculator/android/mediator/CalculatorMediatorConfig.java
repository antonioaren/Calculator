package es.ulpgc.eite.calculator.android.mediator;

import es.ulpgc.eite.calculator.android.pattern.model.AndroidCalculatorModel;
import es.ulpgc.eite.calculator.android.portrait.PortraitCalculatorPresenter;
import es.ulpgc.eite.calculator.android.portrait.PortraitCalculatorView;
import es.ulpgc.eite.framework.core.mediator.I_MediatorSingleton;
import es.ulpgc.eite.framework.core.mediator.MediatorConfig;
import es.ulpgc.eite.framework.core.mediator.MediatorScreen;

public class CalculatorMediatorConfig extends MediatorConfig {


    public CalculatorMediatorConfig(I_MediatorSingleton mediator) {
        super(mediator);
    }

    @Override
    public void setCustomConfig() {
        setCalculatorConfig();
    }


    private void setCalculatorConfig() {
        setCalculatorTransitionCollection();
        setCalculatorScreenCollection();
    }


    private void setCalculatorTransitionCollection() {

    }

    private void setCalculatorScreenCollection() {
        getScreens().add(new MediatorScreen(
                PortraitCalculatorView.class,
                PortraitCalculatorPresenter.class,
                AndroidCalculatorModel.class));
    }



}
