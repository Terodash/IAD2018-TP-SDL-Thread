package fr.imtld.sdl.support;

/**
 * Base pour l'implantation de signaux SDL.
 */
public class Signal {
	/** PId de l'émetteur du signal. */
	protected IProcess sender;

	/**
	 * Créer une instance du signal SDL.
	 * 
	 * @param sender
	 *            PId de l'instance du process émetteur.
	 */
	protected Signal(IProcess sender) {
		this.sender = sender;
	}

	/**
	 * Fournir le PId de l'instance du process émetteur.
	 * 
	 * @return Le PId.
	 */
	public IProcess getSender() {
		return sender;
	}
}
