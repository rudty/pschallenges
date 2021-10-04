select * from places p
where (select count(*) from places where host_id = p.host_id) > 1
order by id