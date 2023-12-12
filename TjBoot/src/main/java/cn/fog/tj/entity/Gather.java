package cn.fog.tj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Fog
 * @since 2023-12-04
 */
@TableName("x_gather")
public class Gather implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String year;

    private Integer yearnum;

    private String gatheruser;

    private Integer gatherusernum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public Integer getYearnum() {
        return yearnum;
    }

    public void setYearnum(Integer yearnum) {
        this.yearnum = yearnum;
    }
    public String getGatheruser() {
        return gatheruser;
    }

    public void setGatheruser(String gatheruser) {
        this.gatheruser = gatheruser;
    }
    public Integer getGatherusernum() {
        return gatherusernum;
    }

    public void setGatherusernum(Integer gatherusernum) {
        this.gatherusernum = gatherusernum;
    }

    @Override
    public String toString() {
        return "Gather{" +
            "id=" + id +
            ", year=" + year +
            ", yearnum=" + yearnum +
            ", gatheruser=" + gatheruser +
            ", gatherusernum=" + gatherusernum +
        "}";
    }
}
