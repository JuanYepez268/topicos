import javax.swing.*;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class interfaz extends JFrame{	//Declaración de elementos
	private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel JLImagen1;
    private javax.swing.JLabel JLImagen2;
    private javax.swing.JPanel JPHistograma1;
    private javax.swing.JPanel JPHistograma2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
	
	public interfaz() {
		setLayout(null);
		initComponents();	
		this.setLocationRelativeTo(this);
        SetImageLabel(JLImagen1, "D:/Manuel/Pictures/Saved Pictures/1.png");
        SetImageLabel(JLImagen2, "D:/Manuel/Pictures/Saved Pictures/20.jpg");
		
	}
	
	public static void main(String args[]) {
		//Abertura de ventana
		interfaz formulario1= new interfaz();
		formulario1.setBounds(0,0,800,800);
		formulario1.setVisible(true);
		formulario1.setLocationRelativeTo(null);
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
	}

	
	 private void initComponents() {

	        jPanel1 = new javax.swing.JPanel();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();	        
	        JLImagen1 = new javax.swing.JLabel();
	        JLImagen2 = new javax.swing.JLabel();
	        JPHistograma1 = new javax.swing.JPanel();
	        JPHistograma2 = new javax.swing.JPanel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jComboBox1 = new javax.swing.JComboBox<>();
	        jLabel5 = new javax.swing.JLabel();
	    
	        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
	        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
	        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));
	        jPanel1.setName("Contenedor"); // NOI18N
	        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));

	        JLImagen1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        JLImagen1.setText("IMAGEN 1");
	        JLImagen1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
	        JLImagen1.setMaximumSize(new java.awt.Dimension(250, 250));
	        JLImagen1.setMinimumSize(new java.awt.Dimension(250, 250));
	        JLImagen1.setName("Imagen1"); // NOI18N
	        JLImagen1.setPreferredSize(new java.awt.Dimension(250, 250));

	        JLImagen2.setBackground(new java.awt.Color(255, 255, 204));
	        JLImagen2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        JLImagen2.setText("IMAGEN 2");
	        JLImagen2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
	        JLImagen2.setMaximumSize(new java.awt.Dimension(250, 250));
	        JLImagen2.setMinimumSize(new java.awt.Dimension(250, 250));
	        JLImagen2.setName("Imagen2"); // NOI18N
	        JLImagen2.setPreferredSize(new java.awt.Dimension(250, 250));

	        JPHistograma1.setMaximumSize(new java.awt.Dimension(120, 120));
	        JPHistograma1.setMinimumSize(new java.awt.Dimension(120, 120));
	        JPHistograma1.setPreferredSize(new java.awt.Dimension(120, 120));

	        javax.swing.GroupLayout JPHistograma1Layout = new javax.swing.GroupLayout(JPHistograma1);
	        JPHistograma1.setLayout(JPHistograma1Layout);
	        JPHistograma1Layout.setHorizontalGroup(
	            JPHistograma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 0, Short.MAX_VALUE)
	        );
	        JPHistograma1Layout.setVerticalGroup(
	            JPHistograma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 120, Short.MAX_VALUE)
	        );

	        JPHistograma2.setMaximumSize(new java.awt.Dimension(120, 120));
	        JPHistograma2.setMinimumSize(new java.awt.Dimension(120, 120));
	        JPHistograma2.setPreferredSize(new java.awt.Dimension(120, 120));

	        javax.swing.GroupLayout JPHistograma2Layout = new javax.swing.GroupLayout(JPHistograma2);
	        JPHistograma2.setLayout(JPHistograma2Layout);
	        JPHistograma2Layout.setHorizontalGroup(
	            JPHistograma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 0, Short.MAX_VALUE)
	        );
	        JPHistograma2Layout.setVerticalGroup(
	            JPHistograma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 0, Short.MAX_VALUE)
	        );

	        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
	        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel2.setText("Imagen 2");

	        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
	        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel3.setText("Imagen 1");

	        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
	        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel1.setText("Histograma 1");

	        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
	        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel4.setText("Histograma 2");

	        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Colores", "Grises", "Negativo", "Aclarar", "Obscurecer", "Binarización simple", "Binarización Compuesta", "Segmentación", "Suma de Imagenes", "Resta de imagenes" }));
	        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jComboBox1ActionPerformed(evt);
	            }
	        });

	        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
	        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel5.setText("Filtros");

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(174, 174, 174)
	                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(172, 172, 172))
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(100, 100, 100)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                        .addComponent(JPHistograma1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
	                        .addComponent(JLImagen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                        .addComponent(JLImagen2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(JPHistograma2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
	                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(100, 100, 100))
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(231, 231, 231))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(120, 120, 120)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel2)
	                    .addComponent(jLabel3))
	                .addGap(18, 18, 18)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(JLImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(JLImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(JPHistograma1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(JPHistograma2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(130, 130, 130))
	        );

	        JLImagen1.getAccessibleContext().setAccessibleName("Imagen1");
	        JLImagen2.getAccessibleContext().setAccessibleName("Imagen2");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );

	        pack();
	    }
	
	 //Metodo de la lista desplegable
	 private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
	        // TODO add your handling code here:
	    }                                          

	 //Metodo para poner imagen en los label
	 private void SetImageLabel(JLabel Imagen1, String root){
         ImageIcon image = new ImageIcon(root);
         Icon icon = new ImageIcon(image.getImage().getScaledInstance(Imagen1.getWidth(), Imagen1.getHeight(), Image.SCALE_DEFAULT));
         Imagen1.setIcon(icon);
         this.repaint();
     }
}
