function solution(price, money, count) {
    let S = 0;
    for (let i = 1; i <= count; ++i) {
        S += i * price;        
    }
    return Math.max(S - money, 0);
}
