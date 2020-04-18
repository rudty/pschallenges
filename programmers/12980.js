function solution(n) {
    let step = 0;
    while (n !== 0) {
        if (n & 1) {
            n -= 1;
            step += 1;
        } else {
            n /= 2;
        }
    }
    return step;
}
