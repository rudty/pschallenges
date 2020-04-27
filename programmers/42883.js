function solution(number, k) {
    const r = [number[0]];
    for (let i = 1; i < number.length; ++i) {
        // 새로 추가하는 문자가 더 크다면
        while(k > 0 && r[r.length - 1] < number[i]) {
            r.length -= 1; // 맨 뒤 삭제
            k -= 1;
        }
        r.push(number[i]);
    }

    r.length = number.length - k; // 아직 다 지워지지 않았다면 뒤에걸 자름 
    
    return r.join("");
}
