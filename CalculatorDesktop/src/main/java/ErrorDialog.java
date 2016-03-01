
import javax.swing.JFrame;

public class ErrorDialog extends Dialog {
	private static final long serialVersionUID = 1L;

	public ErrorDialog(JFrame ventana, String mensaje) {
		super (ventana, "Mensaje de error", mensaje);
	}
}
