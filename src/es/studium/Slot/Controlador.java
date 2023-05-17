package es.studium.Slot;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, MouseListener
{
	Modelo modelo;
	MenuPrincipal menuPrincipal;

	Tablero tablero;
	Ranking ranking;

	Controlador(Modelo m, MenuPrincipal mp)
	{
		this.modelo = m;
		this.menuPrincipal = mp;

		this.menuPrincipal.addWindowListener(this);
		this.menuPrincipal.addMouseListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e){}
	@Override
	public void windowClosing(WindowEvent e)
	{
		if(tablero.isActive())
		{
			tablero.setVisible(false);
		}
		else if(ranking.isActive())
		{
			ranking.setVisible(false);
		}
		else
		{
			System.exit(0);
		}
	}
	@Override
	public void windowClosed(WindowEvent e){}
	@Override
	public void windowIconified(WindowEvent e){}
	@Override
	public void windowDeiconified(WindowEvent e){}
	@Override
	public void windowActivated(WindowEvent e){}
	@Override
	public void windowDeactivated(WindowEvent e){}

	@Override
	public void mouseClicked(MouseEvent me)
	{
		int x = me.getX();
		int y = me.getY();

		if(x>20&&x<60&&y>50&&y<90)
		{
			// Primera opción: Tablero
			tablero = new Tablero();
			this.tablero.addWindowListener(this);
		}
		else if(x>80&&x<120&&y>100&&y<140)
		{
			// Segunda opción: Ayuda
			System.out.println("Ayuda");
		}
		else if(x>140&&x<180&&y>160&&y<200)
		{
			// Tercer opción: Ranking
			ranking = new Ranking();
			this.ranking.addWindowListener(this);
		}
		else if(x>200&&x<240&&y>210&&y<250)
		{
			// Cuarta opción: Salir
			System.exit(0);
		}
	}

	@Override
	public void mousePressed(MouseEvent e){}
	@Override
	public void mouseReleased(MouseEvent e){}
	@Override
	public void mouseEntered(MouseEvent e){}
	@Override
	public void mouseExited(MouseEvent e){}
}
