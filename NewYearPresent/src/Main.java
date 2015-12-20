import candies.Caramel;
import candies.Chocolate;
import candies.Sweet;
import importDataBase.ConnectDataBase;
import importFiles.SweetDataFromTXT;
import importFiles.SweetDataFromXML;
import mistake.LessThanNullException;

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
        chocolate1.setWeight(15);
        
        present.addSweet(caramel);
        present.addSweet(chocolate);
        present.addSweet(chocolate1);
        for (Sweet sweet: new SweetDataFromTXT().getSweetFromSource()){
        	present.addSweet(sweet);
        }
        
        for (Sweet sweet: ConnectDataBase.loadSweets()){
        	present.addSweet(sweet);
        }
        
        for (Sweet sweet: SweetDataFromXML.getSweetFromXML()){
        	present.addSweet(sweet);
        }
               
        try {
			System.out.println(present.getWeight());
		} catch (LessThanNullException e) {
			e.printStackTrace();
		}
        System.out.println("Sorted by weight:");
        for (Sweet s : present.getSortedByWeight()) {
        	System.out.println(s);
        }  
        System.out.println("Sorted by name:");
        System.out.println(present.getSortedByName());
        
        System.out.println("Found candy by name:");
        Sweet found = present.getSweetFromPresent(5, "Snow");
        if (found != null)
        	System.out.println(found);
        else
        	System.out.println("Sweet not found.");
    }
    
}