function getRank(n) {
    if (n >= 90) {
        return "A";
    }
    if (n >= 80) {
        return "B";
    }
    if (n >= 70) {
        return "C";
    }
    if (n >= 50) {
        return "D";
    }
    return "F";
}
function solution(scores) {
    const result = [];
    const L = scores[0].length;
    for (let p = 0; p < L; ++p) {
        const mScore = scores[p][p];
        let maxValue = mScore;
        let minValue = mScore;
        let sameCount = 0;
        let S = 0;
        for (let i = 0; i < scores.length; ++i) {
            if (scores[i][p] === mScore) {
                sameCount += 1;
            }
            minValue = Math.min(scores[i][p], minValue);
            maxValue = Math.max(scores[i][p], maxValue);
            S += scores[i][p];
        }

        if (sameCount === 1 && 
            (minValue === mScore || maxValue === mScore)) {
            S -= mScore;
            result.push(getRank(S / (scores.length - 1)));
        } else {
            result.push(getRank(S / (scores.length)));
        }
    }
    return result.join("");
}
