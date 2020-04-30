function findPalin(s, it, r) {
    let left = it - 1;
    let right = it + r;
    let count = r;
    while (s[left] && s[right] && s[left] === s[right]) {
        left -= 1;
        right += 1;
        count += 2;
    }
    return count;
}

function solution(s) {
    let m = 1;
    for (let i = 1; i < s.length; ++i) {
        m = Math.max(m, findPalin(s, i, 0));
        m = Math.max(m, findPalin(s, i, 1));
    }
    return m;
}