function solution(genres, plays) {
    const totalPlay = {};
    const musics = [];
    for (let i = 0; i < genres.length; ++i) {
        const v = totalPlay[genres[i]] || 0;
        totalPlay[genres[i]] = v + plays[i];
        musics[i] = [genres[i], plays[i], i];
    }


    musics.sort((l, r) => {
        if (l[0] !== r[0]) {
            return totalPlay[l[0]] - totalPlay[r[0]];
        }
        if (l[1] !== r[1]) {
            return l[1] - r[1];
        }
        return r[2] - l[2];
    });

    const result = [];
    const outCount = {};
    for (let i = musics.length - 1; i >= 0; --i) {
        const [genre, playTime, it] = musics[i];
        const v = outCount[genre] || 0;
        if (v !== 2) {
            result.push(it);
            outCount[genre] = v + 1;
        }
    }

    return result;
}