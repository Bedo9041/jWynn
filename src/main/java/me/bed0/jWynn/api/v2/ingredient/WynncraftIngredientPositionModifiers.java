package me.bed0.jWynn.api.v2.ingredient;

public class WynncraftIngredientPositionModifiers {

    private float left;
    private float right;
    private float above;
    private float below;
    private float touching;
    private float notTouching;

    public WynncraftIngredientPositionModifiers(float left, float right, float above, float below, float touching, float notTouching) {
        this.left = left;
        this.right = right;
        this.above = above;
        this.below = below;
        this.touching = touching;
        this.notTouching = notTouching;
    }

    public float getLeft() {
        return left;
    }

    public float getRight() {
        return right;
    }

    public float getAbove() {
        return above;
    }

    public float getBelow() {
        return below;
    }

    public float getTouching() {
        return touching;
    }

    public float getNotTouching() {
        return notTouching;
    }
}
