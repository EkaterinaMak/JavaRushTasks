package com.javarush.task.Game2048.task3513.task3513;

import java.util.*;

/**
 * Created by Alexander on 29.05.2018.
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected int score;
    protected int maxTile;
    private Stack previousStates = new Stack();
    private Stack previousScores = new Stack();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();

    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue(4, Collections.reverseOrder());
        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::right));
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::down));
        queue.peek().getMove().move();
    }

    public boolean hasBoardChanged() {
        Tile[][] tiles = (Tile[][]) previousStates.peek();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value!=tiles[i][j].value) {
                    return true;
                }
            }
        }
        return false;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        int pScore = score;
        int pNumberOfEmptyTiles = getEmptyTiles().size();
        if (!hasBoardChanged()) {
            pScore = 0;
            pNumberOfEmptyTiles = -1;
        }
        rollback();
        return new MoveEfficiency(pNumberOfEmptyTiles, pScore, move);
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] newTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                newTiles[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(newTiles);
        previousScores.push(score);
        isSaveNeeded=false;
    }

    public void rollback() {
        if (!previousScores.isEmpty() && !previousStates.isEmpty()) {
            gameTiles = (Tile[][]) previousStates.pop();
            score = (int) previousScores.pop();
        }
    }

    public void resetGameTiles() {
        gameTiles=new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j]=new Tile();
            }
        }
        addTile();
        addTile();
        score=0;
        maxTile=0;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
               if (gameTiles[i][j].isEmpty()) {
                   tiles.add(gameTiles[i][j]);
               }
            }
        }
        return tiles;
    }

    private void addTile() {
        List<Tile> tiles = getEmptyTiles();
        if (tiles.size()>0) {
            tiles.get((int) (tiles.size() * Math.random())).value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean result = false;
        int sum=0;
        for (Tile t : tiles) {
            sum+=t.value;
        }
        if (sum>0) {
            Tile tmp;
            for (int i = tiles.length-1; i > 0 ; i--) {
                for (int j = 0; j < i; j++) {
                    if (tiles[j].value==0 && tiles[j+1].value!=0) {
                        tmp = tiles[j];
                        tiles[j]=tiles[j+1];
                        tiles[j+1]=tmp;
                        result=true;
                    }
                }
            }
        }
        return result;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean result = false;
        int sum=0;
        for (Tile t : tiles) {
            sum+=t.value;
        }
        if (sum>0) {
            for (int i = 0; i < tiles.length-1; i++) {
                if (tiles[i].value!=0 && tiles[i].value == tiles[i+1].value) {
                    int sumValue= tiles[i].value + tiles[i+1].value;
                    tiles[i].value = sumValue;
                    if (sumValue > maxTile) {
                        maxTile=sumValue;
                    }
                    score+=sumValue;
                    for (int j = i+1; j <tiles.length-1; j++) {
                        tiles[j]=tiles[j+1];
                    }
                    tiles[tiles.length-1] = new Tile();
                    result = true;
                }
            }
        }
        return result;
    }

    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean result = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                result=true;
            }
        }
        if (result)
            addTile();
        isSaveNeeded=true;
    }

    public void down() {
        saveState(gameTiles);
        Tile[][] array = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                array[i][j]=gameTiles[FIELD_WIDTH-1-j][i];
            }
        }
        gameTiles=array;
        left();

        array = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                array[i][j]=gameTiles[FIELD_WIDTH-1-j][i];
            }
        }
        gameTiles=array;

        array = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                array[i][j]=gameTiles[FIELD_WIDTH-1-j][i];
            }
        }
        gameTiles=array;

        array = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                array[i][j]=gameTiles[FIELD_WIDTH-1-j][i];
            }
        }
        gameTiles=array;
    }

    public void right() {
        saveState(gameTiles);
        Tile[][] array = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j <FIELD_WIDTH ; j++) {
                array[i][j]=gameTiles[i][FIELD_WIDTH-1-j];
            }
        }
        gameTiles=array;
        left();

        array = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j <FIELD_WIDTH ; j++) {
                array[i][j]=gameTiles[i][FIELD_WIDTH-1-j];
            }
        }
        gameTiles=array;
    }

    public void up() {
        saveState(gameTiles);
        Tile[][] array = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                array[i][j]=gameTiles[j][FIELD_WIDTH-1-i];
            }
        }
        gameTiles=array;
        left();

        array = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                array[i][j]=gameTiles[j][FIELD_WIDTH-1-i];
            }
        }
        gameTiles=array;

        array = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                array[i][j]=gameTiles[j][FIELD_WIDTH-1-i];
            }
        }
        gameTiles=array;

        array = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                array[i][j]=gameTiles[j][FIELD_WIDTH-1-i];
            }
        }
        gameTiles=array;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if (getEmptyTiles().size()>0) {
            return true;
        } else {
            Tile[][] array = new Tile[FIELD_WIDTH][FIELD_WIDTH];
            for (int i = 0; i < FIELD_WIDTH; i++) {
                for (int j = 0; j < FIELD_WIDTH; j++) {
                    array[i][j] = new Tile(gameTiles[i][j].value);
                }
            }
            boolean result = false;
            for (int i = 0; i < FIELD_WIDTH; i++) {
                if (compressTiles(array[i]) || mergeTiles(array[i])) {
                    result=true;
                }
            }
            if (result) {
                return true;
            } else {
                Tile[][] array2 = new Tile[FIELD_WIDTH][FIELD_WIDTH];
                for (int i = 0; i < FIELD_WIDTH; i++) {
                    for (int j = 0; j < FIELD_WIDTH; j++) {
                        array2[i][j]=array[FIELD_WIDTH-1-j][i];
                    }
                }
                for (int i = 0; i < FIELD_WIDTH; i++) {
                    if (compressTiles(array2[i]) || mergeTiles(array2[i])) {
                        result=true;
                    }
                }
                return result;
            }
        }
    }

    public void randomMove() {
        int  n = ((int) (Math.random() * 100)) % 4;
            if (n==0) {
                left();
            } else if (n==1) {
                right();
            } else if (n==2) {
                up();
            } else if (n==3) {
                down();
            }
    }
}
