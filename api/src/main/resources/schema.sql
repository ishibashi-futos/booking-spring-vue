-- DROP TABLE IF EXISTS BOOKING;

CREATE TABLE IF NOT EXISTS BOOKING (
    id varchar2(255),
    room_id varchar2(255),
    start_date datetime,
    end_date datetime,
    create_date datetime,
    create_user_id varchar2(255),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS ROOMS;
CREATE TABLE IF NOT EXISTS ROOMS (
    room_id varchar2(255),
    room_name varchar2(255),
    PRIMARY KEY (room_id)
);
