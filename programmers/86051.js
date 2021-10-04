function solution(numbers) {
    const a = [0,1,2,3,4,5,6,7,8,9];
    for (let i = 0; i < numbers.length; ++i) {
        a[numbers[i]] = 0;
    }
    return a.reduce((acc, e) => acc + e);
}