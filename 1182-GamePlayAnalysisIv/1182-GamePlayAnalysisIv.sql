-- Last updated: 9/3/2025, 10:48:08 AM
with min_dates as (
    select player_id, min(event_date) as min_event_date
    from activity
    group by player_id)
select round(sum(datediff(a.event_date, m.min_event_date) = 1) / count(distinct a.player_id), 2) as fraction
from activity as a
join min_dates as m
on a.player_id = m.player_id;
