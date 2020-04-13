function divString(p) {
    let leftCount = 0;
    let rightCount = 0;

    const builder = [];

    for (const e of p) {
        if (e === '(') {
            leftCount += 1;
        } else if (e === ')') {
            rightCount += 1;
        }
        builder.push(e);
        
        if (leftCount === rightCount) {
            return [builder.join(""), p.substring(leftCount + rightCount)];
        }
    }
    return [builder.join(""), ""];
}

function isOk(s) {
    let stackCount = 0;
    for (const e of s) {
        if (e === '(') {
            stackCount += 1;
        } else if (e === ')') {
            stackCount -= 1;
        } 

        if (stackCount < 0) {
            return false;
        }
    }
    return stackCount === 0;
}

function reversep(s) {
    // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
    const builder = [];
    for (let i = 1; i < s.length - 1; ++i) {
        const e = s[i];
        if (e === '(') {
            builder.push(')');
        } else if (e === ')') {
            builder.push('(');
        }  
    }
    return builder.join("");
}

function solution(p) {
    if (p.length === 0) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
        return p;
    }

    // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
    const [u, v] = divString(p);
    
    if (isOk(u)) {
        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
        // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
        return u + solution(v); 
    } else {
         // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
         // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
         // 4-3. ')'를 다시 붙입니다. 
         // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
         // 4-5. 생성된 문자열을 반환합니다.
         return "(" + solution(v) + ")" + reversep(u);
    }
}
