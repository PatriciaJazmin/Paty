/*
Instituto tecnologico de León
Topicos Avanzados de Programación
Equipo:
-Carlos Leonardo Luna Castillo
-Patricia Jazmín Ramírez Fonseca
 */

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Line2D;
import java.awt.Stroke;

public class MiLinea extends Figura{
    public MiLinea () {
	}

	public MiLinea (int x, int y, Paint pintar, Stroke trazo) {
		super (x, y, 0, 0, pintar, trazo);
	}
	
	public MiLinea (int x1, int y1, int x2, int y2, Paint pintar, Stroke trazo) {
		super (x1, y1, x2, y2, pintar, trazo);
	}
	
	public void dibujar (Graphics2D g2d) {
		super.dibujar(g2d);
		g2d.draw (new Line2D.Double (puntoInicial.x, puntoInicial.y, puntoFinal.x, puntoFinal.y));
	}
}
