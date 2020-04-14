function getMaxWithoutIndex(row, it) {
    let maxValue = 0;
    for (let i = 0; i < row.length; ++i) {
        if (i === it) {
            continue;
        }
        maxValue = Math.max(maxValue, row[i]);
    }
    return maxValue;
}

function solution(land) {
    for (let i = 1; i < land.length; ++i) {
        for (let j = 0; j < land[i].length; ++j) {
            land[i][j] += getMaxWithoutIndex(land[i - 1], j);
        }
    }

    return getMaxWithoutIndex(land[land.length - 1], -1);
}