package cn.rbc.service.impl;

import cn.rbc.dao.SyslogDao;
import cn.rbc.domain.Syslog;
import cn.rbc.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class SyslogServiceImpl implements SyslogService {
    @Autowired
    private SyslogDao syslogDao;
    @Override
    public List<Syslog> findAll() {
        return syslogDao.findAll();
    }

    @Override
    public void save(Syslog syslog) {
        syslogDao.save(syslog);
    }
}
