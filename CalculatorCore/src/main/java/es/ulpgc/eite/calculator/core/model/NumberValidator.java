package es.ulpgc.eite.calculator.core.model;

public class NumberValidator {

	private long _lowBound;
	private long _highBound;
	
	public NumberValidator(int lowBound, int highBound) {
		setLowBound(lowBound);
		setHighBound(highBound);
	}
	
	public void checkBounds(long value) throws Exception {
	    if (value > getHighBound()) {
	         throw new Overflow();

	    } else if (value < getLowBound()) {
	         throw new Underflow();
	    }		
	}


	private long getLowBound() {
		return _lowBound;
	}

	private void setLowBound(long value) {
		_lowBound = value;
	}

	private long getHighBound() {
		return _highBound;
	}

	private void setHighBound(long value) {
		_highBound = value;
	}

	public class Underflow extends Exception {
        private static final long serialVersionUID = 1L;
    }

    public class Overflow extends Exception {
        private static final long serialVersionUID = 1L;
    }

}
