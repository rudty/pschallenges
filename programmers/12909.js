function solution(s){
    let stackSize = 0;
    for (const e of s) {
        if (e === '(') {
            stackSize += 1;
        } else if (e === ')') {
            stackSize -= 1;
            if (stackSize < 0) {
                return false;
            }
        }
    }
    return stackSize === 0;;
}