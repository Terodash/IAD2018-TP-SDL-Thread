package fr.imtld.sdl.support;

/**
 * Une interface Process SDL simple.
 * 
 * @author: C. TOMBELLE
 */
public interface IProcess {
    /**
	 * Déposer un signal dans la fifo de cette instance de process SDL.
	 * 
	 * @param oSignal
	 *            Le signal à déposer.
     */
    public void add( Object oSignal );
	/**
	 * Définir le parent de ce Pipe et démarrer son thread SDL.
	 * 
	 * @param procParent
	 *            Processus parent
	 */
    public void setParent( IProcess procParent );
}
