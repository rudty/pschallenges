function solution(n) {
    const mem = [0, 1, 2, 3, 5, 8, 13, 21];
    for (let i = 8; i <= n; ++i) {
        mem.push((mem[mem.length - 2] + mem[mem.length - 1]) % 1000000007);
    }
    return mem[n];
}
