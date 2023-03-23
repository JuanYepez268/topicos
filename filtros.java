import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;

public class filtros {
    public static void main(String[] args) throws IOException {
        try {
            //BufferedImage img = ImageIO.read(new File("C:\\Users\\juan2\\Pictures\\E1.jpg"));
            BufferedImage img = ImageIO.read(new File("C:\\Users\\juan2\\Pictures\\E1.jpg"));
            BufferedImage img2 = ImageIO.read(new File("C:\\Users\\juan2\\Pictures\\E2.jpg"));
            System.out.println("Lectura realizada");
            int ancho = img.getWidth();
            int alto = img.getHeight();
            double[][] m = new double[ancho][alto];
            int[][] mr = new int[ancho][alto];
            int[][] mg = new int[ancho][alto];
            int[][] mb = new int[ancho][alto];
            int ancho2 = img2.getWidth();
            int alto2 = img2.getHeight();
            double[][] m2 = new double[ancho2][alto2];
            int[][] mr2 = new int[ancho2][alto2];
            int[][] mg2 = new int[ancho2][alto2];
            int[][] mb2 = new int[ancho2][alto2];
            for (int i = 0; i < ancho; i++){
                for (int j = 0; j < alto; j++){
                    m[i][j] = img.getRGB(i, j); // RGB = (R*65536)+(G*256)+B , (when R is RED, G is GREEN and B is BLUE)
                    mr[i][j] = ((int)m[i][j]>> 16) & 0x000000FF;
                    mg[i][j] = ((int)m[i][j]>> 8) & 0x000000FF;
                    mb[i][j] = ((int)m[i][j]) & 0x000000FF;

                    m2[i][j] = img2.getRGB(i, j); // RGB = (R*65536)+(G*256)+B , (when R is RED, G is GREEN and B is BLUE)
                    mr2[i][j] = ((int)m2[i][j]>> 16) & 0x000000FF;
                    mg2[i][j] = ((int)m2[i][j]>> 8) & 0x000000FF;
                    mb2[i][j] = ((int)m2[i][j]) & 0x000000FF;
                }
            }
                        
            System.out.println("Matriz RGB creada");
            System.out.println("Matriz de rojos creada");
            System.out.println("Matriz de verdes creada");
            System.out.println("Matriz de azules creada");
            procesar(ancho, alto, img, m, mr, mg, mb, img2, m2, mr2, mg2, mb2);
        }
        catch (IOException a) {
            System.out.println(a);
        }
    }
    
