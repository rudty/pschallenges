const ENTER_MESSAGE = "님이 들어왔습니다.";
const LEAVE_MESSAGE = "님이 나갔습니다.";

function solution(record) {
    const output = [];
    const idNickname = {};
    for (const message of record) {
        const c = message.split(" ");
        switch (c[0]) {
            case "Enter":
                output.push([c[1], ENTER_MESSAGE]);
                idNickname[c[1]] = c[2];
                break;
            case "Leave":
                output.push([c[1], LEAVE_MESSAGE]); 
                break;
            case "Change":
                idNickname[c[1]] = c[2]; 
                break;
        }
    }

    return output.map(e => idNickname[e[0]] + e[1]);
}
