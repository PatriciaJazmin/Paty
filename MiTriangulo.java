/*
Instituto tecnologico de León
Topicos Avanzados de Programación
Equipo:
-Carlos Leonardo Luna Castillo
-Patricia Jazmín Ramírez Fonseca
 */


import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Stroke;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class MiTriangulo extends FiguraBidimensional {
    
    public MiTriangulo () {
	}

	public MiTriangulo (int x, int y, boolean estaRelleno, Paint pintar, Stroke trazo) {
		super (x, y, estaRelleno, pintar, trazo);
	}
	
	public MiTriangulo (int x1, int y1, int x2, int y2, boolean estaRelleno, Paint pintar, Stroke trazo) {
		super (min (x1, x2), min (y1, y2), max (x1, x2), max (y1, y2), estaRelleno, pintar, trazo);
	}
	
	public void dibujar (Graphics2D g2d) {
		super.dibujar (g2d);
		int[] puntosX = {(puntoInicial.x + puntoFinal.x) / 2, puntoFinal.x, puntoInicial.x};
		int[] puntosY = {puntoInicial.y, puntoFinal.y, puntoFinal.y};
		Polygon poligono = new Polygon (puntosX, puntosY, 3);
		
		if (estaRelleno ())
			g2d.fill (poligono);
		else
			g2d.draw (poligono);
	}
}
