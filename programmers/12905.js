
function solution(board) {
    if (board.length === 1 && board[0][0] === 1) {
        // board == [[1]] 
        return 1;
    }

    let maxValue = 0;
    for (let i = 1; i < board.length; ++i) {
        for (let j = 1; j < board[i].length; ++j) {
            if (board[i][j]) {
                // if (left or up or upLeft == 0 )
                //  board[i][j] = 0;
                // else 
                //  board[i][j] = min(left, up, upLeft) + 1
                const up = board[i - 1][j];
                const left = board[i][j - 1];
                const upLeft = board[i - 1][j - 1];
                board[i][j] = Math.min(up, left, upLeft) + 1;
                maxValue = Math.max(board[i][j], maxValue);
            }
        }
    }
    return maxValue * maxValue;
}