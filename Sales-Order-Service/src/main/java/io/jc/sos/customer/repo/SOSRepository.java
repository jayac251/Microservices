/**
 * 
 */
package io.jc.sos.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 197651
 *
 */
@Repository
public interface SOSRepository extends JpaRepository<CustomerSOS, Long> {


	

}
