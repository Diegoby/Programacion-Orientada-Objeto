package t.ascensor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;
import java.util.Observable;

/**
 * Ascensor de un Edificio, cumpliendo el interfaz IAscensor.
 * @author POO
 *
 */
public class Ascensor implements Runnable, IAscensor {

	private int piso;
    private int pisoAnterior;
	private int limiteSuperior;
	private int limiteInferior;
	private PropertyChangeSupport support;

	/**
	 * Crea un Ascensor que opera entre los pisos "LimiteInferior" y "LimiteSuperior".
	 * @param ascensor Índice del Ascensor en el Edificio (entre 0 y NUM_ASCENSORES-1).
	 * @param limiteInferior Piso más bajo al que llega el Ascensor.
	 * @param limiteSuperior Piso más alto al que llega el Ascensor.
	 */
	public Ascensor(int ascensor, int limiteInferior, int limiteSuperior) {
	  this.limiteSuperior = limiteSuperior;
	  this.limiteInferior = limiteInferior;
	  piso=limiteInferior;
	  pisoAnterior=limiteInferior; // No se le ha pedido subir ni bajar
      support = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	/**
	 * Indica el piso en el que se encuentra el Ascensor.
	 * @return Número de piso en el que se encuentra el Ascensor.
	 */
	public int getPiso() { return piso; }
	
	/**
	 * Indica el último piso en el que estuvo el Ascensor; sirve para saber si se envía al Ascensor
	 * hacia arriba o hacia abajo.
	 * @return Último piso que estuvo el Ascensor.
	 */
	public int getPisoAnterior() { return pisoAnterior; }
	
	/**
	 * Límite superior de operación de este Ascensor; Último piso al que puede llegar.
	 * @return Límite superior de operación.
	 */
	public int getLimiteSuperior() { return limiteSuperior;}
	
	/**
	 * Límite inferior de operación de este Ascensor; Primer piso al que puede llegar.
	 * @return Límite inferior de operación.
	 */
	public int getLimiteInferior() { return limiteInferior;}	
	
	
	/**
	 * Orden de envío del Ascensor a un piso; se comprueba que el piso se encuentra en los márgenes
	 * en los que opera el Ascensor (límites superior e inferior); Se modifica el piso a medida que
	 * el Ascensor sube o baja, dejando un tiempo de 1 segundo para cambiar de un piso a otro.
	 * @param piso Piso al que se desea enviar el Ascensor.
	 * @return false si el piso al que se envía el Ascensor es el piso en el que ahora se encuentra,
	 *         o si está fuera de los límites superior e inferior de operación de este Ascensor.
	 */
	public boolean setPiso(int piso) {
	  if (piso>limiteSuperior||
		  piso<limiteInferior||
		  this.piso==piso)
		return false;
	  else {
		pisoAnterior = this.piso;
		int pisoSiguiente = piso;	
		if (pisoAnterior<pisoSiguiente)   	// El Ascensor sube
		 for (piso=pisoAnterior+1;piso<pisoSiguiente;piso++) {
		    support.firePropertyChange("piso", pisoAnterior, piso); // ******** Modelo Vista Controlador
		   this.piso = piso;
			 try {
					Thread.sleep(1000);
				 } catch (Exception e) {}
		 } else 							// El Ascensor baja
		  for (piso=pisoAnterior-1;piso>pisoSiguiente;piso--) {
		    support.firePropertyChange("piso", pisoAnterior, piso); // ******** Modelo Vista Controlador
			this.piso = piso;
			 try {
					Thread.sleep(1000);
				 } catch (Exception e) {}
		  }
		 }
		return true;
	  }		

	/**
	 * Bucle infinito que modifica, aleatoriamente, el piso al que se envía el Ascensor y espera un tiempo suficiente 
	 * hasta volver a mandarlo a otro piso.	
	 */
	public void run() {
	 Random r = new Random();
	 
	 do {
		 setPiso(r.nextInt(Edificio.NUM_MAX_PISOS));
		 try {
			Thread.sleep(r.nextInt(13000));
		 } catch (Exception e) {}
	 } while(true);
	}

}
