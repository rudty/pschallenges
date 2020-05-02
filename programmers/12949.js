function solution(arr1, arr2) {
    const r = [];
    for (let i = 0; i < arr1.length; ++i) {
        r[i] = [];
        r[i].length = arr2[0].length;
        r[i].fill(0);
    }


    for (let i = 0; i < r.length; ++i) {
        for (let j = 0; j < r[i].length; ++j) {
            for (let k = 0; k < arr1[0].length; ++k) {
                r[i][j] += (arr1[i][k] * arr2[k][j]);
            }
        }
    }
    return r;
}
