function solution(numbers) {
    var answer = [];

    for (let number of numbers) {
        number = BigInt(number);
        if ((number & 1n) === 0n) {
            answer.push(number + 1n);
        } else {
            for (let i = 1n;; i *= 2n) {
                if ((number & i) === 0n) {
                    answer.push((number + (i / 2n)));   
                    break;
                }
            }
        }
    }

    return answer;
}
