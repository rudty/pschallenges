function getCount(n) {
    if (n === 1) {
        return 1;
    }
    const half = Math.floor(n / 2);
    let count = 2;
    for (let i = 2; i <= half; ++i) {
        if (n % i === 0) {
            count += 1;
        }
    }
    return count;
}

function solution(left, right) {
    let S = 0;
    for (let i = left; i <= right; ++i) {
        const c = getCount(i);
        if (c % 2 === 0) {
            S += i
        } else {
            S -= i;
        }
    }
    return S;
}

