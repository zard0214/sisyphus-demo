package com.sisyphus.demo.data.jpa.repository.primary;

import com.sisyphus.demo.data.jpa.domain.primary.PrimaryTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author zard
 * @date Created in 09/06/2022 04:21
 */
@Repository
public interface PrimaryTableRepository extends JpaRepository<PrimaryTable, Long> {


}
