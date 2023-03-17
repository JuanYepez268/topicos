import javax.swing.*;


public class interfaz extends JFrame{
	private JLabel label1;
	
	public interfaz() {
		setLayout(null);
		label1=new JLabel("texto de prueba");
		label1.setBounds(10,20,300,300);
		add(label1);
	}
	
	public static void main(String args[]) {
		interfaz formulario1= new interfaz();
		formulario1.setBounds(0,0,800,300);
		formulario1.setVisible(true);
		formulario1.setLocationRelativeTo(null);
	}

}