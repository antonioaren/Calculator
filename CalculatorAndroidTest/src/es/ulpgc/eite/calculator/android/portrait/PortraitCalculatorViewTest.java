package es.ulpgc.eite.calculator.android.portrait;

import android.annotation.TargetApi;
import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class es.ulpgc.eite.calculator.android.portrait.PortraitCalculatorViewTest \
 * es.ulpgc.eite.calculator.android.tests/android.test.InstrumentationTestRunner
 */

import java.util.ArrayList;
import android.test.UiThreadTest;
import android.widget.Button;

import android.widget.TextView;
import es.ulpgc.eite.calculator.android.R;

@TargetApi(3)
public class PortraitCalculatorViewTest extends ActivityInstrumentationTestCase2<PortraitCalculatorView> {

    /*
     * Constructor for the test class. Required by Android test classes. The constructor
     * must call the super constructor, providing the Android package name of the app under test
     * and the Java class name of the activity in that application that handles the MAIN intent.
    */

    public PortraitCalculatorViewTest() {
        super(PortraitCalculatorView.class);
    }

    private PortraitCalculatorView mActivity;

    private Button mbutton0;
    private Button mbutton1;
    private Button mbutton2;
    private Button mbutton3;
    private Button mbutton4;
    private Button mbutton5;
    private Button mbutton6;
    private Button mbutton7;
    private Button mbutton8;
    private Button mbutton9;

    private Button mbuttonPlus;
    private Button mbuttonMinus;
    private Button mbuttonMult;
    private Button mbuttonDivide;

    private Button mbuttonClear;
    private Button mbuttonEqual;

    private Button mbuttonBackspace;
    private Button mbuttonDot;

    private TextView mdisplay;

    @Override
    protected void setUp() throws Exception {
        super.setUp(); // required by JUnit

		/*
		 * prepare to send key events to the app under test by turning off touch mode.
		 * Must be done before the first call to getActivity()
		 */

        setActivityInitialTouchMode(false);

		/*
		 * Start the app under test by starting its main activity. The test runner already knows
		 * which activity this is from the call to the super constructor, as mentioned
		 * previously. The tests can now use instrumentation to directly access the main
		 * activity through mActivity.
		 */
        mActivity = getActivity();

        mdisplay = (TextView) mActivity.findViewById(R.id.display);

        mbutton0 = (Button) mActivity.findViewById(R.id.button0);
        mbutton1 = (Button) mActivity.findViewById(R.id.button1);
        mbutton2 = (Button) mActivity.findViewById(R.id.button2);
        mbutton3 = (Button) mActivity.findViewById(R.id.button3);
        mbutton4 = (Button) mActivity.findViewById(R.id.button4);
        mbutton5 = (Button) mActivity.findViewById(R.id.button5);
        mbutton6 = (Button) mActivity.findViewById(R.id.button6);
        mbutton7 = (Button) mActivity.findViewById(R.id.button7);
        mbutton8 = (Button) mActivity.findViewById(R.id.button8);
        mbutton9 = (Button) mActivity.findViewById(R.id.button9);

        mbuttonPlus = (Button) mActivity.findViewById(R.id.buttonPlus);
        mbuttonMinus = (Button) mActivity.findViewById(R.id.buttonMinus);
        mbuttonMult = (Button) mActivity.findViewById(R.id.buttonMult);
        mbuttonDivide = (Button) mActivity.findViewById(R.id.buttonDivide);

        mbuttonClear = (Button) mActivity.findViewById(R.id.buttonClear);
        mbuttonEqual = (Button) mActivity.findViewById(R.id.buttonEqual);

        mbuttonBackspace = (Button) mActivity.findViewById(R.id.buttonBackspace);
        mbuttonDot = (Button) mActivity.findViewById(R.id.buttonDot);
    }

    // -------------------------------------------------------------------------------

    @UiThreadTest
    public void test00_init() {
        assertEquals ("0", mdisplay.getText().toString());
    }

    // Test all digits: 1234567890
    @UiThreadTest
    public void test01_display() {
        mbutton1.performClick();
        mbutton2.performClick();
        mbutton3.performClick();

        mbutton4.performClick();
        mbutton5.performClick();
        mbutton6.performClick();

        mbutton7.performClick();
        mbutton8.performClick();
        mbutton9.performClick();

        mbutton0.performClick();

        assertEquals ("1234567890", mdisplay.getText().toString());
    }

    // 12 <clear>
    @UiThreadTest
    public void test02_clear() {
        mbutton1.performClick();
        mbutton2.performClick();
        assertEquals ("12", mdisplay.getText().toString());

        mbuttonClear.performClick();
        assertEquals ("0", mdisplay.getText().toString());
    }

