class TicTacToe {

    int[][] board;
    int size;
    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.size = n;
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        int count = 0;
        for(int i = 0; i < board.length; i++){
           if(board[i][col] == player)
               count++;
        }
        if(count == size)
            return player;
        else
            count = 0;
        for(int i = 0; i < board.length; i++){
            if(board[row][i] == player){
                count++;
            }
        }
        if(count == size)
            return player;
        else
            count = 0;
        for(int i = 0; i < board.length; i++){
            if(board[i][i] == player){
                count++;
            }
        }
        if(count == size)
            return player;
        else
            count = 0;
        
        for(int i = board.length - 1; i > - 1; i--){
            if(board[board.length - 1 - i][i] == player){
                // System.out.println(board[i][i]+"<<<<<");
                count++;
            }
        }
        if(count == size)
            return player;
        
        // System.out.println(Arrays.deepToString(board));
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */