function solution(clothes) {
    const o = {};
    for (const [k, v] of clothes) {
        const count = o[v] || 1;
        o[v] = count + 1;
    }
    
    let acc = 1;
    for (const k of Object.keys(o)) {
        const v = o[k];
        acc *= v;
    }
    return acc - 1;
}