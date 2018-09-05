package fr.imtld.sdl;

import fr.imtld.sdl.support.IProcess;
import fr.imtld.sdl.support.Signal;

/**
 * Implantation du signal SDL SKill.
 */
public class SKill extends Signal {
	/**
	 * Créer une instance du signal SKill.
	 * 
	 * @param sender
	 *            PId de l'instance du process émetteur.
	 */
	public SKill(IProcess sender) {
		super(sender);
	}
}
