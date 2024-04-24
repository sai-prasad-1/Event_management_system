package io.levantate.eventmanagement.DTO;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookingDTO {
    private Long hallId;
    private int time;
    private Long userId;
    private String theme;
    private Date timestamp;

    @Override
    public String toString() {
        return "BookingDTO{" +
                "hallId=" + hallId +
                ", time=" + time +
                ", userId=" + userId +
                ", theme='" + theme + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
