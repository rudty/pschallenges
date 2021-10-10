function solution(n, wires) {
    let dis = Number.MAX_SAFE_INTEGER;
    for (let i = 0; i < n - 1; ++i) {
        const m = [...wires.slice(0, i), ...wires.slice(i + 1)];
        const visit = new Array(n + 1).fill(0);
        const q = [m[0][0], m[0][1]];
        while (q.length > 0) {
            const e = q.pop();

            if (visit[e]) {
                continue;
            }

            visit[e] = 1;

            for (let j = 0; j < m.length; ++j) {
                const a = m[j][0];
                const b = m[j][1];
                if (a === e && visit[b] === 0) {
                    q.push(b);
                }

                if (b === e && visit[a] === 0) {
                    q.push(a);
                }
            }
        }
        const r = visit.reduce((acc, e) => acc + e, 0);
        console.log(r, n - r, wires[i], visit);

        dis = Math.min(dis, Math.abs(r - (n - r)));
    }
    console.log(dis);
    return dis;
}

solution(9, [[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]);
solution(4, [[1,2],[2,3],[3,4]]);
solution(7, 	[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]);