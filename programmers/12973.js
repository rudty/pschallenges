function solution(s) {
    const stack = [];
    for (const e of s) {
        stack.push(e);
        while (stack.length && stack[stack.length - 1] === stack[stack.length - 2]) {
            stack.pop();
            stack.pop();
        }
    }
    if (stack.length) {
        return 0;
    }
    return 1;
}