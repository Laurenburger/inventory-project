package com.inventory.inventoryproject.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/items")
public class ItemsController {

	private final ItemsService itemsService;

	@Autowired
	public ItemsController(ItemsService itemsService) {
		this.itemsService = itemsService;
	}

	@GetMapping
	public List<Items> getItems() {
		return itemsService.getItems();
	}

	@PostMapping
	public void registerNewItem(@RequestBody Items items) {
		itemsService.addNewItem(items);
	}

	@DeleteMapping(path = "{itemId}")
	public void deleteItem(@PathVariable("itemId") Long itemId) {
		itemsService.deleteItem(itemId);
	}

	@PutMapping(path = "{itemId}")
	public void updateItem(@PathVariable("itemId") Long itemId, @RequestParam(required = false) String name,
			@RequestParam(required = false) String location) {
		itemsService.updateItem(itemId, name, location);
	}


}
