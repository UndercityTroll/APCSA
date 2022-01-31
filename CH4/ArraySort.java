import java.util.*;

public class ArraySort{
    public static void main(String [] args) {
      int[] array1 = {2, 4, 1, 3};
      int[] array2 = {0, 0, 0, 0};
      int a2 = 0;
      for (int a1=1; a1 < array1.length; a1++)
      {
   if (array1[a1] >= 2)
   {
      array2[a2] = array1[a1];
      a2++;
   }
}
        System.out.println(array2[0]+" "+array2[1]+" "+array2[2]+" "+array2[3]+" ");
    }

    public static boolean issort(int[] x){
        boolean b = true;
for (int i=0 ; i < x.length - 1; i++)
{
   if ( x[i] > x[i+1] )
      b = false;
   else
      b = true;
}
return b;

    }
}