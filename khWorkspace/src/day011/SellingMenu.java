package day011;

class SellingMenu {
	private String menu, menuTag;
	private int price;
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getMenuTag() {
		return menuTag;
	}
	public void setMenuTag(String menuTag) {
		this.menuTag = menuTag;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}

class Keyboard extends SellingMenu{
	private String keyType, layout;

	public String getKeyType() {
		return keyType;
	}

	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}
}

class Mouse extends SellingMenu{
	private String mouseType, buttenType;

	public String getmouseType() {
		return mouseType;
	}

	public void setMouseType(String mouseType) {
		this.mouseType = mouseType;
	}

	public String getButtenType() {
		return buttenType;
	}

	public void setButtenType(String buttenType) {
		this.buttenType = buttenType;
	}
}