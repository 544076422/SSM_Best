package cn.rbc.service;

import cn.rbc.domain.Syslog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SyslogService {
    List<Syslog> findAll();

    void save(Syslog syslog);
}
