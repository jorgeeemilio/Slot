package es.studium.Slot;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class MenuPrincipal extends Frame
{
	private static final long serialVersionUID = 1L;
	
	MenuPrincipal()
	{
		setSize(400,200);
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		Color color = new Color(181,230,29);
		g.setColor(color);
		// Se dibuja un rectángulo de 25 pixeles de ancho x alto a partir de la posición 50,50
		g.drawRect(10, 50, 40, 40);
	}
}
