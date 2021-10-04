package org.g.time;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TIME_DEMO")
public class TimeDemoVo {
    @Id
    private int id;

    /**
     * Java 8 date/time type `java.time.LocalDateTime` not supported by default:
     * add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private LocalDateTime ctime;
}
