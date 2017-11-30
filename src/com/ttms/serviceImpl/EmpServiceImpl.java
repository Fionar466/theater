package com.ttms.serviceImpl;

import com.ttms.dao.EmpDao;
import com.ttms.service.EmpService;
import com.ttms.utils.BeanFactory;
import com.ttms.vo.Employee;
import com.ttms.vo.PageBean;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 */
public class EmpServiceImpl implements EmpService {

    @Override
    public PageBean<Employee> findByPage(int pageSize, Integer currPage) throws Exception {
        EmpDao empDao = (EmpDao) BeanFactory.getBean("EmpDao");
        List<Employee> list = empDao.findByPage(currPage,pageSize);
        int totalCount = empDao.getTotalCount();
        return new PageBean<>(pageSize, currPage, totalCount, list);
    }
}