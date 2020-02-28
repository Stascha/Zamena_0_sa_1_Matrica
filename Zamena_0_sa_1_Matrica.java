import java.util.*;

public class Convert_Matrix
{
  // Funkcija koja konvertuje matricu datu kao List<List<Integer>> u matricu u obliku int[][]
    public static int[][] List_List_Integer_Matrix_to_int_Matrix(List<List<Integer>> list)
    {
        int[][] array = new int[list.size()][];
		
	    for (int i = 0; i < array.length; i++)
		    array[i] = new int[list.get(i).size()];
	
	    for(int i=0; i<list.size(); i++)
	  	    for (int j = 0; j < list.get(i).size(); j++) 
		   	    array[i][j] = list.get(i).get(j);
		   
	   return array;
    }
    
  

  // Funkcija koja konvertuje matricu datu kao int[][] u matricu u obliku List<List<Integer>>  
    public static List<List<Integer>>  Int_Matrix_to_List_List_Integer_Matrix(int[][] matrix)
    {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
 
	    for (int i = 0; i < matrix.length; i++)
		  {    
		    List<Integer> integers = new ArrayList<Integer>();
		    
		    for(int j=0; j< matrix[i].length; j++)
	           integers.add( matrix[i][j] );
		  
		    list.add(integers);
	    }
		
	    return list;
    }

    // Funkcija koja pravi matricu kao List<List<Integer>> i popunjava je slučajnim brojevima od 0 do max
    public static List<List<Integer>>  Make_A_Matrix_As_a_List_List_Integer(int rows, int columns, int max)
    {
        Random random = new Random();
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
		
	    for(int i = 0; i< rows; i++)
	    {
		    List<Integer> integers = new ArrayList<Integer>();
			
		    for(int j=0; j<columns; j++)
			    integers.add(random.nextInt(max));
		
	    	list.add(integers);
			
	    }
		
	    return list;
    }	
    
    // Za datu matricu funkcija zamenjuje 0 sa 1 ako se pored nule gore ili dole ili nazad ili napred 
    // nalazi bar jedna 1.
    // Funkcija vraća broj koliko puta treba zameniti 0 sa 1
    public static int Function(List<List<Integer>> list)
    {
        int[][] a = List_List_Integer_Matrix_to_int_Matrix(list);
        
        int[][] b = new int[a.length][a[0].length];
        
	      int counter = 1;
	      int number = 0;
	    
	      for (int i = 0; i < a.length; i++)
	   	    for (int j = 0; j < a[i].length; j++) 
	       	  b[i][j] = a[i][j];
	    
	      while( counter > 0 )
	      {
	        counter = 0;

	        for (int i = 0; i < a.length; i++)
	        {
		        for (int j = 0; j < a[i].length; j++) 
	    	    {
	    	        if(a[i][j] == 0)
	    	            counter += 1;
	    	        
	    	         if( a[i][j] == 1 && i < (a.length - 1))
	    	            b[i+1][j] = 1;
	    	            
	    	         if( a[i][j] == 1 && i > 0 )
	    	            b[i-1][j] = 1;
	    	        
	    	       
	    	         if( a[i][j] == 1 && j < a[i].length - 1)      
	    	            b[i][j+1] = 1;
	    	            
	    	         if( a[i][j] == 1 && j > 0)      
	    	            b[i][j-1] = 1;
   	          
	    	     }
	    	    
	    	   }     
	

          if(counter > 0)
	          number = number + 1;
	       
	        if(counter == 0)
	          break;
	            
	        for (int i = 0; i < a.length; i++)
	   	        for (int j = 0; j < a[i].length; j++) 
	       	        a[i][j] = b[i][j];
	       	        
	        for (int i = 0; i < a.length; i++)
	        {
		        for (int j = 0; j < a[i].length; j++) 
	    	      System.out.print(  b[i][j] + " "  ); 
	
		        System.out.println(	);
	        }
	       
	       System.out.println(	);

	     }

	     return number;
    }

    public static void main (String[] args)
    {
   	  // Pravi se matrica List<List<Integer>> list i popunjava se random brojevima od 0 do 1
   	    List<List<Integer>> list =  Make_A_Matrix_As_a_List_List_Integer(9, 9, 2);
	    
	    for (int i = 0; i < list.size(); i++)
	    {
		    for (int j = 0; j < list.get(i).size(); j++) 
	    	    System.out.print(	list.get(i).get(j) + " " );
	    	    
	    	 System.out.println( );
	    }
	    
	    System.out.println(	);
	    
	    int s = Function(list);
	    System.out.println( );
	    System.out.println( s );
	    
		
    }		

}
     
