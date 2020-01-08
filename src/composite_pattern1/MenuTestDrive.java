package composite_pattern1;

public class MenuTestDrive {
	public static void main(String[] args) {
		MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
		MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
		MenuComponent cafemenu = new Menu("CAFE MENU", "Diner");
		
		MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
		allMenus.add(new MenuItem("Pancake", "Eggs and toast", 2.99));
		
		Waitress waitress = new Waitress(allMenus);
		waitress.printMenu();
	}
}
