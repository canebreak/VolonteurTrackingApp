SELECT
    u.id,
    u.name,
    u.last_name,
    u.birthday,
    u.start_year,
    u.password,
    u.is_admin,
    SUM(xref.hours) total_hours,
    u.username
FROM
    USER u
LEFT JOIN user_event_xref xref ON
    u.id = xref.user_id
LEFT JOIN event e ON
    xref.event_id = e.id
WHERE
    u.is_deleted = 0 AND xref.is_deleted = 0 AND e.is_deleted = 0 AND u.id = ?
GROUP BY
    u.id
ORDER BY
    u.id