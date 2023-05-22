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
	
	int dinerito;
	int tiradas;
	
	int numero1, numero2, numero3;

	Controlador(Modelo m, MenuPrincipal mp)
	{
		this.modelo = m;
		this.menuPrincipal = mp;

		this.menuPrincipal.addWindowListener(this);
		this.menuPrincipal.addMouseListener(this);
		
		dinerito = 5;
		
		tiradas = 0;
	}

	@Override
	public void windowOpened(WindowEvent e){}
	@Override
	public void windowClosing(WindowEvent e)
	{
		if(tablero!=null&&tablero.isActive())
		{
			tablero.setVisible(false);
		}
		else if(ranking!=null&&ranking.isActive())
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

		if(menuPrincipal.isActive())
		{
			if(x>20&&x<60&&y>50&&y<90)
			{
				// Primera opción: Tablero
				tablero = new Tablero();
				dinerito = 5;
				tiradas = 0;
				this.tablero.addWindowListener(this);
				this.tablero.addMouseListener(this);
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
		else if(tablero.isActive())
		{
			// Botón JUGAR de Tablero
			if(x>20&&x<250&&y>210&&y<250)
			{
				dinerito--;
				tiradas++;
				numero1 = modelo.aleatorio();
				numero2 = modelo.aleatorio();
				numero3 = modelo.aleatorio();
				tablero.establecerPrimera(numero1);
				tablero.establecerSegunda(numero2);
				tablero.establecerTercera(numero3);
				System.out.println(numero1+" "+numero2+" "+numero3);
				// Comprobar SI premio
				if(numero1==numero2&&numero2==numero3&&numero1==14)
				{
					dinerito = dinerito + 5;
				}
				else if(numero1==numero2&&numero2==numero3&&numero1>=10&&numero1<=13)
				{
					dinerito = dinerito + 2;
				}
				else if(numero1==numero2&&numero2==numero3)
				{
					dinerito ++;
				}
				else if(numero1==numero2)
				{
					dinerito++;
				}
				else if(numero2==numero3)
				{
					dinerito++;
				}
				else if(numero1==numero3)
				{
					dinerito++;
				}
				if(dinerito == 0)
				{
					System.out.println("Se acabó");
					System.out.println("Has realizado " + tiradas + " tiradas");
					this.tablero.removeMouseListener(this);
				}
				else
				{
					System.out.println("Tienes "+ dinerito + "€");
				}
			}
			// Botón Avance Primero
			else if(x>20&&x<90&&y>140&&y<160)
			{
				numero1++;
				dinerito--;
				if(numero1>14)
				{
					numero1 = 1;
				}
				tablero.establecerPrimera(numero1);
			}
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
