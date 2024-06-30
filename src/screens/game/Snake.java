package screens.game;

import java.util.Vector;

public class Snake {

    private final Vector<Point> bodySegments;
    private Directions moveDirection;

    public Snake() {
        this.bodySegments = new Vector<>();
        this.setStartSegments();
        this.moveDirection = Directions.RIGHT;
    }

    private void setStartSegments() {
        this.bodySegments.add(new Point(GameBoard.WIDTH / 2, GameBoard.HEIGHT / 2));
        this.bodySegments.add(new Point(GameBoard.WIDTH / 2 - 1, GameBoard.HEIGHT / 2));
        this.bodySegments.add(new Point(GameBoard.WIDTH / 2 - 2, GameBoard.HEIGHT / 2));
    }

    public void clear() {
        this.bodySegments.clear();
        this.setStartSegments();
    }

    public Vector<Point> getBodySegments() {
        return this.bodySegments;
    }

    public Point getHead() {
        return this.bodySegments.getFirst();
    }

    public boolean collisionOccurs() {
        Point head = getHead();
        for (int segmentNr = 1; segmentNr < this.bodySegments.size(); ++segmentNr) {
            if (head.equals(this.bodySegments.get(segmentNr))) {
                return true;
            }
        }
        return false;
    }

    public void lengthen(Point headNewCoordinates) {
        this.bodySegments.addFirst(headNewCoordinates);
    }

    public void setMoveDirection(Directions moveDirection) {
        if (this.moveDirection == Directions.UP && moveDirection == Directions.DOWN) {
            return;
        }
        if (this.moveDirection == Directions.DOWN && moveDirection == Directions.UP) {
            return;
        }
        if (this.moveDirection == Directions.LEFT && moveDirection == Directions.RIGHT) {
            return;
        }
        if (this.moveDirection == Directions.RIGHT && moveDirection == Directions.LEFT) {
            return;
        }
        this.moveDirection = moveDirection;
    }

    public void makeMove() {
        switch (this.moveDirection) {
            case UP:
                this.moveUp();
                break;
            case DOWN:
                this.moveDown();
                break;
            case LEFT:
                this.moveLeft();
                break;
            case RIGHT:
                this.moveRight();
                break;
        }
    }

    private void moveHead(Point headNewPosition) {
        this.bodySegments.addFirst(headNewPosition);
        this.bodySegments.removeLast();
    }

    private void moveUp() {
        Point head = getHead();
        if (head.y() == 0) {
            this.moveHead(new Point(head.x(), GameBoard.HEIGHT - 1));
        } else {
            this.moveHead(new Point(head.x(), head.y() - 1));
        }
    }

    private void moveDown() {
        Point head = getHead();
        if (head.y() == GameBoard.HEIGHT - 1) {
            this.moveHead(new Point(head.x(), 0));
        } else {
            this.moveHead(new Point(head.x(), head.y() + 1));
        }
    }

    private void moveLeft() {
        Point head = getHead();
        if (head.x() == 0) {
            this.moveHead(new Point(GameBoard.WIDTH - 1, head.y()));
        } else {
            this.moveHead(new Point(head.x() - 1, head.y()));
        }
    }

    private void moveRight() {
        Point head = getHead();
        if (head.x() == GameBoard.WIDTH - 1) {
            this.moveHead(new Point(0, head.y()));
        } else {
            this.moveHead(new Point(head.x() + 1, head.y()));
        }
    }

}
