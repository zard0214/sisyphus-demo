package com.sisyphus.demo.data.jpa.domain.secondary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zard
 * @date Created in 09/06/2022 04:21
 */
@Data
@Entity
@Table(name = "secondary_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecondaryTable {

    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 名称
     */
    private String name;

}
