function solution(s) {
    const r = s.split(" ").map(Number).sort((l, r) => l - r);
    return r[0] + " " + r[r.length - 1];
}