    // -------------------------------------------------------------------------------
    //                                Testing Addition
    // -------------------------------------------------------------------------------

    // 1 + 2 =
    @UiThreadTest
    public void test03_basicOpAdd01() {
        mbuttonClear.performClick();
        mbutton1.performClick();

        // 1
        assertEquals ("1", mdisplay.getText().toString());

        // +
        mbuttonPlus.performClick();
        assertEquals ("1", mdisplay.getText().toString());

        // 2
        mbutton2.performClick();
        assertEquals ("2", mdisplay.getText().toString());

        // =
        mbuttonEqual.performClick();
        assertEquals ("3", mdisplay.getText().toString());
    }

    // 1 + 2 + 4 =
    @UiThreadTest
    public void test03_basicOpAdd02() {
        mbuttonClear.performClick();

        // 1
        mbutton1.performClick();
        assertEquals ("1", mdisplay.getText().toString());

        // +
        mbuttonPlus.performClick();
        assertEquals ("1", mdisplay.getText().toString());

        // 2
        mbutton2.performClick();
        assertEquals ("2", mdisplay.getText().toString());

        // +
        mbuttonPlus.performClick();
        assertEquals ("3", mdisplay.getText().toString());

        // 4
        mbutton4.performClick();
        assertEquals ("4", mdisplay.getText().toString());

        // =
        mbuttonEqual.performClick();
        assertEquals ("7", mdisplay.getText().toString());
    }

    // 123 + 3 =
    @UiThreadTest
    public void test03_basicOpAdd03() {
        mbuttonClear.performClick();

        mbutton1.performClick();
        mbutton2.performClick();
        mbutton3.performClick();

        // 123
        assertEquals ("123", mdisplay.getText().toString());

        // +
        mbuttonPlus.performClick();
        assertEquals ("123", mdisplay.getText().toString());

        // 3
        mbutton3.performClick();
        assertEquals ("3", mdisplay.getText().toString());

        // =
        mbuttonEqual.performClick();
        assertEquals ("126", mdisplay.getText().toString());
    }

    // 2 + 9999999999 + 3 =
    @UiThreadTest
    public void test03_basicOpAdd04() {
        mbuttonClear.performClick();

        // 2
        mbutton2.performClick();
        assertEquals ("2", mdisplay.getText().toString());

        // +
        mbuttonPlus.performClick();
        assertEquals ("2", mdisplay.getText().toString());

        // 9999999999
        for (int j=1; j<=10; j++) {
            mbutton9.performClick();
        }

        assertEquals ("9999999999", mdisplay.getText().toString());

        // +
        mbuttonPlus.performClick();
        assertEquals ("2", mdisplay.getText().toString());

        mbutton3.performClick();
        assertEquals ("3", mdisplay.getText().toString());

        // =
        mbuttonEqual.performClick();
        assertEquals ("5", mdisplay.getText().toString());
    }

    // -------------------------------------------------------------------------------
    //                                Testing Subtraction
    // -------------------------------------------------------------------------------

    // -2
    @UiThreadTest
    public void test03_basicOpSub00() {
        mbuttonClear.performClick();

        mbuttonMinus.performClick();
        mbutton2.performClick();
        mbuttonEqual.performClick();

        assertEquals ("-2", mdisplay.getText().toString());
    }

    // 1 - 2 =
    @UiThreadTest
    public void test04_basicOpSub01() {
        mbuttonClear.performClick();

        mbutton1.performClick();

        // 1
        assertEquals ("1", mdisplay.getText().toString());

        // -
        mbuttonMinus.performClick();
        assertEquals ("1", mdisplay.getText().toString());

        // 2
        mbutton2.performClick();
        assertEquals ("2", mdisplay.getText().toString());

        // =
        mbuttonEqual.performClick();
        assertEquals ("-1", mdisplay.getText().toString());
    }

    // 1 - 2 - 3 =
    @UiThreadTest
    public void test04_basicOpSub02() {
        mbuttonClear.performClick();

        mbutton1.performClick();

        // 1
        assertEquals ("1", mdisplay.getText().toString());

        // -
        mbuttonMinus.performClick();
        assertEquals ("1", mdisplay.getText().toString());

        // 2
        mbutton2.performClick();
        assertEquals ("2", mdisplay.getText().toString());

        // -
        mbuttonMinus.performClick();
        assertEquals ("-1", mdisplay.getText().toString());

        // 3
        mbutton3.performClick();
        assertEquals ("3", mdisplay.getText().toString());

        // =
        mbuttonEqual.performClick();
        assertEquals ("-4", mdisplay.getText().toString());
    }

