/*
Instituto tecnologico de León
Topicos Avanzados de Programación
Equipo:
-Carlos Leonardo Luna Castillo
-Patricia Jazmín Ramírez Fonseca
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDibujo extends JPanel {
        public static final byte MICIRCULO = 0;
	public static final byte MICUADRADO = 1;
	public static final byte MITRIANGULO = 2;
	public static final byte MILINEA = 3;

	private Figura[] figuras;
	private Figura figuraActual;
	private Stroke trazoActual;
	private short numeroDeFiguras;
	private byte tipoDeFigura;
	private Paint pintando;
	private boolean relleno = false;
	private JLabel condicionLabel;
        
        public PanelDibujo (JLabel condicion) {
		condicionLabel = condicion;
		figuras = new Figura[100];
		numeroDeFiguras = 0;
		tipoDeFigura =  MICIRCULO;
		pintando= Color.BLACK;
		setBackground (Color.WHITE);
		MouseHandler mh = new MouseHandler ();
		addMouseListener (mh);
		addMouseMotionListener (mh);
	}
        
	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent (g);
		Graphics2D g2d = (Graphics2D) g;

		if (figuraActual != null)
			figuraActual.dibujar(g2d);

		for (byte contador = 0; figuras[contador] != null && contador < figuras.length; ++contador)
			figuras[contador].dibujar(g2d);
	}
	
	public void setTipoFigura (byte newTipoFigura) {
		tipoDeFigura = newTipoFigura >= 0 && newTipoFigura < 4 ? newTipoFigura : 0;
	}
	
	public void setPintando (Paint newPintando) {
		pintando = newPintando;
	}
	
	public void setTrazoActual (Stroke newTrazo) {
		trazoActual = newTrazo;
	}
	
	public void setRellenable (boolean valor) {
		relleno= valor;
	}
	
	public void deshacer () {
		if (--numeroDeFiguras < 0)
			numeroDeFiguras = 0;
		
		figuras[numeroDeFiguras] = null;
		
		repaint ();
	}
	
	public void limpiar () {
		numeroDeFiguras = 0;
	        figuraActual = null;
		
		for (short contador = 0; figuras[contador] != null && contador < figuras.length; ++contador)
			figuras[contador] = null;
		
		repaint ();
	}
        
        private class MouseHandler extends MouseAdapter implements MouseMotionListener {

              
		public void mousePressed(MouseEvent me) {
			switch (tipoDeFigura) {
				case MICIRCULO:
					figuraActual = new MiCirculo (me.getX (), me.getY (), relleno, pintando, trazoActual);
					break;
					
				case MICUADRADO:
					figuraActual = new MiCuadrado (me.getX (), me.getY (), relleno, pintando, trazoActual);
					break;
					
				case MITRIANGULO:
					figuraActual = new MiTriangulo (me.getX(), me.getY(), relleno, pintando, trazoActual);
					break;
				
				case MILINEA:
					figuraActual = new MiLinea (me.getX(), me.getY(), pintando, trazoActual);
			}
		}
		
		public void mouseReleased (MouseEvent me) {
			refreshCurrentShape (me.getX (), me.getY ());
			figuras[numeroDeFiguras++] = figuraActual;
			figuraActual = null;
			repaint ();
		}
		
		public void mouseMoved (MouseEvent me) {
			refreshStateLabel (me.getX (), me.getY ());
		}
		
		public void mouseDragged (MouseEvent me) {
			refreshStateLabel (me.getX (), me.getY ());
			refreshCurrentShape (me.getX (), me.getY ());
			repaint ();
		}
		
		private void refreshStateLabel (int x, int y) {
			condicionLabel.setText (String.format ("(%d, %d)", x, y));
		}
		
		private void refreshCurrentShape (int x, int y) {
			figuraActual.setPuntoFinal(x, y);
		}
	}
	
}
