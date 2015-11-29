package candies;

public abstract class Sweet implements Comparable<Sweet> {
	private String name;// name of sweets
	private int weight;// weight of a one sweet

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int compareTo(Sweet o)
	{
	     return(weight - o.weight);
	}
	
	public String toString() {
		return "Name: " + getName() + ", weight: " + getWeight();
	}
}
