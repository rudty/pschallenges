function gcd(a, b) {
    if (b != 0) {
        return gcd(b, a % b);
    }
    return a;
}

function solution(arr) {
    let g = arr[0];
    for (let i = 1; i < arr.length; ++i) {
        g = (arr[i] * g) / gcd(arr[i], g);
    }
    return g;
}
