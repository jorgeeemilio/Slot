package es.studium.Slot;

import java.awt.Frame;

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
}