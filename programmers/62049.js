function solution(n) {
    const r = [0];
    n -= 1;
    for (let i = 0; i < n; ++i) {
        const size = r.length;
        for (let j = 0; j < size; ++j) {
            r.push(r[j]);
        }
        r.push(1);
    }
    return r;
}