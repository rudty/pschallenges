function covert(n) {
    let num = "";

    for (let i = 1; i < 150001; i *= 2) {
        if (i > n) {
            break;
        }

        if ((n & i) === i) {
            num = "1" + num;
        } else {
            num = "0" + num;
        }
    } 

    return num;
}

function solution(s) {
    const r = [0, 0];

    while (s !== "1") {
        const rm = s.replace(/0/g, ""); 
        const changeLen = s.length - rm.length;
        r[0] += 1;
        r[1] += changeLen;
        s = covert(rm.length);
    }
    
    return r;
}

solution("110010101001");