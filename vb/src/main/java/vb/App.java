package vb;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println( "Il n'existe pas de meilleure modification" );
        App monApp = new App() ;
		System.out.println("Max : " + monApp.max(4,5));
		System.out.println("Max : " + monApp.max(5,4));
    }
    public int max(int a, int b)
    {
    	return a < b?b:a;
    }
}
