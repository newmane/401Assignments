package comp401.sushi;

public interface Ingredient {
    double getAmount();
    double getCost();
    boolean isRice();
    boolean isShellfish();
    boolean isVegetarian();
    String getName();
}
