function solution(new_id) {
    new_id = new_id.toLowerCase();
    new_id = new_id.replace(/[^a-z0-9\_\-\.]/g, "");
    new_id = new_id.replace(/\.\.+/g, ".");
    new_id = new_id.replace(/^\.+/g, "");
    new_id = new_id.replace(/\.+$/g, "");

    if (new_id.length === 0) {
        return "aaa";
    }

    if (new_id.length >= 16) {
        new_id = new_id.substring(0, 15);
        if (new_id[new_id.length - 1] === ".") {
            new_id = new_id.substring(0, 14);
        }
    }

    if (new_id.length === 1) {
        return "" + new_id[0] + new_id[0] + new_id[0];
    }

    if (new_id.length === 2) {
        return new_id + new_id[1];
    }

    return new_id;
}

const r = solution("...!@BaT#*..y.abcdefghijklm");
console.log(r);