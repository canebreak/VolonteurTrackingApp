SELECT
    e.id,
    e.name,
    e.date,
    e.start_time,
    e.end_time,
    e.place,
    xref.hours as hours_duration
FROM event AS
    e
LEFT JOIN user_event_xref xref ON
    e.id = xref.event_id
WHERE
    e.is_deleted = 0 and xref.is_deleted = 0 and
    xref.user_id = ?