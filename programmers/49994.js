function solution(dirs) {
    const visit = { };
    let ax = 0;
    let ay = 0;
    let x = 0;
    let y = 0;

    for (const p of dirs) {
        ax = x;
        ay = y;
        switch (p) {
            case "U":
                y -= 1;
                y = Math.max(y, -5);
                break;
            case "L":
                x -= 1;
                x = Math.max(x, -5);
                break;
            case "R":
                x += 1;
                x = Math.min(x, 5);
                break;
            case "D":
                y += 1;
                y = Math.min(y, 5);
                break;
        }

        if (ax === x && ay === y) {
            continue;
        }

        let wAx, wAy, wX, wY;
        if (ax <= x) {
            wAx = ax;
            wX = x;
        } else {
            wAx = x;
            wX = ax;
        }

        if (ay <= y) {
            wAy = ay;
            wY = y;
        } else {
            wAy = y;
            wY = ay;
        }

        visit[`${wAx}:${wAy}=${wX}:${wY}`] = true;
    }

    return Object.keys(visit).length;
}
