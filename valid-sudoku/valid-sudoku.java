// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         Map<Integer, Set<Character>> rowSet = new HashMap<>();
//         Map<Integer, Set<Character>> colSet = new HashMap<>();
//         Map<Integer, Set<Character>> blockSet = new HashMap<>();
        
        
//         int m = board.length;
//         int n = board[0].length;
        
//         for(int i = 0; i < m; i++){
//              rowSet.put(i, new HashSet<Character>());
//             for(int j = 0; j < n; j++){
//                 char val = board[i][j];
//                 if(val != '.'){
//                     if(!rowSet.get(i).contains(val)){
//                         rowSet.get(i).add(val);
//                     } else
//                         return false;    
//                 }
//             }
//         }
        
        
//           for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 char val = board[i][j];
//                 colSet.putIfAbsent(j, new HashSet<Character>());
//                 if(val != '.'){
//                     if(!colSet.get(j).contains(val)){
//                         colSet.get(j).add(val);
//                     } else
//                         return false;    
//                 }
//             }
//         }
        
//            for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 char val = board[i][j];
//                 int blockValue = (i / 3) * 3 + (j / 3);
//                 if(!blockSet.containsKey(blockValue))
//                     blockSet.put(blockValue, new HashSet<Character>());
//                 if(val != '.'){
//                     if(!blockSet.get(blockValue).contains(val)){
//                         blockSet.get(blockValue).add(val);
//                     } else
//                         return false;    
//                 }
//             }
//         }
        
//         return true;
//     }
// }


class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // Use hash set to record the status
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];

                // Check if the position is filled with number
                if (val == '.') {
                    continue;
                }

                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}


/**
class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
              
            if (board[i][j] == '.') {
                
              for (char c = '1'; c <= '9'; c++) {
                if (isValid(board, i, j, c)) {
                  board[i][j] = c;

                  if (solve(board)) {
                    return true; 
                  }
                  else {
                    board[i][j] = '.'; 
                  }
                }
              }
              return false;
            }
          }
        }
        return true;
      }

  public boolean isValid(char[][] board, int row, int col, char c) {
    for (int i = 0; i < 9; i++) {
        
      // checking entire column 
      if (board[i][col] == c) {
        return false; 
      }

      // checking entire row
      if (board[row][i] == c) {
        return false; 
      }

      // checking entire sub grid
      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
        return false; 
      }
    }
    return true;
  }
}
**/