select u.id, u.name, u.last_name, u.start_year, u.username, u.birthday, xref.hours as total_hours
from user u
LEFT JOIN user_event_xref xref
on u.id = xref.user_id
where xref.event_id = ?