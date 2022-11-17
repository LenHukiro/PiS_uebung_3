package controller;

/**
 * The enum Move direction, which translates the number into a direction
 */
public enum MoveDirection {
    /**
     * Right move direction.
     */
    RIGHT(2),
    /**
     * Left move direction.
     */
    LEFT(0),
    /**
     * Down move direction.
     */
    DOWN(1),
    /**
     * Up move direction.
     */
    UP(3);

    /**
     * The Direction.
     */
    final int direction;

    /**
     *
     * @param direction The direction of the enum
     */
    MoveDirection(int direction){
        this.direction = direction;
    }

}
