function solution(n, money) {
    const mem = [];
    mem.length = n  + 1;
    mem.fill(0);
    money.sort((a, b) => a - b);
    mem[0] = 1;

    for (const m of money) {
        for (let i = m; i <= n; i += 1) {
            mem[i] += mem[i - m]; 
            mem[i] %= 1000000007;
        }
    }
    return mem[n];
}

