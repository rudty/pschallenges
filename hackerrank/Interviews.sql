/**
 * SQL SERVER 
 */
; with CONTENT_RESULT as (
select 
    Contests.contest_id, 
    Contests.hacker_id, 
    Contests.[name], 
    isnull(sum(total_submissions),0) total_submissions,
    isnull(sum(total_accepted_submissions),0) total_accepted_submissions,
    isnull((select sum(total_views) 
    from Contests XC
    join Colleges
    on  Contests.contest_id = Colleges.contest_id
    join Challenges 
    on Challenges.college_id = Colleges.college_id
    join View_stats
    on Challenges.challenge_id = View_Stats.challenge_id
    where XC.contest_id = Contests.contest_id),0) total_views,
    isnull((select sum(total_unique_views) 
    from Contests XC
    join Colleges
    on  Contests.contest_id = Colleges.contest_id
    join Challenges 
    on Challenges.college_id = Colleges.college_id
    join View_stats
    on Challenges.challenge_id = View_Stats.challenge_id
    where XC.contest_id = Contests.contest_id),0) total_unique_views
from Contests
left join Colleges
on  Contests.contest_id = Colleges.contest_id
left join Challenges 
on Challenges.college_id = Colleges.college_id
left join Submission_Stats
on Submission_Stats.challenge_id = Challenges.challenge_id
group by 
    Contests.contest_id, 
    Contests.hacker_id, 
    Contests.[name]

) 
select * 
from CONTENT_RESULT
where total_submissions + total_accepted_submissions + total_views + total_unique_views > 0
order by 
    contest_id