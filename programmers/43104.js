function solution(N) {
    const mem = [0, 4, 6, 10, 16, 26];
    for (let i = 6; i <= N; ++i) {
        mem[i] = mem[mem.length - 1] + mem[mem.length - 2];
    }
    return mem[N];
}