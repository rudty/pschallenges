function solution(weights, head2head) {
    const r = [];
    for (let i = 0; i < weights.length; ++i) {
        let win = 0;
        let lose = 0;
        let winHeavy = 0;
        for (let j = 0; j < head2head[i].length; ++j) {
            if (head2head[i][j] === "W") {
                win += 1;
                if (weights[j] > weights[i]) {
                    winHeavy += 1;
                }
            }
            if (head2head[i][j] === "L") {
                lose += 1;
            }
        }
        let winRate = 0;
        if (win + lose > 0) {
            winRate = win / (win + lose) * 100;
        }
        r.push({
            winRate,
            winHeavy,
            heavy: weights[i],
            seq: i + 1,
        });
    }

    r.sort((a, b) => {
        if (Math.abs(a.winRate - b.winRate) > 0.00001) {
            return b.winRate - a.winRate;
        }

        if (a.winHeavy !== b.winHeavy) {
            return b.winHeavy - a.winHeavy;
        }

        if (a.heavy !== b.heavy) {
            return b.heavy - a.heavy;
        }

        return a.seq - b.seq;
    });

    return r.map(e => e.seq);

}

const r = solution(	[50, 82, 75, 120], ["NLWL", "WNLL", "LWNW", "WWLN"]);
console.log(r);