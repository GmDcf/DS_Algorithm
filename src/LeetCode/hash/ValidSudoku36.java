package LeetCode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yanglong09
 * @date 2019/8/27.
 */
public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] appearedRows = new boolean[9][9];
        boolean[][] appearedColoumns = new boolean[9][9];
        Map<String, Set<Integer>> nines = new HashMap<>(9);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]!='.') {
                    if (appearedRows[i][board[i][j] - '0' - 1]) {
                        return false;
                    } else {
                        appearedRows[i][board[i][j] - '0' - 1] = true;
                    }
                    if (appearedColoumns[j][board[i][j] - '0' - 1]) {
                        return false;
                    } else {
                        appearedColoumns[j][board[i][j] - '0' - 1] = true;
                    }
                    String key = i / 3 * 3 + "" + j / 3 * 3;
                    if (!nines.containsKey(key)) {
                        nines.put(key, new HashSet<>());
                    }
                    Set<Integer> nine = nines.get(key);
                    if (nine.contains(board[i][j] - '0' - 1)) {
                        return false;
                    }
                    nine.add(board[i][j] - '0' - 1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku36 validSudoku36 = new ValidSudoku36();
        char[][] board = new char[][]{};
    }
}
