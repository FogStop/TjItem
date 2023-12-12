package cn.fog.tj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Fog
 * @since 2023-11-30
 */
@TableName("x_za")
public class Za implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String address;

    private String board;

    private LocalDateTime times;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }
    public LocalDateTime getTimes() {
        return times;
    }

    public void setTimes(LocalDateTime times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "Za{" +
            "id=" + id +
            ", name=" + name +
            ", address=" + address +
            ", board=" + board +
            ", times=" + times +
        "}";
    }
}
