# 予約情報

* 物理名: Booking

| column name | type | length | pk | required |
| :-- | :-- | :-- | :-- | :-- | :-- |
| room_id | String(UUID) | 63 | pk_booking | true |
| start_date | datetime | - | pk_booking | true
| end_date | datetime | - | - | true |
| create_date | datetime | - | - | true |
| create_user | string | 255 | - | true |