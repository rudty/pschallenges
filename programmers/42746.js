function solution(numbers) {
    numbers.sort((l, r) => {
        return (String(r) + l).localeCompare(String(l) + r);
    });

    if (numbers[0] === 0) {
        return "0";
    }
    return numbers.reduce((acc, e) => acc + e, "");
}
