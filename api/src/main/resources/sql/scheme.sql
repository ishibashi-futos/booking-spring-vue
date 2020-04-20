CREATE TABLE IF NOT EXISTS BOOKING (
    id varchar2(255),
    room_id varchar2(255),
    start_date datetime,
    end_date datetime,
    create_date datetime,
    create_user varchar2(255),
    PRIMARY KEY (id)
);
