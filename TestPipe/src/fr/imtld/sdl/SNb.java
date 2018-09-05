package fr.imtld.sdl;

import fr.imtld.sdl.support.IProcess;
import fr.imtld.sdl.support.Signal;

/**
 * Implantation du signal SDL SNb.
 */
public class SNb extends Signal {
	/** Nombre véhiculé par ce signal */
	private int nb;

	/**
	 * Créer une instance du signal SNb.
	 * 
	 * @param sender
	 *            PId de l'instance du process émetteur.
	 * @param iNb
	 *            Nombre que le signal doit véhiculer.
	 */
	public SNb(IProcess sender, int iNb) {
		super(sender);
		nb = iNb;
	}

	/**
	 * Fournir le nombre véhiculé par ce signal.
	 * 
	 * @return le nombre.
	 */
	public int nb() {
		return nb;
	}
}
