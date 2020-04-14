const results = [];
function recur(g, current, visit, all, step) {
    if (visit === all) {
        results.push(step);
    }
    const to = g[current];
    if (to) {
        for (let i = 0; i < to.length; ++i) {
            const e = to[i];
            if (e[1] === false) {
                e[1] = true;
                recur(g, e[0], visit + 1, all, [...step, e[0]]);
                e[1] = false;
            }
        }
    }
}
function solution(tickets) {
    const g = {};
    for (const ticket of tickets) {
        const to = g[ticket[0]] || [];
        to.push([ticket[1], false]);
        g[ticket[0]] = to;
    }

    recur(g, "ICN", 0, tickets.length, ["ICN"]);
    results.sort();
    return results[0];
}
