function replaceSharp(m) {
    return m.replace(/C\#/g, "H")
    .replace(/D\#/gi, "I") 
    .replace(/F\#/gi, "J") 
    .replace(/G\#/gi, "K") 
    .replace(/A\#/gi, "L")
    .replace(/E\#/gi, "M")
    .replace(/B\#/gi, "N");
}

function parseTime(timeArray) {
    // [HH, MM]
    return Number(timeArray[0]) * 60 + Number(timeArray[1]);
}

function getrhythm(rhythm, duration) {
    rhythm = replaceSharp(rhythm);

    if (duration < rhythm.length) {
        // 없어도 아래의 로직으로 처리할수 있지만 
        // GC 문제로
        // 처리속도 심각하게 떨어짐... 
        // 시간 초과
        return rhythm.substring(0, duration);
    }

    // duration 11
    // rhythm AB
    // => ABABABABABA
    // 같이 duration 만큼 반복

    const count = Math.floor(duration / rhythm.length);
    const r = [];
    for (let i = 0; i < count; ++i) {
        r.push(rhythm);
    }
    const mod = duration % rhythm.length;
    r.push(rhythm.substring(0, mod));
    return r.join("");
}

function rhythmCompareTo(a, b) {
    // 조건이 일치하는 음악이 여러 개일 때에는 
    // 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 
    // 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
    if (b.duration !== a.duration) {
        return b.duration -  a.duration; 
    }
    return a.index - b.index;
}

function solution(m, musicinfos) {
    m = replaceSharp(m);
    musicinfos = musicinfos.map((e, index) => {
        const s = e.split(",");
        const beginTime = parseTime(s[0].split(":"));
        const endTime = parseTime(s[1].split(":"));
        const duration = endTime - beginTime;
        
        const rhythm = getrhythm(s[3], duration);
        return {
            index,
            duration,
            name: s[2],
            rhythm,
        }
    });

    const r = musicinfos
        .filter(e => e.rhythm.indexOf(m) !== -1)
        .sort(rhythmCompareTo);

    if (r.length > 0) {
        return r[0].name;
    }
    return "(None)";
}