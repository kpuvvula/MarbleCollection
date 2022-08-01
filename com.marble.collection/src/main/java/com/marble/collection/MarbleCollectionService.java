package com.marble.collection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

// Rest Service implementation
public class MarbleCollectionService {

	private static final String orderStringSmallCap = "roygbiv";
	
	/**
	 * This method will take the preconverted marble list and return the filtered marble list
	 * 
	 * @param originalList
	 * @return List<MarbleDTO>
	 */
	public List<MarbleDTO> getFilteredList(List<MarbleDTO> originalList) {
		
		/* Algorithm:
		 * Run the loop n number of times and filter the items to find out the matching items.
		 * Finally Sort the list to the order needed
		 * Time complexity is: o(n)
		 */
		
		List<MarbleDTO> finalMarbleList = new ArrayList<>();

		finalMarbleList = originalList.stream().filter(p -> p.getWeight().compareTo(new BigDecimal("0.5")) >= 0)
				.filter(p -> {
					String filtered = p.getName().replaceAll("\\W+", "");
					return filtered.equalsIgnoreCase(new StringBuilder(filtered).reverse().toString());
				}).sorted((obj1, obj2) -> Integer.compare(orderStringSmallCap.indexOf(obj1.getColor().charAt(0)),
						orderStringSmallCap.indexOf(obj2.getColor().charAt(0))))
				.collect(Collectors.toList());

		finalMarbleList.forEach(c -> System.out.println(c.toString()));

		return finalMarbleList;
	}
	
	/**
	 * This method takes JsonObject as input and returns the filtered Marble list.
	 * 
	 * @param jsonObject
	 * @return List<MarbleDTO>
	 */
	public List<MarbleDTO> getFilteredList(String jsonObject) {
		
		/* Algorithm:
		 * Convert the JSON to the list of POJO objects
		 * Run the loop n number of times and filter the items to find out the matching items.
		 * Finally Sort the list to the order needed
		 * Time complexity is: o(n)
		 * Space complexity is: o(n)
		 */
		
		List<MarbleDTO> finalMarbleList = new ArrayList<>();
		
		try {
			List<MarbleDTO> originalList = new ArrayList<MarbleDTO>();
			ObjectMapper mapper = new ObjectMapper();
			originalList = mapper.readValue(jsonObject, new TypeReference<List<MarbleDTO>>() {
			});

			finalMarbleList = originalList.stream().filter(p -> p.getWeight().compareTo(new BigDecimal("0.5")) >= 0)
					.filter(p -> {
						String filtered = p.getName().replaceAll("\\W+", "");
						return filtered.equalsIgnoreCase(new StringBuilder(filtered).reverse().toString());
					}).sorted((obj1, obj2) -> Integer.compare(orderStringSmallCap.indexOf(obj1.getColor().charAt(0)),
							orderStringSmallCap.indexOf(obj2.getColor().charAt(0))))
					.collect(Collectors.toList());

			finalMarbleList.forEach(c -> System.out.println(c.toString()));
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return finalMarbleList;
	}

}