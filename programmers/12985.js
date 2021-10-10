function doNext(x) {
    if (x % 2 === 0) {
        return Math.floor(x / 2);
    } 

    if (x === 1) {
        return 1;
    }

    return Math.floor(x / 2) + 1;
}

function solution(n, a, b) {
    if (a > b) {
        const t = b;
        b = a;
        a = t;
    }

    let r = 1;
    while (true) {
        if (b - a === 1 && b % 2 === 0) {
            break;
        }

        a = doNext(a);
        b = doNext(b);
        r += 1;
    }

    return r;
}
