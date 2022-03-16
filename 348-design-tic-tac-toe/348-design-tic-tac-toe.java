class TicTacToe {

    private int[][] board;
    private int n;

    public TicTacToe(int n) {
        board = new int[n][n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        // check if the player wins
        if ((checkRow(row, player)) ||
            (checkColumn(col, player)) ||
            (row == col && checkDiagonal(player)) ||
            (col == n - row - 1 && checkAntiDiagonal(player))) {
            return player;
        }
        // No one wins
        return 0;
    }

    private boolean checkDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][row] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][n - row - 1] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col, int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(int row, int player) {
        for (int col = 0; col < n; col++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }
}
// class TicTacToe {

//     int[][] board;
//     int size;
//     public TicTacToe(int n) {
//         this.board = new int[n][n];
//         this.size = n;
//     }
    
//     public int move(int row, int col, int player) {
//         board[row][col] = player;
//         int count = 0;
//         for(int i = 0; i < board.length; i++){
//            if(board[i][col] == player)
//                count++;
//         }
//         if(count == size)
//             return player;
//         else
//             count = 0;
//         for(int i = 0; i < board.length; i++){
//             if(board[row][i] == player){
//                 count++;
//             }
//         }
//         if(count == size)
//             return player;
//         else
//             count = 0;
//         for(int i = 0; i < board.length; i++){
//             if(board[i][i] == player){
//                 count++;
//             }
//         }
//         if(count == size)
//             return player;
//         else
//             count = 0;
        
//         for(int i = board.length - 1; i > - 1; i--){
//             if(board[board.length - 1 - i][i] == player){
//                 count++;
//             }
//         }
//         if(count == size)
//             return player;
        
        
//         return 0;
//     }
// }

// /**
//  * Your TicTacToe object will be instantiated and called as such:
//  * TicTacToe obj = new TicTacToe(n);
//  * int param_1 = obj.move(row,col,player);
//  */