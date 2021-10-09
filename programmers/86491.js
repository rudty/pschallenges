function solution(sizes) {
    let maxW = 0;
    let maxH = 0;
    for(const e of sizes) {
        if (e[0] < e[1]) {
            const t = e[0];
            e[0] = e[1];
            e[1] = t;
        }
        maxW = Math.max(maxW, e[0]);
        maxH = Math.max(maxH, e[1]);
    }
    
    return maxW * maxH;
}