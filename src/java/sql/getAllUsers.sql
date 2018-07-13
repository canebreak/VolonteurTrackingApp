SELECT u.id, u.name, u.last_name, u.birthday, u.start_year,
 u.username, sum(xref.hours) total_hours FROM user u
left join user_event_xref xref
on u.id = xref.user_id

where u.is_deleted=0

group by u.id
order by u.id