    private static void procesar(int ancho, int alto, BufferedImage img, double[][] m, int[][] mr, int[][] mg, int[][] mb, BufferedImage img2, double[][] m2, int[][] mr2, int[][] mg2, int[][] mb2) {
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
            @Override
            public void keyPressed(KeyEvent k) {
                
                if(k.getKeyChar() == 'n'){
                    negativo(ancho, alto, img, m, mr, mg, mb, img2, m2, mr2, mg2, mb2);
                }
                if(k.getKeyChar() == 's'){
                    sumar(ancho, alto, img, m, mr, mg, mb, img2, m2, mr2, mg2, mb2);
                }
                if(k.getKeyChar() == 'r'){
                    restar(ancho, alto, img, m, mr, mg, mb, img2, m2, mr2, mg2, mb2);
                }
                if(k.getKeyChar() == '2'){
                    binarizacion(ancho, alto, img, m, mr, mg, mb, img2, m2, mr2, mg2, mb2);
                }
                if(k.getKeyChar() == '3'){
                    binarizacionComp(ancho, alto, img, m, mr, mg, mb, img2, m2, mr2, mg2, mb2);
                }
                if(k.getKeyChar() == '4'){
                    segmentacion(ancho, alto, img, m, mr, mg, mb, img2, m2, mr2, mg2, mb2);
                }
                if(k.getKeyChar() == 'c'){
                    contraste(ancho, alto, img, m, mr, mg, mb, img2, m2, mr2, mg2, mb2);
                }
                if(k.getKeyChar() == 'g'){
                    grises(ancho, alto, img, m, mr, mg, mb, img2, m2, mr2, mg2, mb2);
                                
                    //     if(y.getKeyChar() == 'b'){
                    //         BufferedImage imgB = imgN;
                    //         JFrame marcoB = new JFrame("Brillo");
                    //         marcoB.getContentPane().add(new JLabel(new ImageIcon(imgB)));
                    //         marcoB.setSize(ancho, alto);
                    //         marcoB.setVisible(true);
                    //         marcoB.repaint();

                    //         marcoB.addKeyListener(new KeyAdapter() {
                    //         @Override
                    //         public void keyPressed(KeyEvent l) {
                    //             if(l.getKeyChar() == '-'){
                    //                 nG++;
                    //             }
                    //             if(l.getKeyChar() == '+'){
                    //                 nG--;
                    //             }
                    //             if (nG > 0){
                    //                 for (int i = 0; i < ancho; i++){
                    //                     for (int j = 0; j < alto; j++){
                    //                         double rgbG = Math.round((Math.pow(((mrgbG[i][j])/255.0), nG))*255.0);
                    //                         double brillop = (rgbG*65536)+(rgbG*256)+(rgbG);
                    //                         imgB.setRGB(i, j, (int)brillop);
                    //                     }
                    //                 }
                    //             }
                    //             if (nG < 0){
                    //                 for (int i = 0; i < ancho; i++){
                    //                     for (int j = 0; j < alto; j++){
                    //                         double rgbG = Math.round((Math.pow(((mrgbG[i][j])/255.0), 1/(Math.abs(nG))))*255.0);
                    //                         double brillop = (rgbG*65536)+(rgbG*256)+(rgbG);
                    //                         imgB.setRGB(i, j, (int)brillop);
                    //                     }
                    //                 }
                    //             }
                    //             if (nG == 0){
                    //                 for (int i = 0; i < ancho; i++){
                    //                     for (int j = 0; j < alto; j++){
                    //                         imgB.setRGB(i, j, (int)backG[i][j]);}
                    //                     }
                    //                 }
                    //                 marcoB.repaint();
                    //                 System.out.println("Factor de brillo: " + nG);
                    //             }
                    //         });
                    //     }
                    // }
                // });
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
  //


















  //

    private static void contraste(int ancho, int alto, BufferedImage img, double[][] m, int[][] mr, int[][] mg, int[][] mb, BufferedImage img2, double[][] m2, int[][] mr2, int[][] mg2, int[][] mb2){
        double[][] back = m;
        
        BufferedImage imgB = img;
        JFrame marcoB = new JFrame("Brillo");
        marcoB.getContentPane().add(new JLabel(new ImageIcon(imgB)));
        marcoB.setSize(ancho, alto);
        marcoB.setVisible(true);
        marcoB.repaint();
        marcoB.addKeyListener(new KeyAdapter() {
            double n = 0;
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
                        // m[i][j] = imgB.getRGB(i, j);
                        // mr[i][j] = ((int)m[i][j]>> 16) & 0x000000FF;
                        // mg[i][j] = ((int)m[i][j]>> 8) & 0x000000FF;
                        // mb[i][j] = ((int)m[i][j]) & 0x000000FF;
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
                        // m[i][j] = imgB.getRGB(i, j);
                        // mr[i][j] = ((int)m[i][j]>> 16) & 0x000000FF;
                        // mg[i][j] = ((int)m[i][j]>> 8) & 0x000000FF;
                        // mb[i][j] = ((int)m[i][j]) & 0x000000FF;
                    }
                }
            }
            if (n == 0){
                for (int i = 0; i < ancho; i++){
                    for (int j = 0; j < alto; j++){
                        imgB.setRGB(i, j, (int)back[i][j]);
                        // m[i][j] = imgB.getRGB(i, j);
                        // mr[i][j] = ((int)m[i][j]>> 16) & 0x000000FF;
                        // mg[i][j] = ((int)m[i][j]>> 8) & 0x000000FF;
                        // mb[i][j] = ((int)m[i][j]) & 0x000000FF;
                    }
                }
            }
            //marcoB.repaint();
            printnegativo(ancho, alto, imgB, m, mr, mg, mb, "brillo", img2, m2, mr2, mg2, mb2);
            System.out.println("Factor de brillo: " + n);
            }
        });
    }

    private static void grises(int ancho, int alto, BufferedImage img, double[][] m, int[][] mr, int[][] mg, int[][] mb, BufferedImage img2, double[][] m2, int[][] mr2, int[][] mg2, int[][] mb2){
        BufferedImage imgN = img;
        double[][] mG = new double[ancho][alto];
        int[][] mrgbG = new int[ancho][alto];
                        
        for (int i = 0; i < ancho; i++){
            for (int j = 0; j < alto; j++){
                double rgb = (mr[i][j]+mg[i][j]+mb[i][j])/3;
                double gris = (rgb*65536)+(rgb*256)+(rgb);
                imgN.setRGB(i, j, (int)gris);
                m[i][j] = imgN.getRGB(i, j);
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
        printnegativo(ancho, alto, imgN, mG, mrgbG, mg, mb, "Grises", img2, m2, mr2, mg2, mb2);
        System.out.println("Imagen -> Grises");
    }

    private static void binarizacion(int ancho, int alto, BufferedImage img, double[][] m, int[][] mr, int[][] mg, int[][] mb, BufferedImage img2, double[][] m2, int[][] mr2, int[][] mg2, int[][] mb2){
        BufferedImage imgN = img;    
        for (int i = 0; i < ancho; i++){
            for (int j = 0; j < alto; j++){
                double r = mr[i][j];
                double g = mg[i][j];
                double b = mb[i][j];
                double rgb = (r+g+b)/3;
                if(rgb  >= 127){
                    rgb = 255;
                }
                if(rgb  < 127){
                    rgb = 0;
                }
                double cla = (rgb*65536)+(rgb*256)+(rgb);
                imgN.setRGB(i, j, (int)cla);
                m[i][j] = imgN.getRGB(i, j);
                mr[i][j] = ((int)m[i][j]>> 16) & 0x000000FF;
                mg[i][j] = ((int)m[i][j]>> 8) & 0x000000FF;
                mb[i][j] = ((int)m[i][j]) & 0x000000FF;
                }
            }
        printnegativo(ancho, alto, imgN, m, mr, mg, mb, "binarizacion", img2, m2, mr2, mg2, mb2);
        System.out.println("Imagen -> Escala de gris");
    }

    private static void binarizacionComp(int ancho, int alto, BufferedImage img, double[][] m, int[][] mr, int[][] mg, int[][] mb, BufferedImage img2, double[][] m2, int[][] mr2, int[][] mg2, int[][] mb2){
        BufferedImage imgN = img;    
        for (int i = 0; i < ancho; i++){
            for (int j = 0; j < alto; j++){
                double r = mr[i][j];
                double g = mg[i][j];
                double b = mb[i][j];
                double rgb = (r+g+b)/3;
                if(rgb  >= 127 || rgb  <= 40){
                    rgb = 255;
                }
                if(rgb  < 127 && rgb  >= 40){
                    rgb = 0;
                }
                double cla = (rgb*65536)+(rgb*256)+(rgb);
                imgN.setRGB(i, j, (int)cla);
                m[i][j] = imgN.getRGB(i, j);
                mr[i][j] = ((int)m[i][j]>> 16) & 0x000000FF;
                mg[i][j] = ((int)m[i][j]>> 8) & 0x000000FF;
                mb[i][j] = ((int)m[i][j]) & 0x000000FF;
                }
            }
        printnegativo(ancho, alto, imgN, m, mr, mg, mb, "Bin", img2, m2, mr2, mg2, mb2);
        System.out.println("Imagen -> Escala de gris");
    }

    private static void segmentacion(int ancho, int alto, BufferedImage img, double[][] m, int[][] mr, int[][] mg, int[][] mb, BufferedImage img2, double[][] m2, int[][] mr2, int[][] mg2, int[][] mb2){       
            BufferedImage imgN = img;    
        for (int i = 0; i < ancho; i++){
            for (int j = 0; j < alto; j++){
                double r = mr[i][j];
                double g = mg[i][j];
                double b = mb[i][j];
                double rgb = (r+g+b)/3;
                double rgb2 = 0;
                if(rgb  >= 180 || rgb  <= 20){
                    rgb2 = 255;
                }
                if(rgb  < 180 && rgb  > 20){
                    rgb2 = Math.round(((255.0*((rgb-20.0)/(180.0-20.0)))));
                    System.out.println(rgb);
                }
                double cla = (rgb2*65536)+(rgb2*256)+(rgb2);
                imgN.setRGB(i, j, (int)cla);
                m[i][j] = imgN.getRGB(i, j);
                mr[i][j] = ((int)m[i][j]>> 16) & 0x000000FF;
                mg[i][j] = ((int)m[i][j]>> 8) & 0x000000FF;
                mb[i][j] = ((int)m[i][j]) & 0x000000FF;
                }
            }
        printnegativo(ancho, alto, imgN, m, mr, mg, mb, "Segmentacion", img2, m2, mr2, mg2, mb2);
        System.out.println("Imagen -> Escala de gris");
        }

    private static void sumar(int ancho, int alto, BufferedImage img, double[][] m, int[][] mr, int[][] mg, int[][] mb, BufferedImage img2, double[][] m2, int[][] mr2, int[][] mg2, int[][] mb2){       
        BufferedImage imgN = img;
        for (int i = 0; i < ancho; i++){
            for (int j = 0; j < alto; j++){
                double r = (mr[i][j]+mr2[i][j])/2;
                double g = (mg[i][j]+mg2[i][j])/2;
                double b = (mb[i][j]+mb2[i][j])/2;
                double neg = (r*65536)+(g*256)+(b);
                imgN.setRGB(i, j, (int)neg);
                m[i][j] = imgN.getRGB(i, j);
                mr[i][j] = ((int)m[i][j]>> 16) & 0x000000FF;
                mg[i][j] = ((int)m[i][j]>> 8) & 0x000000FF;
                mb[i][j] = ((int)m[i][j]) & 0x000000FF;
                }
            }
        printnegativo(ancho, alto, imgN, m, mr, mg, mb, "suma", img2, m2, mr2, mg2, mb2);
        System.out.println("Imagen -> Escala de gris");
        }

        private static void restar(int ancho, int alto, BufferedImage img, double[][] m, int[][] mr, int[][] mg, int[][] mb, BufferedImage img2, double[][] m2, int[][] mr2, int[][] mg2, int[][] mb2){       
            BufferedImage imgN = img;
            for (int i = 0; i < ancho; i++){
                for (int j = 0; j < alto; j++){
                    // double r = (255/2)+(mr[i][j]-mr2[i][j])/2;
                    // double g = (255/2)+(mg[i][j]-mg2[i][j])/2;
                    // double b = (255/2)+(mb[i][j]-mb2[i][j])/2;
                    double r = Math.abs(mr[i][j]-mr2[i][j]);
                    double g = Math.abs(mg[i][j]-mg2[i][j]);
                    double b = Math.abs(mb[i][j]-mb2[i][j]);
                    double neg = (r*65536)+(g*256)+(b);
                    imgN.setRGB(i, j, (int)neg);
                    m[i][j] = imgN.getRGB(i, j);
                    mr[i][j] = ((int)m[i][j]>> 16) & 0x000000FF;
                    mg[i][j] = ((int)m[i][j]>> 8) & 0x000000FF;
                    mb[i][j] = ((int)m[i][j]) & 0x000000FF;
                    }
                }
            printnegativo(ancho, alto, imgN, m, mr, mg, mb, "Resta", img2, m2, mr2, mg2, mb2);
        System.out.println("Imagen -> Escala de gris");
            }

    private static void negativo(int ancho, int alto, BufferedImage img, double[][] m, int[][] mr, int[][] mg, int[][] mb, BufferedImage img2, double[][] m2, int[][] mr2, int[][] mg2, int[][] mb2){       
        BufferedImage imgN = img;
        for (int i = 0; i < ancho; i++){
            for (int j = 0; j < alto; j++){
                double r = 255-mr[i][j];
                double g = 255-mg[i][j];
                double b = 255-mb[i][j];
                double neg = (r*65536)+(g*256)+(b);
                imgN.setRGB(i, j, (int)neg);
                m[i][j] = imgN.getRGB(i, j);
                mr[i][j] = ((int)m[i][j]>> 16) & 0x000000FF;
                mg[i][j] = ((int)m[i][j]>> 8) & 0x000000FF;
                mb[i][j] = ((int)m[i][j]) & 0x000000FF;
                }
            }
        printnegativo(ancho, alto, imgN, m, mr, mg, mb, "Negativo", img2, m2, mr2, mg2, mb2);
        System.out.println("Imagen -> Negativo");
    }

    private static void printnegativo(int ancho, int alto, BufferedImage img, double[][] m, int[][] mr, int[][] mg, int[][] mb, String name, BufferedImage img2, double[][] m2, int[][] mr2, int[][] mg2, int[][] mb2) {       
        JFrame marcoN = new JFrame(name);
        marcoN.getContentPane().add(new JLabel(new ImageIcon(img)));
        marcoN.setSize(ancho, alto);
        marcoN.setVisible(true);
        marcoN.repaint();
        marcoN.addKeyListener(new KeyAdapter() {
            double n = 0;
            @Override
            public void keyPressed(KeyEvent y) {
                double[][] back = m;
                if(y.getKeyChar() == 'n'){
                    negativo(ancho, alto, img, m, mr, mg, mb, img2, m2, mr2, mg2, mb2);
                }
                if(y.getKeyChar() == '2'){
                    binarizacion(ancho, alto, img, m, mr, mg, mb, img2, m2, mr2, mg2, mb2);
                }
                if(y.getKeyChar() == '3'){
                    binarizacionComp(ancho, alto, img, m, mr, mg, mb, img2, m2, mr2, mg2, mb2);
                }
                if(y.getKeyChar() == '4'){
                    segmentacion(ancho, alto, img, m, mr, mg, mb, img2, m2, mr2, mg2, mb2);
                }
                if(y.getKeyChar() == 's'){
                    sumar(ancho, alto, img, m, mr, mg, mb, img2, m2, mr2, mg2, mb2);
                }
                if(y.getKeyChar() == 'r'){
                    restar(ancho, alto, img, m, mr, mg, mb, img2, m2, mr2, mg2, mb2);
                }
                if(y.getKeyChar() == 'g'){
                    grises(ancho, alto, img, m, mr, mg, mb, img2, m2, mr2, mg2, mb2);
                }
                if(y.getKeyChar() == '-'){
                    n++;
                }
                                    
                if(y.getKeyChar() == '+'){
                    n--;
                }
                if (n > 0){
                    for (int i = 0; i < ancho; i++){
                        for (int j = 0; j < alto; j++){
                            double r = Math.round((Math.pow(((mr[i][j])/255.0), n))*255.0);
                            double g = Math.round((Math.pow(((mg[i][j])/255.0), n))*255.0);
                            double b = Math.round((Math.pow(((mb[i][j])/255.0), n))*255.0);
                            double brillop = (r*65536)+(g*256)+(b);;
                            img.setRGB(i, j, (int)brillop);
                            // m[i][j] = imgB.getRGB(i, j);
                            // mr[i][j] = ((int)m[i][j]>> 16) & 0x000000FF;
                            // mg[i][j] = ((int)m[i][j]>> 8) & 0x000000FF;
                            // mb[i][j] = ((int)m[i][j]) & 0x000000FF;
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
                            img.setRGB(i, j, (int)brillop);
                            // m[i][j] = imgB.getRGB(i, j);
                            // mr[i][j] = ((int)m[i][j]>> 16) & 0x000000FF;
                            // mg[i][j] = ((int)m[i][j]>> 8) & 0x000000FF;
                            // mb[i][j] = ((int)m[i][j]) & 0x000000FF;
                        }
                    }
                }
                if (n == 0){
                    for (int i = 0; i < ancho; i++){
                        for (int j = 0; j < alto; j++){
                            img.setRGB(i, j, (int)back[i][j]);
                            // m[i][j] = imgB.getRGB(i, j);
                            // mr[i][j] = ((int)m[i][j]>> 16) & 0x000000FF;
                            // mg[i][j] = ((int)m[i][j]>> 8) & 0x000000FF;
                            // mb[i][j] = ((int)m[i][j]) & 0x000000FF;
                        }
                    }
                }
                marcoN.repaint();
                System.out.println("Factor de brillo: " + n);
            }
        });
    }   

}
