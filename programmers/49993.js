function checkSkillTree(skill, skill_tree) {
    let step = 0;
    for (const e of skill_tree) {
        if (e === skill[step]) {
            step += 1;
        } else {
            for (let i = skill.length - 1; i > step; --i) {
                if (skill[i] === e) {
                    return false;
                }          
            }
        }
    }
    return true;
}
function solution(skill, skill_trees) {
    let count = 0;
    for (const skill_tree of skill_trees) {
        if (checkSkillTree(skill, skill_tree)) {
            count += 1;
        }
    } 
    return count;
}