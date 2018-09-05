package fr.imtld.sdl;

import fr.imtld.sdl.support.IProcess;
import fr.imtld.sdl.support.Signal;

/**
 * Implantation du signal SDL SOver.
 */
public class SOver extends Signal {
	/**
	 * Créer une instance du signal SOver.
	 * 
	 * @param sender
	 *            PId de l'instance du process émetteur.
	 */
	public SOver(IProcess sender) {
		super(sender);
	}
}
