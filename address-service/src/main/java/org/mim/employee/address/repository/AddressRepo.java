package org.mim.employee.address.repository;

import org.mim.employee.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepo  extends JpaRepository<Address,Integer> {
    //address based on a employee id
    @Query( nativeQuery = true, value = "SELECT ea.id,ea.lane1,ea.lane2,ea.state,ea.zip FROM emlpoyee.address ea join emlpoyee.employee e on e.id=ea.employee_id Where ea.employee_id= :employeeId;")
    Address findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
