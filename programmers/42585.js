function solution(arrangement) {
    let sum = 0;
    let level = 0;
    for (let i = 0; i < arrangement.length; ++i) {
        if (arrangement[i] === '(') {
            if (arrangement[i + 1] === ')') {
                sum += level;
                i += 1;
            } else {
                level += 1;
            }
        } else if (arrangement[i] === ')') {
            sum += 1;
            level -= 1;
        }
    }
    return sum;
}