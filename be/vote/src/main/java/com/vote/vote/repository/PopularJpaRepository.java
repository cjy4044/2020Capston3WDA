package com.vote.vote.repository;

import com.vote.vote.db.dto.Popular;
import com.vote.vote.db.dto.Program;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PopularJpaRepository extends JpaRepository<Popular, String> {

    public Popular findById(int id);
    
    
    public List<Popular> findByPid(int pid);
    
    @Transactional
    @Modifying
    void deleteByid(int id);   
    
   
    
    
    @Modifying
    @Transactional
    @Query("update Popular set p_name =:name, p_image =:image "
    		+ "				where program_id = :id and popular_id = :pid")
    void popularUpdate(
    					@Param("name") String name,    					
    					@Param("image") String image,
    					@Param("id") int program_id,
    					@Param("pid") int popular_id
    					);
    
    
}