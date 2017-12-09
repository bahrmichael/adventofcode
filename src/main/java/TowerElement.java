public class TowerElement {
    private final String name;
    private final Integer weight;
    private final String[] children;

    public TowerElement(final String name, final Integer weight, final String[] children) {
        this.name = name;
        this.weight = weight;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }

    public String[] getChildren() {
        return children;
    }
}
