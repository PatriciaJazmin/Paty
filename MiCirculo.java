/*
Instituto tecnologico de León
Topicos Avanzados de Programación
Equipo:
-Carlos Leonardo Luna Castillo
-Patricia Jazmín Ramírez Fonseca
 */


import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Ellipse2D;
import java.awt.Stroke;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class MiCirculo extends FiguraBidimensional{
    
    	public MiCirculo () {
	}
	
	public MiCirculo (int x, int y, boolean estaRelleno, Paint pintar, Stroke trazo) {
		super (x, y, estaRelleno, pintar, trazo);
	}
	
	public MiCirculo (int x1, int y1, int x2, int y2, boolean estaRelleno, Paint pintar, Stroke trazo) {
		super (min (x1, x2), min (y1, y2), max (x1, x2), max (y1, y2), estaRelleno, pintar, trazo);
	}
	
	public void dibujar (Graphics2D g2d) {
		super.dibujar(g2d);
		Ellipse2D elipse = new Ellipse2D.Double (puntoInicial.x,
		puntoInicial.y, 
                puntoFinal.x -puntoInicial.x,
		puntoFinal.y - puntoInicial.y);
	
		if (estaRelleno ())
			g2d.fill (elipse);
		else
			g2d.draw (elipse);
	}
	
}
