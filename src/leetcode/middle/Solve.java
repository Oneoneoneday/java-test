package leetcode.middle;

/**
 * @author liyh
 * @version 1.0.0
 * @title
 * @description
 * @date 2020/8/12 18:09
 */
public class Solve {

    private static final char X = 'X';
    private static final char O = 'O';
    private static final char Y = 'Y';

    /*
     *       给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
     *       找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     *       X X X X         X X X X
     *       X O O X  ---->  X X X X
     *       X X O X         X X X X
     *       X O X X         X O X X
     */

    public static void main(String[] args) {
        char[][] board = new char[4][];
        board[0] = new char[]{'X', 'X', 'X', 'X'};
        board[1] = new char[]{'X', 'O', 'O', 'X'};
        board[2] = new char[]{'X', 'X', 'O', 'X'};
        board[3] = new char[]{'X', 'O', 'X', 'X'};
        test(board);

        char[][] board1 = new char[2][];
        board1[0] = new char[]{'O', 'O'};
        board1[1] = new char[]{'O', 'O'};
        test(board1);

        char[][] board2 = new char[4][];
        board2[0] = new char[]{'X', 'O', 'X', 'O', 'X', 'O'};
        board2[1] = new char[]{'O', 'X', 'O', 'X', 'O', 'X'};
        board2[2] = new char[]{'X', 'O', 'X', 'O', 'X', 'O'};
        board2[3] = new char[]{'O', 'X', 'O', 'X', 'O', 'X'};
        test(board2);

    }

    public static void test(char[][] board) {
        print(board);
        System.out.println("=========================");
        solve(board);
        print(board);
        System.out.println("=========================");
    }

    //&& !((x == 0 && y == 0) || (x == 0 && y == board[0].length - 1) || (x == board.length - 1 && y == 0) || (x == board.length - 1 && y == board[board.length - 1].length - 1))

    public static void solve(char[][] board) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                // 找到边上为O的 //todo (找到4条边 此处可优化)
                boolean isSide = (x == 0 || x == board.length - 1 || y == 0 || y == board[x].length - 1);
                if (isSide && board[x][y] == O) {
                    board[x][y] = Y;
                    // 与边上为O的相连的数据
                    if (x == 0) {
                        // 上
                        replaceSideO(board, x + 1, y);
                    } else if (x == board.length - 1) {
                        // 下
                        replaceSideO(board, x - 1, y);
                    } else if (y == 0) {
                        // 左
                        replaceSideO(board, x, y + 1);
                    } else {
                        replaceSideO(board, x, y - 1);
                    }
                }
            }
        }
        replaceOAndY(board);
    }

    public static void replaceSideO(char[][] board, int x, int y) {
        // 不能超过边界
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) {
            return;
        }
        // 与XY相等就返回
        if (board[x][y] == X || board[x][y] == Y) {
            return;
        }
        // 将与之相连的用户置为第三个变量
        board[x][y] = Y;
        // 递归继续查找与之相连的
        replaceSideO(board, x - 1, y);
        replaceSideO(board, x + 1, y);
        replaceSideO(board, x, y - 1);
        replaceSideO(board, x, y + 1);
    }

    public static void replaceOAndY(char[][] board) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == O) {
                    board[x][y] = X;
                } else if (board[x][y] == Y) {
                    board[x][y] = O;
                }
            }
        }
    }

    public static void print(char[][] board) {
        for (char[] chars : board) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

}
