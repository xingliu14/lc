// https://leetcode.com/problems/design-snake-game/
// 就硬写

class SnakeGame {
    
    List<Integer> pos;
    List<Integer> foods;
    int width, height, score;
    Map<String, int[]> dir_map = Map.of(
        "U", new int[] {-1, 0},
        "L", new int[] {0, -1},
        "R", new int[] {0, 1},
        "D", new int[] {1, 0}
    );

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.score = 0;
        pos = new ArrayList<> ();
        pos.add(0);
        foods = new ArrayList<> ();
        for(int[] f : food) {
            foods.add(f[0] * width + f[1]);
        }
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] dir = dir_map.get(direction);
        int last_pos = pos.get(pos.size() - 1), last_r = last_pos / width, last_c = last_pos % width;
        int new_r = last_r + dir[0], new_c = last_c + dir[1];
        if(new_r < 0 || new_r >= height || new_c < 0 || new_c >= width) {
            return -1;
        }
        int new_pos = new_r * width + new_c;
        if(!foods.isEmpty() && foods.get(0) == new_pos) {
            foods.remove(0);
            score++;
            pos.add(new_pos);
        } else {
            pos.remove(0);
            if(pos.contains(new_pos)) {
                return -1;
            } else {
                pos.add(new_pos);
            }
        }
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */