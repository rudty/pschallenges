const cache = [];
cache.findFromCache = (v) => {
    for (let i = 0; i < cache.length; ++i) {
        if (cache[i] === v) {
            return i;
        }
    }
    return -1;
}
function solution(cacheSize, cities) {
    let time = 0;
    for (let city of cities) {
        city = city.toLowerCase();
        const f = cache.findFromCache(city);
        if (f !== -1) {
            cache.splice(f, 1);
            time += 1;
        } else {
            time += 5;
        }
        cache.push(city);
        if (cache.length > cacheSize) {
            cache.splice(0, 1);
        }
    }
    return time;
}