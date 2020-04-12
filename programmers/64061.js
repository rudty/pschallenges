function getNextIndex(board, moveIndex) {
    for (var i = 0; i < board.length; ++i) {
        if (board[i][moveIndex] != 0) {
            return i;
        }
    }
    return board.length;
}

function solution(board, moves) {
    var lastPos = board[0].map((_, i) => getNextIndex(board, i))
    var outputValue = [];
    var answer = 0;

    for (var m of moves) {
        if (lastPos[m - 1] >= board.length) {
            continue;
        }
        var currentValue = board[lastPos[m - 1]][m - 1];
        if (currentValue === outputValue[outputValue.length - 1]) {
            answer += 1;
            outputValue.pop();
        } else {
            outputValue.push(currentValue);
        }
        lastPos[m - 1] += 1;
    }

    return answer * 2;
}
