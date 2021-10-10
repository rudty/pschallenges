function isRemove(board, x, y) {
    if (!board[y]) {
        return false;
    }

    const e = board[y][x];

    if (!e) {
        return false;
    }

    return e === board[y + 1][x] &&
        e === board[y][x + 1] &&
        e === board[y + 1][x + 1];
}

function solution(h, w, board) {
    for (let i = 0; i < h; ++i) {
        board[i] = board[i].split("");
    }

    while (true) {
        const canRemovePos = [];
        for (let i = 0; i < h - 1; ++i) {
            for (let j = 0; j < w - 1; ++j) {
                if (isRemove(board, j, i)) {
                    canRemovePos.push([j, i]);
                    canRemovePos.push([j + 1, i]);
                    canRemovePos.push([j, i + 1]);
                    canRemovePos.push([j + 1, i + 1]);
                }
            }
        }

        if (canRemovePos.length === 0) {
            break;
        }

        for (const [x, y] of canRemovePos) {
            board[y][x] = 0;
        }

        for (let x = 0; x < w; ++x) {
            for (let y = h - 1; y >= 0; --y) {
                if (board[y][x] === 0) {
                    let move = false;
                    do {
                        move = false;
                        for (let i = y - 1; i >= 0; --i) {
                            board[i + 1][x] = board[i][x];
                            if (board[i][x]) {
                                move = true;
                            }
                        }
                        board[0][x] = 0;
                    } while(move && board[y][x] === 0);
                }
            }
        }
    }
    
    let S = 0;
    for (let i = 0; i < h; ++i) {
        for (let j = 0; j < w; ++j) {
            if (board[i][j] === 0) {
                S += 1;
            }
        }
    }
    return S;
}

solution(4,5,["CCBDE", "AAADE", "AAABF", "CCBBF"]);

// for (let i = 0; i < h; ++i) {
//     console.log(board[i].join(""));
// }
// console.log(board[y][x]);
// console.log("");
// console.log("");
// console.log("");
// console.log("");