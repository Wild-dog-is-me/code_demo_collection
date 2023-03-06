package org.dog.server.domain;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_company")
public class Company{
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String comName;
    private String industry;
    private String province;
    private String round;
    private String comScale;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime foundDate;
    private String regCapital;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    
    public Company(Company company) {
        if (Objects.nonNull(company)) {
            this.id=company.id;
            this.comName=company.comName;
            this.industry=company.industry;
            this.province=company.province;
            this.round=company.round;
            this.comScale=company.comScale;
            this.foundDate=company.foundDate;
            this.regCapital=company.regCapital;
            this.createTime=company.createTime;
            this.updateTime=company.updateTime;
        }
    }
}
