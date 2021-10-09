const maxNum = Number.MAX_SAFE_INTEGER;
function solution(maps) {
    const s = [[0, 0, 0]];
    const step = new Array(maps.length).fill().map(() => new Array(maps[0].length).fill(maxNum));

    const destX = maps[0].length - 1;
    const destY = maps.length - 1;

    while (s.length > 0) {
        const [x, y, move] = s.shift();

        if (x < 0 || 
            x >= maps[0].length ||
            y < 0 || 
            y >= maps.length || 
            maps[y][x] === 0) {
            continue;
        }

        const e = step[y][x];

        if (e === 0 || move >= e) {
            continue;
        }

        step[y][x] = move;
        maps[y][x] = 0;

        s.push([x + 1, y, move + 1]);
        s.push([x - 1, y, move + 1]);
        s.push([x, y + 1, move + 1]);
        s.push([x, y - 1, move + 1]);
    }

    const o = step[destY][destX];
    if (o === maxNum) {
        return -1;
    } else {
        return o + 1;
    }
}
