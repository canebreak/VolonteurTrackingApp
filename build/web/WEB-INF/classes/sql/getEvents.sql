SELECT
    e.name,
    COUNT(*)
FROM EVENT
    e
LEFT JOIN user_event_xref xref ON
    e.id = xref.event_id
where e.is_deleted = 0