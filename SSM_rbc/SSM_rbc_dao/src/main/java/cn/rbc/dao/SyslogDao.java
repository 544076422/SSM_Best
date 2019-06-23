package cn.rbc.dao;

import cn.rbc.domain.Syslog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SyslogDao {
    @Select("select * from syslog")
    List<Syslog> findAll();

    @Insert("insert into syslog name (visitTime,username,ip,url,executionTime,method) values (#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(Syslog syslog);
}
