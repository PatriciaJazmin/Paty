/*
Instituto tecnologico de León
Topicos Avanzados de Programación
Equipo:
-Carlos Leonardo Luna Castillo
-Patricia Jazmín Ramírez Fonseca
 */


import java.awt.Paint;
import java.awt.Stroke;
import java.io.ObjectOutput;
import java.io.ObjectInput;
import java.io.IOException;

public class FiguraBidimensional extends Figura{
    private boolean estaRelleno;
	
	public FiguraBidimensional () {
	}
	
	public  FiguraBidimensional (int x1, int y1, int x2, int y2, boolean estaRelleno, Paint pintar, Stroke trazo) {
		super (x1, y1, x2, y2, pintar, trazo);
		setRellenable (estaRelleno);
	}
	
	public FiguraBidimensional (int x, int y, boolean estaRelleno, Paint pintar, Stroke trazo) {
		super (x, y, 0, 0, pintar, trazo);
		setRellenable (estaRelleno);
	}
	
	public final void setRellenable (boolean valor) {
		estaRelleno = valor;
	}
	
	public final boolean estaRelleno () {
		return estaRelleno;
	}
	
	@Override
	public void writeExternal (final ObjectOutput ou) throws IOException {
		super.writeExternal (ou);
		
		ou.writeBoolean (estaRelleno ());
	}
	
	@Override
	public void readExternal (final ObjectInput oi) throws IOException, ClassNotFoundException {
		super.readExternal (oi);
		
		setRellenable (oi.readBoolean ());
	}
    
}
