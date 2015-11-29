import java.util.*;

public class ArrayVsArrayList
{
  static public void main( String[] args )
  {
    String[] array = new String[300];
    ArrayList<String> list = new ArrayList<String>(300);
    for (int i=0; i<300; ++i)
    {
      if (Math.random() > 1) array[i] = "abc";
      else                   array[i] = "xyz";
      list.add( array[i] );
    }

    int iterations = 10000;
    long start_ms;
    int sum;

    start_ms = System.currentTimeMillis();
    sum = 0;
    for (int i=0; i<iterations; ++i)
    {
      for (int j=0; j<300; ++j) sum += array[j].length();
    }
    System.out.println( (System.currentTimeMillis() - start_ms) + " ms (array)" );
    // Prints ~13,500 ms on my system

    start_ms = System.currentTimeMillis();
    sum = 0;
    for (int i=0; i<iterations; ++i)
    {
      for (int j=0; j<300; ++j) sum += list.get(j).length();
    }
    System.out.println( (System.currentTimeMillis() - start_ms) + " ms (ArrayList)" );
    // Prints ~20,800 ms on my system - about 1.5x slower than direct array access
  }
}