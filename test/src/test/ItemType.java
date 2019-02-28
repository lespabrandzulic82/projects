package test;

public enum ItemType {

	AU("Audio"),
    VI("Visual"),
    AM("AudioMobile"),
    VM("VisualMobile");

    private String value;

    ItemType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
	
}
