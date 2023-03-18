import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;

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
        //Ventana principal
        JFrame marco = new JFrame("Editor de imágenes");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.getContentPane().add(new JLabel(new ImageIcon(img)));
        marco.setSize(ancho, alto);
        marco.setVisible(true);
        marco.repaint();
        
        //Ventana del mensaje
        JFrame marco2 = new JFrame("Funciones");
        marco2.getContentPane().add(new JLabel("<html>Usar 'g' para escala de grises<br>"
                                                   + "Usar 'n' para negativo<br>"
                                                   + "Usar 'r' para reestablecer</html>"));
        marco2.setSize(400, 200);
        marco2.setVisible(true);
        marco2.repaint();
        

        marco.addKeyListener(new KeyAdapter() {
            double[][] back = m;
            double n = 0;
            @Override
            public void keyPressed(KeyEvent k) {
                
                if(k.getKeyChar() == 'n'){
                    negativo(ancho, alto, img, mr, mg, mb);
                }

                 if(k.getKeyChar() == 'n'){
                    negativo(ancho, alto, img, mr, mg, mb);
                }

                


                if(k.getKeyChar() == 'g'){
                    BufferedImage imgN = img;
                    double[][] mG = new double[ancho][alto];
                    int[][] mrgbG = new int[ancho][alto];
                        
                    for (int i = 0; i < ancho; i++){
                        for (int j = 0; j < alto; j++){
                            double rgb = (mr[i][j]+mg[i][j]+mb[i][j])/3;
                            double gris = (rgb*65536)+(rgb*256)+(rgb);
                            imgN.setRGB(i, j, (int)gris);
                            m[i][j] = imgN.getRGB(i, j); // RGB = (R*65536)+(G*256)+B , (when R is RED, G is GREEN and B is BLUE)
                            mr[i][j] = ((int)m[i][j]>> 16) & 0x000000FF;
                            mg[i][j] = ((int)m[i][j]>> 8) & 0x000000FF;
                            mb[i][j] = ((int)m[i][j]) & 0x000000FF;
                        }
                    }
                        
                    for (int i = 0; i < ancho; i++){
                        for (int j = 0; j < alto; j++){
                            mG[i][j] = imgN.getRGB(i, j);
                            mrgbG[i][j] = ((int)m[i][j]) & 0x000000FF;
                        }
                    }
                        
                    JFrame marcoG = new JFrame("Escala de grises");
                    marcoG.getContentPane().add(new JLabel(new ImageIcon(imgN)));
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
                            negativo(ancho, alto, img, mr, mg, mb);
                        }
                                
                        if(y.getKeyChar() == 'b'){
                            BufferedImage imgB = imgN;
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
  
    
/*
    private static void binarizacion(int ancho, int alto, BufferedImage img, int[][] mr, int[][] mg, int[][] mb){
        BufferedImage imgC = img;    
        for (int i = 0; i < ancho; i++){
            for (int j = 0; j < alto; j++){
                double rgb = (mr[i][j]+mg[i][j]+mb[i][j])/3;
                if(rgb  >= 127){
                    rgb = 255;
                }
                if(rgb  < 127){
                    rgb = 0;
                }
                double cla = (rgb*65536)+(rgb*256)+(rgb);
                imgC.setRGB(i, j, (int)cla);
                }
            }
        printnegativo(ancho, alto, imgC, "Negativo Binarizado simple");
        System.out.println("Imagen -> Binarizado simple");
    }









    
    */

//
//
//
//
// apartir de aqui estan los filtros separados
//
//
//
//









    private static void negativo(int ancho, int alto, BufferedImage img, int[][] mr, int[][] mg, int[][] mb){       
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


    private static void printnegativo(int ancho, int alto, BufferedImage imgNG, String name) {       
        JFrame marcoNG = new JFrame(name);
        marcoNG.getContentPane().add(new JLabel(new ImageIcon(imgNG)));
        marcoNG.setSize(ancho, alto);
        marcoNG.setVisible(true);
        marcoNG.repaint();
    }   
}