SELECT
    u.id,
    u.name,
    u.last_name,
    u.birthday
FROM
    USER u
LEFT JOIN user_event_xref xref ON
    u.id = xref.user_id
WHERE
    u.id NOT IN(
    SELECT
        u.id
    FROM
        USER u
    LEFT JOIN user_event_xref xref ON
        u.id = xref.user_id
    WHERE
        xref.event_id = ?
        and xref.is_deleted = 0
)
and u.is_deleted = 0