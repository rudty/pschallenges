function solution(budgets, M) {
    budgets.sort((a, b) => a - b);
    let avg = 0;
    for (let i = 0; i < budgets.length; ++i) {
         avg = Math.floor(M / (budgets.length - i));

        if (budgets[budgets.length - 1] <= avg) {
            return budgets[budgets.length - 1];
        }

        if (avg < budgets[i]) {
            break;
        }
        M -= budgets[i];
    }
    return avg;
}