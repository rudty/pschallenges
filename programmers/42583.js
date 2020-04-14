function addStepAndPop(q, bridge_length) {
    for (let i = 0; i < q.length; ++i) {
        q[i][1] += 1;
    }
    while (q.length && q[0][1] > bridge_length) {
        q.shift();
    }
    let weightSum = 0;
    for (let i = 0; i < q.length; ++i) {
        weightSum += q[i][0];
    }
    return weightSum;
}
function nextTurn(q, bridge_length, weight, truck_weights) {
    if (q.length === 0 && truck_weights.length === 0) {
        return false;
    }
    const bridgeWeight = addStepAndPop(q, bridge_length); 
    if (truck_weights.length) {
        if (bridgeWeight + truck_weights[0] <= weight) {
            const e = truck_weights.shift();
            q.push([e, 1]);
        }
    }
    return true;
}
function solution(bridge_length, weight, truck_weights) {
    const q = [];
    let count = 0;
    while (nextTurn(q, bridge_length, weight, truck_weights)) {
        count += 1;
    } 
    return count;
}
