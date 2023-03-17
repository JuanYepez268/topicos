import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;

//hay que modificar el negativo

public class filtros {

    public static void main(String[] args) throws IOException {
        try {
            BufferedImage img = ImageIO.read(new File("C:\\Users\\juan2\\Pictures\\Ejemplo1.jpg"));
            
           System.out.println("Lectura realizada");
           int ancho = img.getWidth();
           int alto = img.getHeight();
           double[][] m = new double[ancho][alto];
           int[][] mr = new int[ancho][alto];
           int[][] mg = new int[ancho][alto];
           int[][] mb = new int[ancho][alto];
           for (int i = 0; i < ancho; i++){
                for (int j = 0; j < alto; j++){
                    m[i][j] = img.getRGB(i, j); // RGB = (R*65536)+(G*256)+B , (when R is RED, G is GREEN and B is BLUE)
                    mr[i][j] = ((int)m[i][j]>> 16) & 0x000000FF;
                    mg[i][j] = ((int)m[i][j]>> 8) & 0x000000FF;
                    mb[i][j] = ((int)m[i][j]) & 0x000000FF;
                    }
            }
                        
            System.out.println("Matriz RGB creada");
            System.out.println("Matriz de rojos creada");
            System.out.println("Matriz de verdes creada");
            System.out.println("Matriz de azules creada");
            procesar(ancho, alto, img, m, mr, mg, mb);
        }
        catch (IOException a) {
            System.out.println(a);
        }
    }
    private static void procesar(int ancho, int alto, BufferedImage img, double[][] m, int[][] mr, int[][] mg, int[][] mb) {
        JFrame marco = new JFrame("Editor de imágenes");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.getContentPane().add(new JLabel(new ImageIcon(img)));
        marco.setSize(ancho, alto);
        marco.setVisible(true);
        marco.repaint();
        
        JFrame marco2 = new JFrame("Funciones");
        marco2.getContentPane().add(new JLabel("<html>Usar 'g' para escala de grises<br>"
                                                   + "Usar 't' para binarizacion<br>"
                                                   + "Usar 'n' para negativo<br>"
                                                   + "Usar 'b' para brillo(+)(-)<br>"
                                                   + "Usar '2' para binarización<br>"
                                                   + "Usar 'r' para reestablecer</html>"));
        marco2.setSize(400, 200);
        marco2.setVisible(true);
        marco2.repaint();
        
        marco.addKeyListener(new KeyAdapter() {
            double[][] back = m;
            double n = 0;
            @Override
            public void keyPressed(KeyEvent k) {


            	

            	//Brillo
                if(k.getKeyChar() == 'b'){
                    double[][] mG = new double[ancho][alto];
                    int[][] mrgbG = new int[ancho][alto];
                	double[][] backG = mG;
                    
                    BufferedImage imgB = img;

                    JFrame marcoB = new JFrame("Brillo");
                    marcoB.getContentPane().add(new JLabel(new ImageIcon(imgB)));
                    marcoB.setSize(ancho, alto);
                    marcoB.setVisible(true);
                    marcoB.repaint();

                    marcoB.addKeyListener(new KeyAdapter() {
                    	double nB = 0;
                        @Override
                        public void keyPressed(KeyEvent l) {
                            if(l.getKeyChar() == '-'){
                                nB++;
                            }

                            if(l.getKeyChar() == '+'){
                                nB--;
                            }
                            if (nB > 0){
                                for (int i = 0; i < ancho; i++){
                                    for (int j = 0; j < alto; j++){
                                        double rgbG = Math.round((Math.pow(((mrgbG[i][j])/255.0), nB))*255.0);
                                        double brillop = (rgbG*65536)+(rgbG*256)+(rgbG);
                                        imgB.setRGB(i, j, (int)brillop);
                                    }
                                }
                            }
                            if (nB < 0){
                                for (int i = 0; i < ancho; i++){
                                    for (int j = 0; j < alto; j++){
                                        double rgbG = Math.round((Math.pow(((mrgbG[i][j])/255.0), 1/(Math.abs(nB))))*255.0);
                                        double brillop = (rgbG*65536)+(rgbG*256)+(rgbG);
                                        imgB.setRGB(i, j, (int)brillop);
                                    }
                                }
                            }
                            if (nB == 0){
                                for (int i = 0; i < ancho; i++){
                                    for (int j = 0; j < alto; j++){
                                        imgB.setRGB(i, j, (int)backG[i][j]);}
                                }
                            }
                            marcoB.repaint();
                            System.out.println("Factor de brillo: " + nB);
                        }
                    });
                }
                

            	
              //Negativo
                    if(k.getKeyChar() == 'n'){
                                    BufferedImage imgN = img;
                                    for (int i = 0; i < ancho; i++){
                                        for (int j = 0; j < alto; j++){
                                            double r = 255-mr[i][j];
                                            double g = 255-mg[i][j];
                                            double b = 255-mb[i][j];
                                            double neg = (r*65536)+(g*256)+(b);
                                            imgN.setRGB(i, j, (int)neg);
                                        }
                                    }
                                    printnegativo(ancho, alto, imgN, "Negativo");
                                    System.out.println("Imagen -> Negativo");
                                }
                    
                    //Binarizacion simple
                    if(k.getKeyChar() == '2'){
                        BufferedImage imgC = img;
                        
                        for (int i = 0; i < ancho; i++){
                            for (int j = 0; j < alto; j++){
                            	double rgb = (mr[i][j]+mg[i][j]+mb[i][j]);
                            	//System.out.println(rgb);
                            	if(rgb  >= 382){
                                    rgb = 765;
                                }
                            	if(rgb  < 382){
                                    rgb = 0;
                                }
                            		
                                double cla = (rgb*65536)+(rgb*256)+(rgb);
                                imgC.setRGB(i, j, (int)cla);
                            }
                        }
                        printnegativo(ancho, alto, imgC, "Negativo Binarizado simple");
                        System.out.println("Imagen -> Binarizado simple");
                    }
                    
                    
                   

//Escala de grises
                    if(k.getKeyChar() == 'g'){
                    
                        BufferedImage imgG = img;
                        double[][] mG = new double[ancho][alto];
                        int[][] mrgbG = new int[ancho][alto];
                        
                        for (int i = 0; i < ancho; i++){
                            for (int j = 0; j < alto; j++){
                                double rgb = (mr[i][j]+mg[i][j]+mb[i][j])/3;
                                double gris = (rgb*65536)+(rgb*256)+(rgb);
                                imgG.setRGB(i, j, (int)gris);
                            }
                        }
                        
                        for (int i = 0; i < ancho; i++){
                            for (int j = 0; j < alto; j++){
                                mG[i][j] = imgG.getRGB(i, j);
                                mrgbG[i][j] = ((int)m[i][j]) & 0x000000FF;
                            }
                        }
                        
                        JFrame marcoG = new JFrame("Escala de grises");
                        marcoG.getContentPane().add(new JLabel(new ImageIcon(imgG)));
                        marcoG.setSize(ancho, alto);
                        marcoG.setVisible(true);
                        marcoG.repaint();
                        
                        System.out.println("Imagen -> Escala de gris");
                        
                        marcoG.addKeyListener(new KeyAdapter() {
                            double[][] backG = mG;
                            double nG = 0;
                            @Override
                            public void keyPressed(KeyEvent y) {
                                if(y.getKeyChar() == 'n'){
                                    BufferedImage imgNG = img;
                                    for (int i = 0; i < ancho; i++){
                                        for (int j = 0; j < alto; j++){
                                            double rgb = 255-(mrgbG[i][j]);
                                            double gris = (rgb*65536)+(rgb*256)+(rgb);
                                            imgNG.setRGB(i, j, (int)gris);
                                        }
                                    }
                                    printnegativo(ancho, alto, imgNG, "Negativo de grises");
                                    System.out.println("Imagen -> Negativo");
                                }
                                
                                //Binarizacion simple
                                if(y.getKeyChar() == '2'){
                                    BufferedImage imgC = img;
                                    
                                    for (int i = 0; i < ancho; i++){
                                        for (int j = 0; j < alto; j++){
                                        	double rgb = (mr[i][j]+mg[i][j]+mb[i][j]);
                                        	//System.out.println(rgb);
                                        	if(rgb  >= 382){
                                                rgb = 765;
                                            }
                                        	if(rgb  < 382){
                                                rgb = 0;
                                            }
                                        		
                                            double cla = (rgb*65536)+(rgb*256)+(rgb);
                                            imgC.setRGB(i, j, (int)cla);
                                        }
                                    }
                                    printnegativo(ancho, alto, imgC, "Negativo Binarizado simple");
                                    System.out.println("Imagen -> Binarizado simple");
                                }

                                //Binarizacion compuesta
                                if(y.getKeyChar() == 't'){
                                    BufferedImage imgC = img;
                                    
                                    for (int i = 0; i < ancho; i++){
                                        for (int j = 0; j < alto; j++){
                                        	double rgb = (mr[i][j]+mg[i][j]+mb[i][j]);
                                        	//System.out.println(rgb);
                                        	if(rgb <= 50 && rgb >= 380){
                                                rgb = 765;
                                            }
                                        	if(rgb > 50 && rgb < 380 ){
                                                rgb = 0;
                                            }
                                        		
                                            double cla = (rgb*65536)+(rgb*256)+(rgb);
                                            imgC.setRGB(i, j, (int)cla);
                                        }
                                    }
                                    printnegativo(ancho, alto, imgC, "Negativo Binarizado simple");
                                    System.out.println("Imagen -> Binarizado simple");
                                }
                                
                                //Sumar imagenes
                                if(y.getKeyChar() == '+'){
                                    BufferedImage img1 = img;
                                    
                                    for (int i = 0; i < ancho; i++){
                                        for (int j = 0; j < alto; j++){
                                        	double rgb = (mr[i][j]+mg[i][j]+mb[i][j])/2;
                                            double cla = (rgb*65536)+(rgb*256)+(rgb);
                                            img1.setRGB(i, j, (int)cla);
                                        }
                                    }
                                    printnegativo(ancho, alto, img1, "Negativo Sumado");
                                    System.out.println("Imagen -> Sumado de imagenes");
                                }
                                
                                if(y.getKeyChar() == '-'){
                                    BufferedImage img1 = img;
                                    
                                    for (int i = 0; i < ancho; i++){
                                        for (int j = 0; j < alto; j++){
                                        	double rgb = mr[i][j]+mg[i][j]+mb[i][j];
                                            double cla = (rgb*65536)+(rgb*256)+(rgb);
                                            img1.setRGB(i, j, (int)cla);
                                        }
                                    }
                                    printnegativo(ancho, alto, img1, "Negativo Restado");
                                    System.out.println("Imagen -> Restado de imagenes");
                                }


                                
                                
                                
                                //Brillo grises
                                if(y.getKeyChar() == 'b'){
                    
                                    BufferedImage imgB = imgG;

                                    JFrame marcoB = new JFrame("Brillo");
                                    marcoB.getContentPane().add(new JLabel(new ImageIcon(imgB)));
                                    marcoB.setSize(ancho, alto);
                                    marcoB.setVisible(true);
                                    marcoB.repaint();

                                    marcoB.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyPressed(KeyEvent l) {
                                            if(l.getKeyChar() == '-'){
                                                nG++;
                                            }

                                            if(l.getKeyChar() == '+'){
                                                nG--;
                                            }
                                            if (nG > 0){
                                                for (int i = 0; i < ancho; i++){
                                                    for (int j = 0; j < alto; j++){
                                                        double rgbG = Math.round((Math.pow(((mrgbG[i][j])/255.0), nG))*255.0);
                                                        double brillop = (rgbG*65536)+(rgbG*256)+(rgbG);
                                                        imgB.setRGB(i, j, (int)brillop);
                                                    }
                                                }
                                            }
                                            if (nG < 0){
                                                for (int i = 0; i < ancho; i++){
                                                    for (int j = 0; j < alto; j++){
                                                        double rgbG = Math.round((Math.pow(((mrgbG[i][j])/255.0), 1/(Math.abs(nG))))*255.0);
                                                        double brillop = (rgbG*65536)+(rgbG*256)+(rgbG);
                                                        imgB.setRGB(i, j, (int)brillop);
                                                    }
                                                }
                                            }
                                            if (nG == 0){
                                                for (int i = 0; i < ancho; i++){
                                                    for (int j = 0; j < alto; j++){
                                                        imgB.setRGB(i, j, (int)backG[i][j]);}
                                                }
                                            }
                                            marcoB.repaint();
                                            System.out.println("Factor de brillo: " + nG);
                                        }
                                    });
                                }
                                
                            }
                        });
                    }
                    
                    if(k.getKeyChar() == 'b'){
                    
                        BufferedImage imgB = img;
                        
                        JFrame marcoB = new JFrame("Brillo");
                        marcoB.getContentPane().add(new JLabel(new ImageIcon(imgB)));
                        marcoB.setSize(ancho, alto);
                        marcoB.setVisible(true);
                        marcoB.repaint();
                        
                        marcoB.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyPressed(KeyEvent l) {
                                if(l.getKeyChar() == '-'){
                                    n++;
                                }
                                
                                if(l.getKeyChar() == '+'){
                                    n--;
                                }
                                if (n > 0){
                                    for (int i = 0; i < ancho; i++){
                                        for (int j = 0; j < alto; j++){
                                            double r = Math.round((Math.pow(((mr[i][j])/255.0), n))*255.0);
                                            double g = Math.round((Math.pow(((mg[i][j])/255.0), n))*255.0);
                                            double b = Math.round((Math.pow(((mb[i][j])/255.0), n))*255.0);
                                            double brillop = (r*65536)+(g*256)+(b);;
                                            imgB.setRGB(i, j, (int)brillop);
                                        }
                                    }
                                }
                                if (n < 0){
                                    for (int i = 0; i < ancho; i++){
                                        for (int j = 0; j < alto; j++){
                                            double r = Math.round((Math.pow(((mr[i][j])/255.0), 1/(Math.abs(n))))*255.0);
                                            double g = Math.round((Math.pow(((mg[i][j])/255.0), 1/(Math.abs(n))))*255.0);
                                            double b = Math.round((Math.pow(((mb[i][j])/255.0), 1/(Math.abs(n))))*255.0);
                                            double brillop = (r*65536)+(g*256)+(b);
                                            imgB.setRGB(i, j, (int)brillop);
                                        }
                                    }
                                }
                                if (n == 0){
                                    for (int i = 0; i < ancho; i++){
                                        for (int j = 0; j < alto; j++){
                                            imgB.setRGB(i, j, (int)back[i][j]);}
                                    }
                                }
                                marcoB.repaint();
                                System.out.println("Factor de brillo: " + n);
                            }
                        });
                    }
                       
                    if(k.getKeyChar() == 'r'){
                        for (int i = 0; i < ancho; i++){
                                for (int j = 0; j < alto; j++){
                                    img.setRGB(i, j, (int)back[i][j]);}
                        }
                        marco.repaint();
                        System.out.println("Imagen restaurada");
                    }
                 
            }
        
        });
        
        
    }
    
    private static void printnegativo(int ancho, int alto, BufferedImage imgNG, String name) {
        
        JFrame marcoNG = new JFrame(name);
        marcoNG.getContentPane().add(new JLabel(new ImageIcon(imgNG)));
        marcoNG.setSize(ancho, alto);
        marcoNG.setVisible(true);
        marcoNG.repaint();

    }
    
}