function solution(operations) {
    const arr = [];
    for (const operation of operations) {
        if (operation[0] === "I") { // insert
            const v = Number(operation.substring(2));
            arr.push(v);
        } else if (operation[2] === "-") { // remove
            arr.splice(0, 1);
        } else {
            arr.splice(arr.length - 1, 1);
        }
        arr.sort((a, b) => a - b);
    }
    if (arr.length) {
        return [arr[arr.length - 1], arr[0]];
    }
    return [0, 0];
}