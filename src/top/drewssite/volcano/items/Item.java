package top.drewssite.volcano.items;

public abstract class Item {
	
	//VARS
	private String name;
	private ItemType type;
	private boolean important;
	
	//GETTERS & SETTERS
	public String getName() {
		return name;
	}
	
	public ItemType getType() {
		return type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(ItemType type) {
		this.type = type;
	}
	
	public boolean isImportant() {
		return important;
	}
	
	public void setImportancy(boolean important) {
		this.important = important;
	}
	
	public Item(String name, ItemType type, boolean important) {
		this.name = name;
		this.type = type;
		this.important = important;
	}
	
}
