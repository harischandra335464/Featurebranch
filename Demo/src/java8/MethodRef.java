package java8;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.*;

//Method reference to a static method of a class
class Multiplication{  
	   public static Double multiply(int a,int b){  
		return (double) (a*b);  
	   }  
	} 


//Method reference to an instance method of an object
@FunctionalInterface 
interface MyInterface{  
    void display();  
} 

interface MyInterface1{  
    Hello display(String say);  
} 

class Hello{  
    public Hello(String say){  
        System.out.print(say);  
    }  
} 

public class MethodRef {

	
	 public void myMethod(){  
			System.out.println("Instance Method");  
		    } 
	 
     public void myMethod2(){  
			System.out.println("Instance Method2");  
		    } 
	 

     public static void main(String[] args) {
		
		MethodRef mf =new MethodRef();	
		
		MyInterface ref = mf::myMethod;
		ref.display();
		
		MyInterface ref1 = mf::myMethod2;
		ref1.display();
		
		//Method reference to a static method of a class
		BiFunction<Integer,Integer,Double> product1 = Multiplication::multiply;  
		System.out.println(product1.apply(5,6));
		
		MyInterface1 refc = Hello::new;

	
		
     }

}
