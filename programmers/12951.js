function solution(s) {
    return s.split(" ")
        .map(e => {
            if (e.length > 0) {
                return e[0].toUpperCase() + e.substring(1).toLowerCase();
            }
            return "";
        })
        .join(" ");
}