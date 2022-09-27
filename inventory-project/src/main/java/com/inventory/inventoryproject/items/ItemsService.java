package com.inventory.inventoryproject.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ItemsService {

	private final ItemsRepository itemsRepository;

	@Autowired
	public ItemsService(ItemsRepository itemsRepository) {
		this.itemsRepository = itemsRepository;
	}

	public List<Items> getItems() {
		return itemsRepository.findAll();
	}

	public void addNewItem(Items items) {
		Optional<Items> itemByName = itemsRepository.findItemsByName(items.getName());

		if(itemByName.isPresent()) {
			throw new IllegalStateException("Item already exists");
		}
		itemsRepository.save(items);
	}

	public void deleteItem(Long itemId) {
		boolean itemExists = itemsRepository.existsById((itemId));

		if (!itemExists) {
			throw new IllegalStateException("Item id " + itemId + " doesn't exist!");
		}

		itemsRepository.deleteById(itemId);
	}

	@Transactional
	public void updateItem(Long itemId, String name, String location) {
		Items items = itemsRepository.findById(itemId).orElseThrow(()
				-> new IllegalStateException("Item with " + itemId + " doesn't exist!"));

		if (name != null && name.length() > 0 && !Objects.equals(items.getName(), name)) {
			items.setName(name);
		}

		if (location != null && location.length() > 0 && !Objects.equals(items.getLocation(), location)) {
			items.setLocation(location);
		}
	}
}
