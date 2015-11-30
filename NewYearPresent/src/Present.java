import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import candies.Sweet;

public class Present {
	private List<Sweet> sweetList = new ArrayList<Sweet>();

	public void addSweet(Sweet sweet) {
		this.sweetList.add(sweet);
	}

	public int getWeight() {
		int weight = 0;

		for (Sweet s : sweetList) {
			weight += s.getWeight();
		}

		return weight;
	}

	public List<Sweet> getSortedByWeight() {
		List<Sweet> sorted = sweetList;
		Collections.sort(sorted);
		return sorted;
	}

	public List<Sweet> getSortedByName() {
		List<Sweet> sorted = sweetList;
		Collections.sort(sorted, new Comparator<Sweet>() {
			
			public int compare(final Sweet sweet1, final Sweet sweet2) {
				return sweet1.getName().compareTo(sweet2.getName());
			}
		});
		return sorted;
	}
	
	public Sweet getSweet(int weight, String name) {
		Sweet sweet = null;

		for (Sweet s : sweetList) {
			if (s.getWeight() == weight && name.equals(s.getName())) {
				sweet = s;
				break;
			}
		}

		return sweet;
	}
	
}

