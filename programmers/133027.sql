WITH H AS (
    SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDER
    from FIRST_HALF
    group by FLAVOR
),
J as (
    SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDER
    from JULY
    group by FLAVOR
)
select H.FLAVOR
from H
join J
on H.FLAVOR = J.FLAVOR
order by (H.TOTAL_ORDER + J.TOTAL_ORDER) desc
limit 3