    // 123 + 3 =
    @UiThreadTest
    public void test03_basicOpSub03() {
        mbuttonClear.performClick();

        mbutton1.performClick();
        mbutton2.performClick();
        mbutton3.performClick();

        // 123
        assertEquals ("123", mdisplay.getText().toString());

        // -
        mbuttonMinus.performClick();
        assertEquals ("123", mdisplay.getText().toString());

        // 3
        mbutton3.performClick();
        assertEquals ("3", mdisplay.getText().toString());

        // =
        mbuttonEqual.performClick();
        assertEquals ("120", mdisplay.getText().toString());
    }

    // -------------------------------------------------------------------------------
    //                                Testing Multiplication
    // -------------------------------------------------------------------------------

    // 2 * 3 =
    @UiThreadTest
    public void test05_basicOpMul01() {
        mbuttonClear.performClick();

        // 2
        mbutton2.performClick();
        assertEquals ("2", mdisplay.getText().toString());

        // *
        mbuttonMult.performClick();
        assertEquals ("2", mdisplay.getText().toString());

        // 3
        mbutton3.performClick();
        assertEquals ("3", mdisplay.getText().toString());

        // =
        mbuttonEqual.performClick();
        assertEquals ("6", mdisplay.getText().toString());
    }

    // 2 * 3 * 4 =
    @UiThreadTest
    public void test05_basicOpMul02() {
        mbuttonClear.performClick();

        // 2
        mbutton2.performClick();
        assertEquals ("2", mdisplay.getText().toString());

        // *
        mbuttonMult.performClick();
        assertEquals ("2", mdisplay.getText().toString());

        // 3
        mbutton3.performClick();
        assertEquals ("3", mdisplay.getText().toString());

        // *
        mbuttonMult.performClick();
        assertEquals ("6", mdisplay.getText().toString());

        // 4
        mbutton4.performClick();
        assertEquals ("4", mdisplay.getText().toString());

        // =
        mbuttonEqual.performClick();
        assertEquals ("24", mdisplay.getText().toString());
    }

    // 123 * 2 =
    @UiThreadTest
    public void test05_basicOpMul03() {
        mbuttonClear.performClick();

        mbutton1.performClick();
        mbutton2.performClick();
        mbutton3.performClick();

        // 123
        assertEquals ("123", mdisplay.getText().toString());

        // *
        mbuttonMult.performClick();
        assertEquals ("123", mdisplay.getText().toString());

        // 2
        mbutton2.performClick();
        assertEquals ("2", mdisplay.getText().toString());

        // =
        mbuttonEqual.performClick();
        assertEquals ("246", mdisplay.getText().toString());
    }

    // -------------------------------------------------------------------------------
    //                                Testing Division
    // -------------------------------------------------------------------------------

    // 24 / 3 =
    @UiThreadTest
    public void test06_basicOpDiv01() {
        mbuttonClear.performClick();

        // 2
        mbutton2.performClick();
        mbutton4.performClick();
        assertEquals ("24", mdisplay.getText().toString());

        // '/'
        mbuttonDivide.performClick();
        assertEquals ("24", mdisplay.getText().toString());

        // 3
        mbutton3.performClick();
        assertEquals ("3", mdisplay.getText().toString());

        // =
        mbuttonEqual.performClick();
        assertEquals ("8", mdisplay.getText().toString());
    }

    // 2 * 3 * 4 =
    @UiThreadTest
    public void test06_basicOpDiv02() {
        mbuttonClear.performClick();

        // 2
        mbutton2.performClick();
        mbutton4.performClick();
        assertEquals ("24", mdisplay.getText().toString());

        // '/'
        mbuttonDivide.performClick();
        assertEquals ("24", mdisplay.getText().toString());

        // 3
        mbutton3.performClick();
        assertEquals ("3", mdisplay.getText().toString());

        // '/'
        mbuttonDivide.performClick();
        assertEquals ("8", mdisplay.getText().toString());

        // 2
        mbutton2.performClick();
        assertEquals ("2", mdisplay.getText().toString());

        // =
        mbuttonEqual.performClick();
        assertEquals ("4", mdisplay.getText().toString());
    }

    // 123 * 2 =
    @UiThreadTest
    public void test06_basicOpDiv03() {
        mbuttonClear.performClick();

        mbutton1.performClick();
        mbutton2.performClick();
        mbutton3.performClick();

        // 123
        assertEquals ("123", mdisplay.getText().toString());

        // *
        mbuttonMult.performClick();
        assertEquals ("123", mdisplay.getText().toString());

        // 2
        mbutton2.performClick();
        assertEquals ("2", mdisplay.getText().toString());

        // =
        mbuttonEqual.performClick();
        assertEquals ("246", mdisplay.getText().toString());
    }

    // -------------------------------------------------------------------------------
    //                                Testing Operators
    // -------------------------------------------------------------------------------

