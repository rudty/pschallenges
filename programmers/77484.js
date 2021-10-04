function getRank(n) {
    switch(n) {
        case 6:
            return 1;
        case 5:
            return 2;
        case 4:
            return 3;
        case 3:
            return 4;
        case 2:
            return 5;
        default:
            return 6;
    }
} 

function solution(lottos, win_nums) {
    var zeroCount = 0;
    var existsCount = 0;
    for (var i = 0; i < lottos.length; ++i) {
        if (lottos[i] == 0) {
            zeroCount += 1;
            continue;
        }

        if (win_nums.includes(lottos[i])) {
            existsCount += 1;
        }
    }

    return [getRank(existsCount + zeroCount),  getRank(existsCount)];
}
