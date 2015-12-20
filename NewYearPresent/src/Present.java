import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import candies.Sweet;
import mistake.LessThanNullException;

public class Present {

	private int weight;

	private List<Sweet> sweetList = new ArrayList<Sweet>();

	public void addSweet(Sweet sweet) {
		this.sweetList.add(sweet);
	}
	
	public void addSweets(List<Sweet> sweets) {
		this.sweetList.addAll(sweets);
	}

	public int getWeight() throws LessThanNullException {
		for (Sweet s : sweetList) {
			if (s.getWeight() < 0)
				throw new LessThanNullException("Weight can't be < 0. Current weight is: " + s.getWeight()
						+ ". Current sweet is: " + s.getName());
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

	public Sweet getSweetFromPresent(int weight, String name) {
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
