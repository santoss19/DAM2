public class RatonesRun implements Runnable{
    private String nombre; 
 	private int tiempoAlimentacion; 
 
 	public RatonesRun(String nombre, int tiempoAlimentacion) { 
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
        RatonesRun fievel = new RatonesRun( "Fievel" , 4); 
        RatonesRun jerry = new RatonesRun( "Jerry" , 5); 
        RatonesRun pinky = new RatonesRun( "Pinky" , 3); 
        RatonesRun mickey = new RatonesRun("Mickey" , 6); 
        new Thread (fievel).run(); 
        new Thread (jerry).run(); 
        new Thread (pinky).run(); 
        new Thread (mickey).run(); 
    }
}
