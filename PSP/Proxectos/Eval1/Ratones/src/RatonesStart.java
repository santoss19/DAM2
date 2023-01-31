public class RatonesStart implements Runnable{
    private String nombre; 
 	private int tiempoAlimentacion; 
 
 	public RatonesStart(String nombre, int tiempoAlimentacion) { 
 		super(); 
 		this.nombre = nombre;  
 		this.tiempoAlimentacion= tiempoAlimentacion;
 	}
    public void comer () { 
	    try { 

		    System. out .printf ("El ratón %s ha comenzado a alimentarse%n",nombre) ; 
		    Thread.sleep(tiempoAlimentacion * 1000) ; 
		    System.out.printf("El ratón %s ha terminado de alimentarse%n",nombre) ; 
	    } catch (InterruptedException e) {
		    e.printStackTrace () ; 
	    }
	 
    }

 	@Override 
 	public void run () { 
 		this.comer () ; 
 	}

    public static void main(String[] args) { 
        RatonesStart fievel = new RatonesStart( "Fievel" , 4); 
        RatonesStart jerry = new RatonesStart( "Jerry" , 5); 
        RatonesStart pinky = new RatonesStart( "Pinky" , 3); 
        RatonesStart mickey = new RatonesStart("Mickey" , 6); 
        new Thread (fievel).start(); 
        new Thread (jerry).start(); 
        new Thread (pinky).start(); 
        new Thread (mickey).start(); 
    }
}
