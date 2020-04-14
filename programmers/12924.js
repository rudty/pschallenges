function solution(n) {
    const half = Math.ceil(n / 2);
    const mem = [];
    mem.length = n + 1;
    mem.fill(0);

    for (let i = 2; i <= half; ++i) {
        let s = 0;
        for (let j = i; j > 0; --j) {
            s += j;
            if (s > n) {
                break;
            }
            mem[s] += 1;
        }
    }
    return mem[n] + 1;
}
