/**
* SQL SERVER
*/
; with hacker_count as (
    select distinct
        submission_date, 
        hacker_id,
        case submission_date when '2016-03-01' then 1
        else isnull((select top 1 1 from Submissions where hacker_id = S.hacker_id and submission_date = DATEADD(day, -1, S.submission_date)),0) end cnt
    from Submissions S
)
, hacker_count_id as (
    select 
        submission_date, 
        sum(cnt) sum_cnt,
        (select top 1 
            hacker_id 
        from Submissions S 
        where 1=1 
             and S.submission_date = H.submission_date
        group by S.hacker_id, S.submission_date
        order by 
        count(*) desc, 
        S.hacker_id) as [hacker_id]
    from hacker_count H
    where 1=1
        and cnt = 1
        and isnull((select sum(cnt) from hacker_count C where C.submission_date < H.submission_date and C.hacker_id = H.hacker_id), 0) = DATEDIFF(day, '2016-03-01', submission_date)
    group by 
        submission_date
)
select C.*, H.[name]
from hacker_count_id C
join hackers H
on C.hacker_id = H.hacker_id
order by C.submission_date