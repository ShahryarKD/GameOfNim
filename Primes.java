/* Modify the prime number program in Listing 8-11 to include all the prime
 numbers less than 10,000.
 */
import java.util.*;

public class Primes extends Object
{
     private static final int MAX_VALUE = 10000;
     
     private HashSet<Integer> primes;
     
     public Primes()
     {  this.primes = new HashSet<Integer>();
          this.calcPrimes(MAX_VALUE);
     }
     
     private void calcPrimes(int maxValue)
     {
          for(int i = 2; i <= maxValue; i++)
          {  
               if(this.isPrime(i))
               {  
                    this.primes.add(i);
               }
          }
     }
     
     // assumes that primes contains all prime
     // numbers < x
     private boolean isPrime(int x)
     {
          for(Integer i : this.primes)
          {  if(x % i == 0)
               {  return false;
          }
          }
          return true;
     }
     
     public boolean checkIfPrime(int x)
     {   return this.primes.contains(x);
     }
     
     public static void main(String[] args)
     {  Primes p = new Primes();
          
          int testNo = 0;
          do {
               testNo = Prompt.getInt("Enter a number to test if it is prime (-ve no to exit)");
               if (testNo>0) {
                    if(p.checkIfPrime(testNo)){
                         System.out.printf("%d is prime%n",testNo);
                    }
                    else {
                         System.out.printf("%d is  not prime%n",testNo);
                    }
               }
          } while (testNo > 0);             
          
     }
     
}