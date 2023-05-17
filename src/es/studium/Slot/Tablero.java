package es.studium.Slot;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class Tablero extends Frame
{
	private static final long serialVersionUID = 1L;
	
	Tablero()
	{
		setTitle("Jugando...");
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(280,280);
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		g.drawRect(20, 210, 230, 40);
		g.drawString("JUGAR", 110, 240);
	}
}