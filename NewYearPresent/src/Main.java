import candies.Caramel;
import candies.Chocolate;
import candies.Sweet;

public class Main {

    public static void main(String[] args) {
        Present present = new Present();

        Caramel caramel = new Caramel();
        caramel.setName("Alenka");
        caramel.setWeight(60);
                             
        Chocolate chocolate = new Chocolate();
        chocolate.setName("Snow");
        chocolate.setWeight(5);
        
        Chocolate chocolate1 = new Chocolate();
        chocolate1.setName("Nuts");
        chocolate1.setWeight(-1);
        
        present.addSweet(caramel);
        present.addSweet(chocolate);
        present.addSweet(chocolate1);
               
        try {
			System.out.println(present.getWeight());
		} catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println("Sorted by weight:");
        for (Sweet s : present.getSortedByWeight()) {
        	System.out.println(s);
        }  
        System.out.println("Sorted by name:");
        System.out.println(present.getSortedByName());
        
        System.out.println("Found candy by name:");
        Sweet found = present.getSweet(5, "Snow");
        if (found != null)
        	System.out.println(found);
        else
        	System.out.println("Sweet not found.");
    }

}