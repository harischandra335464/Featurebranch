package java8;
import java.util.stream.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class java8features {

	public static void main(String[] args) {
		
		
		List<String> names = new ArrayList<String>();
		names.add("Larry");
		names.add("steve");
		names.add("sames");
		names.add("Conan");
		names.add("Ellen");
		 
	 //using annonymous class
		Consumer<String> action = new Consumer<String>() {
	    	@Override
	    	public void accept(String t) {
	    		System.out.println(t);
	    	}
	    };
	    
	    names.forEach(action);
	   
	   Stream s = names.stream().filter(t->t.startsWith("s"));
	 //using lambda expression 
	   s.forEach(t->System.out.println("   "+ t ));
	 
	   //using method refence 	   
	  //names.forEach(t->System.out.println(t));
	  //  names.forEach(System.out::println);
	
	
	HashMap<String,Integer> mp=new HashMap<>();
		
		mp.put("ram",1);
		mp.put("shyam",2);
		mp.put("haris",3);
		mp.put("harischandra",4);
		
		
		BiConsumer<String,Integer> action1 = new BiConsumer<String, Integer>() {

			@Override
			public void accept(String t, Integer u) {
				System.out.println("name : "+t+"------------------"+"id : "+u);
				System.out.println();
				
			}
		};
	//	mp.forEach(action1);
		mp.forEach((k,v)->System.out.println("name : "+k+"------------------"+"id : "+v));
		
   // Stream API/filter/map/collect//collectors/count/sorted
		
		ArrayList<Integer> l = new ArrayList<>();
		l.add(20);
		l.add(24);
		l.add(26);
		l.add(25);
		l.add(27);
		l.add(22);
		
		System.out.print("---" + l);
		List<Integer> l2 = l.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println("---"+l2);
		
		//sort in ascending 
		System.out.println("====sorting in ascending and descending====");
		List<Integer> l3 = l.stream().sorted().collect(Collectors.toList());
		System.out.println("---"+l3);
		
		//sort in descending order
		//List<Integer> l4 = l.stream().sorted((i1,i2)->i2.compareTo(i1)).collect(Collectors.toList());
		List<Integer> l4 = l.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("---"+l4);
		
		//find min and max of the element
		//min(comparator)
		int min = l.stream().min((i1,i2)->i1.compareTo(i2)).get();
		int max = l.stream().max((i1,i2)->i1.compareTo(i2)).get();
		
		System.out.println("minimum and maxium element is " + min + "   "+max );
		
		
		//method reference
		
		
		
	}

}
