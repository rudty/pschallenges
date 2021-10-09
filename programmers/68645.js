const M = [];
let cursorX = 0;
let cursorY = 0;
let writeNum = 1;

function* getMoveFunction() {
    while(1) {
        yield () => cursorY += 1;
        cursorY -= 1;
        cursorX += 1;
        yield () => cursorX += 1;
        cursorX -= 2;
        cursorY -= 1;
        yield () => {
            cursorX -= 1;
            cursorY -= 1;
        };
        cursorX += 1;
        cursorY += 2;
    }
}

function writeOne(count, moveXyFn) {
    for (let i = 0; i < count; ++i) {
        M[cursorY][cursorX] = writeNum;
        moveXyFn();
        writeNum += 1;
    }
}

function solution(n) {

    for (let i = 0; i < n; ++i) {
        M.push(new Array(n));
    }

    const functionGen = getMoveFunction();
    for (let i = n; i > 0; --i) {
        writeOne(i, functionGen.next().value);
    }
   
    const r = [];

    for (let i = 0; i < n; ++i) {
        for (let j = 0; j <= i; ++j) {
            r.push(M[i][j]);
        }
    }

    return r;
}
