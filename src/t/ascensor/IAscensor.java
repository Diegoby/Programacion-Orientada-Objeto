package t.ascensor;
/**
 * Ascensor de un Edificio, que opera entre un piso mínimo y un piso máximo, concurrentemente con
 * los demás ascensores del edificio; Su operativa será transitar, sin fin, hacia pisos elegidos 
 * aleatoriamente.
 * @author jbobi
 *
 */
public interface IAscensor {

	/**
	 * Indica el piso en el que se encuentra el Ascensor.
	 * @return Número de piso en el que se encuentra el Ascensor.
	 */
	int getPiso();
	
	/**
	 * Indica el último piso en el que estuvo el Ascensor; sirve para saber si se envía al Ascensor
	 * hacia arriba o hacia abajo.
	 * @return Último piso que estuvo el Ascensor.
	 */
	int getPisoAnterior();
	
	/**
	 * Límite superior de operación de este Ascensor; Último piso al que puede llegar.
	 * @return Límite superior de operación.
	 */
	int getLimiteSuperior();
	
	/**
	 * Límite inferior de operación de este Ascensor; Primer piso al que puede llegar.
	 * @return Límite inferior de operación.
	 */
	int getLimiteInferior();	
	
	
	/**
	 * Orden de envío del Ascensor a un piso; se comprueba que el piso se encuentra en los márgenes
	 * en los que opera el Ascensor (límites superior e inferior); Se modifica el piso a medida que
	 * el Ascensor sube o baja, dejando un tiempo de 1 segundo para cambiar de un piso a otro.
	 * @param piso Piso al que se desea enviar el Ascensor.
	 * @return false si el piso al que se envía el Ascensor es el piso en el que ahora se encuentra,
	 *         o si está fuera de los límites superior e inferior de operación de este Ascensor.
	 */
	boolean setPiso(int piso);
	
	/**
	 * Bucle infinito que modifica, aleatoriamente, el piso al que se envía el Ascensor y espera un tiempo suficiente 
	 * hasta volver a mandarlo a otro piso.	
	 */
	void run();
	
}
