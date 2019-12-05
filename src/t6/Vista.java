package t6;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Vista extends Canvas implements PropertyChangeListener{

    private Graphics2D g2d;
    private Tablero tablero;

    public void paint(Graphics g){
        g2d = (Graphics2D) g;
        for (int x=0;x<tablero.size();x++)
            for (int y=0;y<tablero.size();y++) {
                switch (tablero.getCasilla(x,y)) {
                    case Tablero.VACIO: g2d.setColor(java.awt.Color.WHITE); break;
                    case Tablero.VIVO: g2d.setColor(java.awt.Color.GREEN); break;
                    case Tablero.MUERTO: g2d.setColor(java.awt.Color.RED); break;
                }
                g2d.fillRect(10+x*10, 10+y*10, 10, 10);
            }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        tablero = (Tablero) evt.getNewValue();
        repaint();
    }
}