    // + - * / =
    @UiThreadTest
    public void test07_basicOp01() {
        mbuttonClear.performClick();

        // +
        mbuttonPlus.performClick();
        assertEquals ("0", mdisplay.getText().toString());

        // -
        mbuttonMinus.performClick();
        assertEquals ("0", mdisplay.getText().toString());

        // *
        mbuttonMult.performClick();
        assertEquals ("0", mdisplay.getText().toString());

        // /
        mbuttonDivide.performClick();
        assertEquals ("0", mdisplay.getText().toString());
    }

    // 12 = + 3 =
    @UiThreadTest
    public void test07_basicOp02() {
        // 12
        mbutton1.performClick();
        assertEquals ("1", mdisplay.getText().toString());
        mbutton2.performClick();
        assertEquals ("12", mdisplay.getText().toString());

        // =
        mbuttonEqual.performClick();
        assertEquals ("12", mdisplay.getText().toString());

        // +
        mbuttonPlus.performClick();
        assertEquals ("12", mdisplay.getText().toString());

        // 3
        mbutton3.performClick();
        assertEquals ("3", mdisplay.getText().toString());

        // =
        mbuttonEqual.performClick();
        assertEquals ("15", mdisplay.getText().toString());
    }

    // -------------------------------------------------------------------------------
    //                                Testing Backspace
    // -------------------------------------------------------------------------------

    @UiThreadTest
    public void test08_backspace() {
        mbuttonClear.performClick();

        // 12
        mbutton1.performClick();
        mbutton2.performClick();
        mbutton3.performClick();
        assertEquals ("123", mdisplay.getText().toString());

        // <backspace>
        mbuttonBackspace.performClick();
        assertEquals ("12", mdisplay.getText().toString());

        // <backspace>
        mbuttonBackspace.performClick();
        assertEquals ("1", mdisplay.getText().toString());

        // 4
        mbutton4.performClick();
        assertEquals ("14", mdisplay.getText().toString());

        // <backspace>
        mbuttonBackspace.performClick();
        assertEquals ("1", mdisplay.getText().toString());

        // <backspace>
        mbuttonBackspace.performClick();
        assertEquals ("0", mdisplay.getText().toString());
    }

    // -------------------------------------------------------------------------------
    //                                 Stress Tests
    // -------------------------------------------------------------------------------

    private ArrayList<Button> appButtons;

    private void initDigits() {
        appButtons = new ArrayList<Button>();

        appButtons.add(mbutton0);
        appButtons.add(mbutton1);
        appButtons.add(mbutton2);
        appButtons.add(mbutton3);
        appButtons.add(mbutton4);
        appButtons.add(mbutton5);
        appButtons.add(mbutton6);
        appButtons.add(mbutton7);
        appButtons.add(mbutton8);
        appButtons.add(mbutton9);

        appButtons.add(mbuttonClear);
        appButtons.add(mbuttonClear);
        appButtons.add(mbuttonClear);
        appButtons.add(mbuttonClear);
        appButtons.add(mbuttonClear);
        appButtons.add(mbuttonClear);
        appButtons.add(mbuttonClear);
        appButtons.add(mbuttonClear);
    }

    private void initOperands() {
        appButtons = new ArrayList<Button>();

        appButtons.add(mbuttonPlus);
        appButtons.add(mbuttonMinus);
        appButtons.add(mbuttonMult);
        appButtons.add(mbuttonDivide);
    }

    private void initAllButtons() {
        appButtons = new ArrayList<Button>();

        appButtons.add(mbutton0);
        appButtons.add(mbutton1);
        appButtons.add(mbutton2);
        appButtons.add(mbutton3);
        appButtons.add(mbutton4);
        appButtons.add(mbutton5);
        appButtons.add(mbutton6);
        appButtons.add(mbutton7);
        appButtons.add(mbutton8);
        appButtons.add(mbutton9);

        appButtons.add(mbuttonPlus);
        appButtons.add(mbuttonMinus);
        appButtons.add(mbuttonMult);
        appButtons.add(mbuttonDivide);

        appButtons.add(mbuttonClear);
        appButtons.add(mbuttonEqual);
        appButtons.add(mbuttonBackspace);
        appButtons.add(mbuttonDot);
    }

    private Button randomButton() {
        Integer index = (int) (Math.random() * (appButtons.size() - 1));
        return appButtons.get(index);
    }

    @UiThreadTest
    public void test09_stress01() {
        initDigits();

        for (int j=0; j<200; j++) {
            randomButton().performClick();
        }
    }

    @UiThreadTest
    public void test09_stress02() {
        initOperands();

        for (int j=0; j<200; j++) {
            randomButton().performClick();
        }
    }

    @UiThreadTest
    public void test09_stress03() {
        initAllButtons();

        for (int j=0; j<200; j++) {
            randomButton().performClick();
        }
    }

}
