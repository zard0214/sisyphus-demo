package com.sisyphus.demo.data.jpa.domain.primary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * @author zard
 * @date Created in 09/06/2022 04:21
 */
@Data
@Entity
@Table(name = "primary_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrimaryTable {

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
