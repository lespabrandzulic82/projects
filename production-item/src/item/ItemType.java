package item;

public enum ItemType {
	
    Audio("AU"),
    Visual("VI"),
    AudioMobile("AM"),
    VisualMoble("VM");

    private String value;

    private ItemType(String value) {
       this.value = value;
    }

    public String getValue() {
       return value;
    }

}
