"use strict";
function all(arr, x, y, size) {
    const e = arr[y][x];
    for (let i = y; i < y + size; ++i) {
        for (let j = x; j < x + size; ++j) {
            if (e !== arr[i][j]) {
                return [false, -1];
            }
        } 
    }
    return [true, e];
}

function getCount(arr, x, y, size) {
    const [isAll, value] = all(arr, x, y, size);
    if (isAll) {
        if (value === 0) {
            return [1, 0];
        } else {
            return [0, 1];
        }
    }

    const half = Math.floor(size / 2);
    const r = [];
    r.push(getCount(arr, x, y, half));
    r.push(getCount(arr, x + half, y, half));
    r.push(getCount(arr, x, y + half, half));
    r.push(getCount(arr, x + half, y + half, half));

    return r.reduce((acc, e) => {
        acc[0] += e[0]; 
        acc[1] += e[1];
        return acc;
    }, [0, 0]);
}

function solution(arr) {
    return getCount(arr, 0, 0, arr.length);
}

